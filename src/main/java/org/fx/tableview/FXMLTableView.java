package org.fx.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTableView extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");
        final Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("/fxml/view/tableview.fxml"));
        final Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
