package praticas.bolsaagora.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Cliente da aplicação BolsaAgora.
 *
 * <p>Estabelece uma conexão TCP com o servidor utilizando
 * {@link SocketChannel} e permite consultar vários ativos
 * durante a mesma conexão.</p>
 */
public class BolsaAgoraClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    /**
     * Inicia o cliente, estabelece a conexão com o servidor
     * e permite que o usuário consulte ativos.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        try (SocketChannel socketChannel = SocketChannel.open();
                Scanner scanner = new Scanner(System.in)) {

            socketChannel.connect(new InetSocketAddress(HOST, PORT));

            System.out.println("""
                        =================================
                              BOLSAAGORA - CLIENTE
                        =================================
                        Conectado à BolsaAgora.
                        Digite o código do ativo.
                        Digite 'sair' para encerrar.
                        """);

            System.out.println();

            while (true) {

                System.out.print("Ativo: ");

                String solicitacao = scanner.nextLine();

                if (solicitacao.equalsIgnoreCase("sair")) {

                    System.out.println("Encerrando cliente...");

                    break;
                }

                if (solicitacao.isBlank()) {

                    continue;
                }

                enviarSolicitacao(socketChannel, solicitacao);

                String resposta = receberResposta(socketChannel);

                System.out.println("Resposta: " + resposta);

                System.out.println();
            }

        } catch (IOException e) {

            System.out.println("Erro de comunicação com o servidor.");

            e.printStackTrace();
        }
    }

    /**
     * Envia uma solicitação textual para o servidor.
     *
     * @param socketChannel canal utilizado para comunicação
     * @param solicitacao código do ativo solicitado
     * @throws IOException caso ocorra um erro de comunicação
     */
    private static void enviarSolicitacao(SocketChannel socketChannel, String solicitacao) throws IOException {

        ByteBuffer requestBuffer = StandardCharsets.UTF_8.encode(solicitacao);

        while (requestBuffer.hasRemaining()) {

            socketChannel.write(requestBuffer);
        }
    }

    /**
     * Aguarda e lê a resposta enviada pelo servidor.
     *
     * @param socketChannel canal utilizado para comunicação
     * @return resposta recebida do servidor
     * @throws IOException caso ocorra um erro de comunicação
     */
    private static String receberResposta(SocketChannel socketChannel) throws IOException {

        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);

        int bytesRead = socketChannel.read(responseBuffer);

        if (bytesRead == -1) {

            throw new IOException("Servidor encerrou a conexão.");
        }

        responseBuffer.flip();

        return StandardCharsets.UTF_8.decode(responseBuffer).toString();
    }
}