package org.fx.producers;

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
        final FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(parameters -> instance.select(parameters).get());
        return loader;
    }
}
