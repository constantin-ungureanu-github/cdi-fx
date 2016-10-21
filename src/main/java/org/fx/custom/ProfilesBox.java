package org.fx.custom;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ProfilesBox extends VBox {
    public ProfilesBox() {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profiles.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
