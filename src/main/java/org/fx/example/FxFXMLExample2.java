package org.fx.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxFXMLExample2 extends Application {
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws IOException {
        // Create the FXMLLoader
        final FXMLLoader fxmlLoader = new FXMLLoader();

        // Create the Pane and all Details
        final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/FxFXMLExample2.fxml"));

        // Create the Scene
        final Scene scene = new Scene(root);

        // Set the Scene to the Stage
        stage.setScene(scene);

        // Set the Title to the Stage
        stage.setTitle("A FXML Example with a Script Event Handler");

        // Display the Stage
        stage.show();
    }
}
