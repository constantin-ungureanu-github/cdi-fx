package org.fx.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import org.fx.model.NextViewModel;
import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NextController {
    private static final Logger logger = LoggerFactory.getLogger(NextController.class);

    private static final String FXML = "/fxml/view/next.fxml";

    private final LoginService loginService;
    private final PersistenceService persistenceService;
    private final TransitionService transitionService;

    NextViewModel nextViewModel = new NextViewModel();

    public NextController(final LoginService loginService, final PersistenceService persistenceService, final TransitionService transitionService) {
        this.loginService = loginService;
        this.persistenceService = persistenceService;
        this.transitionService = transitionService;
    }

    public FXMLLoader load() {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(type -> this);
            fxmlLoader.load(getClass().getResourceAsStream(FXML));
            return fxmlLoader;
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML application screen", ioe);
        }
    }

    @FXML
    public void initialize() {
        logger.info("Initialize NextController");
    }

    @FXML
    public void onClose(final ActionEvent event) {
        transitionService.postEvent(new SimpleTransitionEvent(loginService, persistenceService, "login"));
    }
}
