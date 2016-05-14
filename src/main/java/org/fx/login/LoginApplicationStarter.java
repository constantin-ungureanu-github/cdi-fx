package org.fx.login;

import java.io.IOException;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.fx.weld.StartupScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApplicationStarter {
    @Inject
    FXMLLoader fxmlLoader;

    public void launchJavaFXApplication(@Observes @StartupScene final Stage stage) {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("login.fxml"));

            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML login screen", ioe);
        }
    }
}
