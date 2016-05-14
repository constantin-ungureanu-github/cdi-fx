package org.fx.weld;

import javax.enterprise.util.AnnotationLiteral;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javafx.application.Application;
import javafx.stage.Stage;

public class LoginApplication extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        final WeldContainer weldContainer = new Weld().initialize();
        weldContainer.instance().select(ApplicationParametersProvider.class).get().setParameters(getParameters());
        weldContainer.event().select(Stage.class, new AnnotationLiteral<StartupScene>() {
            private static final long serialVersionUID = -1168305963507529134L;
        }).fire(primaryStage);
    }

    public static void main(final String[] args) {
        launch(LoginApplication.class, args);
    }
}
