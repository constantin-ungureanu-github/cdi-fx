package org.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.fx.application.MainApplication;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main extends Application {
    private WeldContainer weldContainer;

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        weldContainer = new Weld().initialize();
    }

    @Override
    public void start(final Stage primaryStage) {
        weldContainer.instance().select(MainApplication.class).get().start(primaryStage);

//        // Make the application parameters injectable with a standard CDI annotation
//        weldContainer.instance().select(ApplicationParametersProducer.class).get().setParameters(getParameters());
//
//        // Now that JavaFX thread is ready let's inform whoever cares using standard CDI notification mechanism, the CDI events
//        weldContainer.event().select(Stage.class, new AnnotationLiteral<StartupScene>() {
//            private static final long serialVersionUID = -4745360427216709042L;
//        }).fire(primaryStage);
    }

    @Override
    public void stop() {
        weldContainer.close();
    }
}
