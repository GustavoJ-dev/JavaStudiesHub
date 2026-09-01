package praticas.bolsaagora.server;

import praticas.bolsaagora.model.Ativo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * Servidor principal da aplicação BolsaAgora.
 *
 * <p>Utiliza a API NIO para permitir o gerenciamento de múltiplas
 * conexões através de um único {@link Selector}.</p>
 *
 * <p>O servidor recebe o código de um ativo, consulta os ativos
 * disponíveis em memória e devolve sua cotação ao cliente.</p>
 */
public class BolsaAgoraServer {

    private static final int PORT = 8080;

    private static final Ativo[] ATIVOS = {
            new Ativo("PETR4", 38.50),
            new Ativo("VALE3", 62.30),
            new Ativo("ITUB4", 35.80),
            new Ativo("ABEV3", 14.25),
            new Ativo("BBAS3", 28.90)
    };

    /**
     * Inicializa o servidor e permanece aguardando conexões.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        try (Selector selector = Selector.open();
             ServerSocketChannel serverChannel = ServerSocketChannel.open()) {

            serverChannel.bind(new InetSocketAddress(PORT));

            serverChannel.configureBlocking(false);

            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("BolsaAgora iniciada na porta " + PORT);

            while (true) {

                selector.select();

                Set<SelectionKey> selectedKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectedKeys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();

                    iterator.remove();

                    if (key.isAcceptable()) {

                        aceitarCliente(selector, key);
                    }

                    if (key.isReadable()) {

                        processarSolicitacao(key);
                    }
                }
            }

        } catch (IOException e) {

            System.out.println("Erro no servidor BolsaAgora.");

            e.printStackTrace();
        }
    }

    /**
     * Aceita uma nova conexão de cliente e registra o canal
     * no selector para receber eventos de leitura.
     *
     * @param selector selector responsável pelo gerenciamento
     *                 das conexões
     * @param key      chave que representa o canal do servidor
     * @throws IOException caso ocorra um erro de entrada ou saída
     */
    private static void aceitarCliente(Selector selector, SelectionKey key) throws IOException {

        ServerSocketChannel server = (ServerSocketChannel) key.channel();

        SocketChannel client = server.accept();

        if (client != null) {

            client.configureBlocking(false);

            client.register(selector, SelectionKey.OP_READ);

            System.out.println("Cliente conectado: " + client.getRemoteAddress());
        }
    }

    /**
     * Lê uma solicitação enviada pelo cliente, processa o código
     * do ativo e envia a resposta através do SocketChannel.
     *
     * @param key chave que representa o canal do cliente
     * @throws IOException caso ocorra um erro de comunicação
     */
    private static void processarSolicitacao(SelectionKey key) throws IOException {

        SocketChannel client = (SocketChannel) key.channel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int bytesRead = client.read(buffer);

        if (bytesRead == -1) {

            System.out.println("Cliente desconectado.");

            client.close();

            return;
        }

        if (bytesRead == 0) {

            return;
        }

        buffer.flip();

        String solicitacao = StandardCharsets.UTF_8
                        .decode(buffer)
                        .toString()
                        .trim();

        System.out.println("Solicitação: " + solicitacao);

        String resposta = processarComando(solicitacao);

        ByteBuffer responseBuffer = StandardCharsets.UTF_8.encode(resposta);

        while (responseBuffer.hasRemaining()) {

            client.write(responseBuffer);
        }
    }

    /**
     * Procura um ativo pelo seu código e retorna sua cotação.
     *
     * @param solicitacao código do ativo solicitado pelo cliente
     * @return cotação do ativo ou mensagem informando que o ativo
     * não foi encontrado
     */
    private static String processarComando(String solicitacao) {

        for (Ativo ativo : ATIVOS) {

            if (ativo.codigo().equalsIgnoreCase(solicitacao)) {

                return ativo.codigo() + ": R$ " + ativo.preco();
            }
        }

        return "Ativo não encontrado.";
    }
}


