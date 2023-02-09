package com.example.taskagitmakas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameAplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Taş Kağıt Makas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}