package org.fx.example;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxFXMLExample1 extends Application {
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws IOException {
        // Create the FXMLLoader
        final FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        final String fxmlDocPath = "fxml/view/FxFXMLExample1.fxml";
        final FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        final VBox root = (VBox) loader.load(fxmlStream);

        // Create the Scene
        final Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("A simple FXML Example");
        // Display the Stage
        stage.show();
    }
}
