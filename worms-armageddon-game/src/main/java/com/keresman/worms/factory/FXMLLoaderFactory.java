package com.keresman.worms.factory;

import javafx.fxml.FXMLLoader;

import java.net.URL;

public final class FXMLLoaderFactory {

    private FXMLLoaderFactory() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static FXMLLoader create(String fxmlPath, Class<?> rootClass) {
        URL fxmlUrl = rootClass.getResource(fxmlPath);
        if (fxmlUrl == null) {
            throw new IllegalArgumentException("FXML not found: %s".formatted(fxmlPath));
        }

        return new FXMLLoader(fxmlUrl);
    }
}
