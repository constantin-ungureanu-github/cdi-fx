package org.fx.cdi.producers;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import javafx.fxml.FXMLLoader;

@Singleton
public class FXMLLoaderProducer {
    @Inject
    Instance<Object> instance;

    @Produces
    public FXMLLoader createLoader() {
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(param -> instance.select(param).get());
        return fxmlLoader;
    }
}
