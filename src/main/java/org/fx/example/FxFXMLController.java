package org.fx.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FxFXMLController {
    @FXML
    private TextField inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    public FxFXMLController() {
    }

    @FXML
    private void initialize() {
    }

    @FXML
    private void printOutput() {
        outputText.setText(inputText.getText());
        System.out.println(location);
        System.out.println(resources);
    }
}
