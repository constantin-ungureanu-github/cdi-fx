package org.fx.transition.implementation;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.fx.transition.TransitionEvent;
import org.fx.transition.TransitionService;
import org.slf4j.Logger;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

@Singleton
public class SimpleTransitionService implements TransitionService {
    @Inject
    private Logger logger;

    @Inject
    EventBus eventBus;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    @Subscribe
    public void handleEvent(final TransitionEvent event) {
        logger.info("Handle of {}", event);

        try {
            cleanFxmlLoader();
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream(event.getMessage()));
            setScene(root);
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML application screen", ioe);
        }
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

    @PostConstruct
    public void init() {
        eventBus.register(this);
        logger.info("Initializing transition service");
    }

    @PreDestroy
    public void cleanup() {
        eventBus.unregister(this);
        logger.info("Closing transition service");
    }
}
