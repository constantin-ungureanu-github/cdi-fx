package org.fx.custom;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public final class CustomControlStaticLoader {
    private static final FXMLLoader fxmlLoader = new FXMLLoader();

    private CustomControlStaticLoader() {
    }

    public static void load(final Node node, final String fxmlFile) {
        try {
            fxmlLoader.setRoot(node);
            fxmlLoader.setController(node);
            fxmlLoader.load(node.getClass().getResourceAsStream(fxmlFile));
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML", ioe);
        }
    }
}
