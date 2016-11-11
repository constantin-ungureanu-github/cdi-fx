package org.fx.transition.implementation;

import java.io.IOException;

import javax.inject.Inject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.fx.controller.Controller;
import org.fx.controller.LoginController;
import org.fx.controller.MainController;
import org.fx.controller.NextController;
import org.fx.transition.EventType;
import org.fx.transition.TransitionEvent;
import org.fx.transition.TransitionFlow;
import org.slf4j.Logger;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class SimpleTransitionFlow implements TransitionFlow {
    @Inject
    Logger logger;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    private final EventBus eventBus;

    public SimpleTransitionFlow() {
        eventBus = new EventBus();
        eventBus.register(this);
    }

    @Subscribe
    public void handleEvent(final TransitionEvent event) {
        logger.info("Handle of {}", event);

        Parent root = null;
        cleanFxmlLoader();

        switch (event.getEventType()) {
        case MAIN:
            try {
                root = fxmlLoader.load(getClass().getResourceAsStream(MainController.FXML));
                final Controller mainController = fxmlLoader.getController();
                mainController.setNextCallback(controller -> postEvent(new SimpleTransitionEvent(EventType.NEXT)));
            } catch (final IOException e) {
                logger.error("{}", e);
            }
            break;
        case LOGIN:
            try {
                root = fxmlLoader.load(getClass().getResourceAsStream(LoginController.FXML));
                final Controller loginController = fxmlLoader.getController();
                loginController.setNextCallback(controller -> postEvent(new SimpleTransitionEvent(EventType.NEXT)));
            } catch (final IOException e) {
                logger.error("{}", e);
            }
            break;
        case NEXT:
            try {
                root = fxmlLoader.load(getClass().getResourceAsStream(NextController.FXML));
                final Controller nextController = fxmlLoader.getController();
                nextController.setNextCallback(controller -> postEvent(new SimpleTransitionEvent(EventType.LOGIN)));
            } catch (final IOException e) {
                logger.error("{}", e);
            }
            break;
        default:
            break;
        }

        setScene(root);
    }

    private void cleanFxmlLoader() {
        fxmlLoader.setRoot(null);
        fxmlLoader.setController(null);
        fxmlLoader.setResources(null);
        fxmlLoader.getNamespace().clear();
    }

    private void setScene(final Parent root) {
        stage.hide();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void postEvent(final TransitionEvent event) {
        eventBus.post(event);
    }
}
