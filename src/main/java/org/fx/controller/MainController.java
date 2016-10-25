package org.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;

import javax.inject.Inject;

import org.slf4j.Logger;

public class MainController {
    @Inject
    private Logger logger;

    @FXML
    private Parent login;

    @FXML
    private LoginController loginController;

    @FXML
    public void initialize() {
        logger.info("Initialize MainController.");

        logger.info("Parent login: {}", login);
        logger.info("LoginController loginController: {}", loginController);
    }
}
