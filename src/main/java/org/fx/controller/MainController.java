package org.fx.controller;

import java.util.function.Consumer;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.Parent;

import org.slf4j.Logger;

public class MainController implements Controller {
    public static final String FXML = "/fxml/view/main.fxml";

    @Inject
    private Logger logger;

    @FXML
    private Parent login;

    @FXML
    private LoginController loginController;

    @FXML
    public void initialize() {
        logger.info("Initialize MainController");

        logger.info("Parent login: {}", login);
        logger.info("LoginController loginController: {}", loginController);
    }

    @Override
    public void setNextCallback(final Consumer<Void> finishCallback) {
        loginController.setNextCallback(finishCallback);
    }
}
