package org.fx.controller;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.fx.model.BasicViewModel;
import org.slf4j.Logger;

public class BasicController {

    @Inject
    private Logger logger;

    @FXML
    private TextField field;

    private BasicViewModel basicModel;

    @FXML
    public void initialize() {
        logger.info("Initialize BasicController.");

        basicModel = new BasicViewModel("");
        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
