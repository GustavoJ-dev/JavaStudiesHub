package com.gustavo.mainapp;


import com.gustavo.mainapp.cineticket.SessaoRepositorio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe principal da aplicação CineTicket.
 *
 * Responsável por inicializar a aplicação JavaFX, carregar a interface
 * definida no arquivo App.fxml, configurar a janela principal e iniciar
 * a execução do sistema.
 *
 * Também realiza o salvamento das sessões cadastradas quando a aplicação
 * é encerrada.
 */
public class MainApp extends Application {

    /**
     * Inicializa a interface gráfica da aplicação.
     *
     * Carrega o arquivo App.fxml, cria a cena principal, configura o título
     * e o tamanho da janela e exibe o palco.
     *
     * @param stage palco principal da aplicação JavaFX
     * @throws Exception caso ocorra algum erro durante o carregamento da interface
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLLoader().load(getClass().getResource("/App.fxml"));
        Scene scene = new Scene(root, 900, 500);

        stage.setTitle("CineTicket");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Executa os procedimentos necessários antes do encerramento da aplicação.
     *
     * Grava as sessões cadastradas utilizando o repositório de sessões,
     * garantindo a persistência dos dados antes que a aplicação seja finalizada.
     *
     * @throws IOException caso ocorra um erro durante a gravação das sessões
     */
    @Override
    public void stop() throws IOException{

        SessaoRepositorio.getInstance().gravarSessoes();
    }

    /**
     * Método principal responsável por iniciar a aplicação JavaFX.
     *
     * @param args argumentos fornecidos pela linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
}

