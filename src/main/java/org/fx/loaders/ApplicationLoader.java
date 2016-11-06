package org.fx.loaders;

import javafx.stage.Stage;

import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.services.implementation.SimpleLoginService;
import org.fx.services.implementation.SimplePersistenceService;
import org.fx.transition.EventType;
import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.fx.transition.implementation.SimpleTransitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLoader {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationLoader.class);

    private final LoginService loginService;
    private final PersistenceService persistenceService;
    private final TransitionService transitionService;
    private final Stage stage;

    public ApplicationLoader(final Stage stage) {
        loginService = new SimpleLoginService();
        persistenceService = new SimplePersistenceService();
        transitionService = new SimpleTransitionService(loginService, persistenceService, stage);
        this.stage = stage;
    }

    public void load() {
        logger.info("Loading Application");
        stage.setTitle("Application");

        transitionService.postEvent(new SimpleTransitionEvent(EventType.LOGIN));
    }
}
