package org.fx.controller;

import java.io.IOException;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;

public class MainController {

    @Inject
    private Logger logger;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    @FXML
    private Parent basic;

    @FXML
    private BasicController basicController;

    @FXML
    private Parent login;

    @FXML
    private LoginController loginController;

    public void load() {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/main.fxml"));

            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();

            logger.info("Loaded main controller.");
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML login screen", ioe);
        }
    }

    @FXML
    public void initialize() {
        logger.info("Initialize MainController.");

        logger.info("Parent basic: {}", basic);
        logger.info("BasicController basicController: {}", basicController);

        logger.info("Parent login: {}", login);
        logger.info("LoginController loginController: {}", loginController);
    }
}
