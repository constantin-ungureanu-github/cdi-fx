package org.fx.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {
    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(final Stage stage) throws IOException  {
        final Parent parent = FXMLLoader.load(getClass().getResource("/fxml/view/MainView.fxml"));
        final Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
