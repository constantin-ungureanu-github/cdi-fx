package org.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.fx.model.BasicModel;

public class BasicController {
    @FXML
    private TextField field;

    private BasicModel basicModel;

    private Stage myStage;
    public void setStage(final Stage stage) {
         myStage = stage;
    }


    @FXML
    public void initialize() {
        basicModel = new BasicModel("");
        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
