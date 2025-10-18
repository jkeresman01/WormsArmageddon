package com.keresman.worms.utility;

import javafx.scene.control.Alert;

public final class MessageUtils {

    private MessageUtils() {
        // Suppresses default constructor, ensuring non-instantiability.
    }

    public static void showInfoMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFO");
        alert.setContentText(message);
        alert.show();
    }

    public static void showWarningMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setContentText(message);
        alert.show();
    }

    public static void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(message);
        alert.show();
    }
}
