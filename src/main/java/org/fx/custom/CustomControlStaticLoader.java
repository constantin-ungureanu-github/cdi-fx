package org.fx.custom;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public final class CustomControlStaticLoader {
    private static final FXMLLoader fxmlLoader = new FXMLLoader();

    private CustomControlStaticLoader() {
    }

    public static <T> T load(final T node, final String fxmlFile) {
        try {
            fxmlLoader.setRoot(node);
            fxmlLoader.setController(node);
            return fxmlLoader.load(node.getClass().getResourceAsStream(fxmlFile));
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML", ioe);
        }
    }
}
