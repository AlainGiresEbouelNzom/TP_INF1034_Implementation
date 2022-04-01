package com.example.tp_inf1034_implementation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AccueilController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}