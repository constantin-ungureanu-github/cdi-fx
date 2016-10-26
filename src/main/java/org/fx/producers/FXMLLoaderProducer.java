package org.fx.producers;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import javafx.fxml.FXMLLoader;

@Singleton
public class FXMLLoaderProducer {
    private Instance<Object> instance;

    @Produces
    public FXMLLoader produceLoader() {
        if (instance == null) {
            throw new IllegalStateException("The instance container is not available");
        }

        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(parameters -> instance.select(parameters).get());
        return fxmlLoader;
    }

    public void setInstance(final Instance<Object> instance) {
        this.instance = instance;
    }
}
