package org.fx.cdi.producers;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import javafx.application.Application;

@Singleton
public class ApplicationParametersProducer {
    private Application.Parameters parameters;

    public void setParameters(final Application.Parameters parameters) {
        this.parameters = parameters;
    }

    public @Produces Application.Parameters getParameters() {
        return parameters;
    }
}
