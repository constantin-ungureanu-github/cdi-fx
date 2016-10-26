package org.fx.custom;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public final class CustomControlLoader {
    private static final FXMLLoader fxmlLoader = new FXMLLoader();

    private CustomControlLoader() {
    }

    public static void load(final Node node, final String fxmlFile) {
        fxmlLoader.setRoot(node);
        fxmlLoader.setController(node);

        try {
            fxmlLoader.load(node.getClass().getResourceAsStream(fxmlFile));
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML", ioe);
        }
    }
}
