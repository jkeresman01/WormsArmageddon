package com.keresman.worms.utility;

import com.keresman.worms.factory.FXMLLoaderFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public final class FXMLUtils {

    private FXMLUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static void loadScene(Stage stage,
                                 String fxmlPath,
                                 double width,
                                 double height,
                                 String title,
                                 Class<?> rootClass) throws IOException {
        FXMLLoader loader = FXMLLoaderFactory.create(fxmlPath, rootClass);
        Parent root = loader.load();

        Scene scene = new Scene(root, width, height);
        stage.setTitle(title);
        stage.setScene(scene);

        stage.show();
    }

    public static FXMLLoader loadFXML(String fxmlPath, Class<?> clazz) throws IOException {
        FXMLLoader loader = FXMLLoaderFactory.create(fxmlPath, clazz);
        loader.load();
        return loader;
    }

    public static void switchScene(Stage stage, String fxmlPath) throws IOException {
        URL resource = Objects.requireNonNull(FXMLUtils.class.getResource(fxmlPath));
        Parent root = FXMLLoader.load(resource);
        stage.getScene().setRoot(root);
    }
}

