package org.fx.transition.implementation;

import javafx.scene.Scene;
import javafx.stage.Stage;

import org.fx.controller.LoginController;
import org.fx.controller.NextController;
import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.TransitionEvent;
import org.fx.transition.TransitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class SimpleTransitionService implements TransitionService {
    private static final Logger logger = LoggerFactory.getLogger(SimpleTransitionService.class);

    private final EventBus eventBus = new EventBus();
    private final Stage stage;

    private final LoginService loginService;
    private final PersistenceService persistenceService;

    public SimpleTransitionService(final LoginService loginService, final PersistenceService persistenceService, final Stage stage) {
        this.loginService = loginService;
        this.persistenceService = persistenceService;
        this.stage = stage;
        eventBus.register(this);
    }

    @Subscribe
    public void handleEvent(final TransitionEvent event) {
        logger.info("Handle of {}", event);

        stage.hide();
        switch (event.getEventType()) {
        case LOGIN:
            final LoginController loginController = new LoginController(loginService, persistenceService, this);
            stage.setScene(new Scene(loginController.load(LoginController.FXML).getRoot()));
            break;
        case NEXT:
            final NextController nextController = new NextController(persistenceService, this);
            stage.setScene(new Scene(nextController.load(NextController.FXML).getRoot()));
            break;
        default:
            break;
        }
        stage.show();
    }

    @Override
    public void postEvent(final TransitionEvent event) {
        eventBus.post(event);
    }
}
