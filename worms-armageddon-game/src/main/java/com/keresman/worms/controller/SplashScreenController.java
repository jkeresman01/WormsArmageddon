package com.keresman.worms.controller;

import com.keresman.worms.utility.MessageUtils;
import javafx.event.ActionEvent;

public class SplashScreenController {

    public void onHelloButtonClick(ActionEvent actionEvent) {
        MessageUtils.showInfoMessage("Milica na plazi!");
    }
}
