package org.fx.producers;

import javafx.application.Application;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class ApplicationParametersProducer {
    private Application.Parameters parameters;

    @Produces
    public Application.Parameters getParameters() {
        if (parameters == null) {
            throw new IllegalStateException("The application parameters are not available for injection.");
        }

        return parameters;
    }

    public void setParameters(final Application.Parameters parameters) {
        this.parameters = parameters;
    }
}
