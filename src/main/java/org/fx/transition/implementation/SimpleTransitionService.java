package org.fx.transition.implementation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.fx.controller.LoginController;
import org.fx.controller.MainController;
import org.fx.controller.NextController;
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

    public SimpleTransitionService(final Stage stage) {
        eventBus.register(this);
        this.stage = stage;
    }

    @Subscribe
    public void handleEvent(final TransitionEvent event) {
        logger.info("Handle of {}", event);

        final FXMLLoader fxmlLoader;
        if (event.getMessage().equals("main")) {
            final MainController mainController = new MainController(event.getLoginService(), event.getPersistenceService(), this);
            fxmlLoader = mainController.load();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
        } else if (event.getMessage().equals("login")) {
            final LoginController loginController = new LoginController(event.getLoginService(), event.getPersistenceService(), this);
            fxmlLoader = loginController.load();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
        } else if (event.getMessage().equals("next")) {
            final NextController nextController = new NextController(event.getLoginService(), event.getPersistenceService(), this);
            fxmlLoader = nextController.load();
            stage.setScene(new Scene(fxmlLoader.getRoot()));
        }
    }

    @Override
    public void postEvent(final TransitionEvent event) {
        eventBus.post(event);
    }
}
