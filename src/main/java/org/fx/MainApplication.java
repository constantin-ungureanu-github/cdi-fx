package org.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.fx.application.LoginApplication;
import org.jboss.weld.environment.se.Weld;

public class MainApplication extends Application {
    private Weld weld;

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        weld = new Weld();
    }

    @Override
    public void start(final Stage stage) {
        weld.initialize().instance().select(LoginApplication.class).get().start(stage);
    }

    @Override
    public void stop() {
        weld.shutdown();
    }
}
