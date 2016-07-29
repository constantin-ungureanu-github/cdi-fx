package org.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import org.fx.model.BasicViewModel;
import org.slf4j.Logger;

public class BasicController implements Initializable {
    @FXML
    private TextField field;

    @Inject
    private Logger logger;

    private BasicViewModel basicModel;

    public BasicController() {
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        logger.info("Initialize BasicController.");

        basicModel = new BasicViewModel("");
        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
