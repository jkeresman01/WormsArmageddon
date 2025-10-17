package com.keresman.worms;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import static com.keresman.worms.utility.FXMLUtils.loadScene;

public class WormsApplication extends Application {

    private static final String SPLASH_SCREEN_VIEW_PATH = "view/splash-screen-view.fxml";
    private static final String WORMS_ARMAGEDDON = "Worms Armageddon";

    private static final int SCENE_WIDTH = 400;
    private static final int SCENE_HEIGHT = 200;

    @Override
    public void start(Stage stage) throws IOException {
        loadScene(stage,
                SPLASH_SCREEN_VIEW_PATH,
                SCENE_WIDTH,
                SCENE_HEIGHT,
                WORMS_ARMAGEDDON,
                WormsApplication.class);
    }

    public static void main(String[] args) {
        launch();
    }
}
