package org.fx.controller;

import javax.inject.Inject;

import javafx.application.Application.Parameters;
import javafx.fxml.FXML;
import javafx.scene.Parent;

import org.slf4j.Logger;

public class MainController {
    @Inject
    private Logger logger;

    @Inject
    Parameters applicationParameters;

    @FXML
    private Parent basic;

    @FXML
    private BasicController basicController;

    @FXML
    private Parent login;

    @FXML
    private LoginController loginController;

    @FXML
    public void initialize() {
        logger.info("Initialize MainController.");

        logger.info("Parent basic: {}", basic);
        logger.info("BasicController basicController: {}", basicController);

        logger.info("Parent basic: {}", login);
        logger.info("BasicController basicController: {}", loginController);
    }
}
