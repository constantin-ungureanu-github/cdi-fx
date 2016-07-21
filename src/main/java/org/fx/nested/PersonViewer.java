package org.fx.nested;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonViewer extends Application {
    @Override
    public void start(final Stage primaryStage) throws IOException {
        final Scene scene = new Scene(FXMLLoader.load(getClass().getResource("fxml/view/PersonViewer.fxml")), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
