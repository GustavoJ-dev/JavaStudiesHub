package com.gustavo.MainApp;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new FXMLLoader().load(getClass().getResource("/fxml/MainWindow.fxml"));

    }
}

