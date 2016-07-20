package org.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.fx.model.BasicModel;

public class BasicController {
    @FXML
    private TextField field;

    private BasicModel basicModel;

    @FXML
    public void initialize() {
        basicModel = new BasicModel("");

        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
