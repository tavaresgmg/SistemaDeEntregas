package com.teamg.entregas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        try {
            //carregando o arquivo FXML
            Parent root = FXMLLoader.load(getClass().getResource("/interface.fxml"));
            //definindo a cena
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sistema de Entregas");
            primaryStage.show();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main (String[] args) {
        launch(args);
    }
}