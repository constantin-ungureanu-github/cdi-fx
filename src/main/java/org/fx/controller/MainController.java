package org.fx.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.TransitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private static final String FXML = "/fxml/view/main.fxml";

    private final LoginService loginService;
    private final PersistenceService persistenceService;
    private final TransitionService transitionService;

    @FXML
    private Parent login;

    @FXML
    private LoginController loginController;

    public MainController(final LoginService loginService, final PersistenceService persistenceService, final TransitionService transitionService) {
        this.loginService = loginService;
        this.persistenceService = persistenceService;
        this.transitionService = transitionService;
    }

    public FXMLLoader load() {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.load(getClass().getResourceAsStream(FXML));
            return fxmlLoader;
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML application screen", ioe);
        }
    }

    @FXML
    public void initialize() {
        logger.info("Initialize MainController");

        logger.info("Parent login: {}", login);
        logger.info("LoginController loginController: {}", loginController);
    }
}
