package praticas.bolsaagora.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BolsaAgoraServer {

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8080)){

            System.out.println("Servidor BolsaAgora Iniciado.");
            System.out.println("Aguardando conexões...");

            Socket client = serverSocket.accept();

            System.out.println("Cliente Conectado: " + client.getInetAddress());

            client.close();


        }catch (IOException e){

            e.printStackTrace();
        }

    }
}
