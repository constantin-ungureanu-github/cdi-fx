package org.fx.controller;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.fx.model.BasicModel;
import org.slf4j.Logger;

public class BasicController {
    @FXML
    private TextField field;

    @Inject
    private Logger logger;

    private BasicModel basicModel;

    public BasicController() {
    }

    @FXML
    public void initialize() {
        logger.info("Initialize BasicController.");

        basicModel = new BasicModel("");
        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
