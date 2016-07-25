package org.fx.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxFXMLExample1 extends Application {
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws IOException {
        // Create the FXMLLoader
        final FXMLLoader fxmlLoader = new FXMLLoader();

        // Create the Pane and all Details
        final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/FxFXMLExample1.fxml"));

        // Create the Scene
        final Scene scene = new Scene(root);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Set the Title to the Stage
        primaryStage.setTitle("A simple FXML Example");

        // Display the Stage
        primaryStage.show();
    }
}
