package com.keresman.worms.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WormsApplication extends Application {

    private static final int SCENE_WIDTH = 400;
    private static final int SCENE_HEIGHT = 200;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Worms Armageddon");
        stage.setScene(new Scene(new Label("Welcome to Worms Armageddon!"), SCENE_WIDTH, SCENE_HEIGHT));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
