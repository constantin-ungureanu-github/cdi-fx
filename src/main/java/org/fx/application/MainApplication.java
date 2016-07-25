package org.fx.application;

import java.io.IOException;

import javax.inject.Inject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;

public class MainApplication extends Application {
    @Inject
    private Logger logger;

    @Inject
    private FXMLLoader fxmlLoader;

    @Override
    public void start(final Stage stage) {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/main.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Main");
            stage.show();

            logger.info("Loaded login view.");
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML login screen", ioe);
        }
    }
}
