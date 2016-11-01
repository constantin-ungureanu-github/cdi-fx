package org.fx.loaders;

import javax.inject.Inject;
import javax.inject.Singleton;

import javafx.stage.Stage;

import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;

@Singleton
public class ApplicationLoader {
    @Inject
    private Logger logger;

    @Inject
    private Stage stage;

    @Inject
    private TransitionService transitionService;

    public void load(final String path) {
        logger.info("Loading Application");
        stage.setTitle("Application");

        transitionService.postEvent(new SimpleTransitionEvent(path));
    }
}
