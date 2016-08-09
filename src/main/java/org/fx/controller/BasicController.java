package org.fx.controller;

import java.io.IOException;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.fx.model.BasicViewModel;
import org.slf4j.Logger;

public class BasicController {
    @FXML
    private TextField field;

    @Inject
    private Logger logger;

    private BasicViewModel basicModel;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    public void load() {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/basic.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Basic");
            stage.show();

            logger.info("Loaded basic view.");
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML basic screen", ioe);
        }
    }

    @FXML
    public void initialize() {
        logger.info("Initialize BasicController.");

        basicModel = new BasicViewModel("");
        field.textProperty().bindBidirectional(basicModel.getField());
    }
}
