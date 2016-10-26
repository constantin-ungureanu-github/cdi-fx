package org.fx;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;

@Singleton
public class ApplicationLoader {
    @Inject
    private Logger logger;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    public void load(final String path) {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream(path));

            stage.setScene(new Scene(root));
            stage.setTitle("Application");
            stage.show();

            logger.info("Loaded {}.", path);
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML application screen", ioe);
        }
    }
}
