package org.fx.controller;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import org.fx.model.NextViewModel;
import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;

public class NextController {
    private static final String MAIN_FXML = "/fxml/view/main.fxml";

    @Inject
    private Logger logger;

    @Inject
    private TransitionService transitionService;

    NextViewModel nextViewModel = new NextViewModel();

    @FXML
    public void initialize() {
        logger.info("Initialize NextController");
    }

    @FXML
    public void onClose(final ActionEvent event) {
        transitionService.postEvent(new SimpleTransitionEvent(MAIN_FXML));
    }
}
