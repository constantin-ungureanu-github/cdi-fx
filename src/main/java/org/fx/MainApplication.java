package org.fx;

import javafx.application.Application;
import javafx.stage.Stage;

import org.fx.controller.LoginController;
import org.fx.producers.ApplicationParametersProducer;
import org.fx.producers.FXMLLoaderProducer;
import org.fx.producers.HostServicesProducer;
import org.fx.producers.PrimaryStageProducer;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MainApplication extends Application {
    private WeldContainer weldContainer;

    public static void main(final String[] args) {
        launch(MainApplication.class);
    }

    @Override
    public void init() {
        weldContainer = new Weld().initialize();
        weldContainer.instance().select(FXMLLoaderProducer.class).get().setInstance(weldContainer);
    }

    @Override
    public void start(final Stage primaryStage) {
        weldContainer.instance().select(HostServicesProducer.class).get().setHostServices(getHostServices());
        weldContainer.instance().select(ApplicationParametersProducer.class).get().setParameters(getParameters());
        weldContainer.instance().select(PrimaryStageProducer.class).get().setPrimaryStage(primaryStage);

        weldContainer.instance().select(LoginController.class).get().load();
    }

    @Override
    public void stop() {
        weldContainer.close();
    }
}
