package org.fx.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public interface Controller {
    public default FXMLLoader load(final String FXML) {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setControllerFactory(type -> this);
            fxmlLoader.load(getClass().getResourceAsStream(FXML));
            return fxmlLoader;
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML application screen", ioe);
        }
    }
}
