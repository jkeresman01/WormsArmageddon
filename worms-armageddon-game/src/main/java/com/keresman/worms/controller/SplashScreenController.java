package com.keresman.worms.controller;

import com.keresman.worms.utility.MessageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SplashScreenController {

    @FXML
    private Button btnMilica;

    public void onButtonClick() {
        MessageUtils.showInfoMessage("Milica na plazi!");
    }
}
