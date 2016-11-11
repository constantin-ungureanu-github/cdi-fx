package org.fx.loaders;

import javax.inject.Inject;

import javafx.stage.Stage;

import org.fx.transition.EventType;
import org.fx.transition.TransitionFlow;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLoader {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationLoader.class);

    @Inject
    private TransitionFlow transitionFlow;

    @Inject
    private Stage stage;

    public void load() {
        logger.info("Loading Application");
        stage.setTitle("Application");

        transitionFlow.postEvent(new SimpleTransitionEvent(EventType.MAIN));
    }
}
