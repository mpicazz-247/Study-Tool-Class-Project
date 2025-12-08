package com.example.studytool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/studytool/main.fxml"));
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Pomodoro Study Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
