package org.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.fx.application.LoginApplication;
import org.jboss.weld.environment.se.Weld;

public class MainApplication extends Application {
    private Weld weld;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        weld = new Weld();
    }

    @Override
    public void start(final Stage primaryStage) {
        weld.initialize().instance().select(LoginApplication.class).get().start(primaryStage);
    }

    @Override
    public void stop() {
        weld.shutdown();
    }
}
