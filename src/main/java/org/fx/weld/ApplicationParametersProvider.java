package org.fx.weld;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import javafx.application.Application.Parameters;

@Singleton
public class ApplicationParametersProvider {
    private Parameters parameters;

    void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Produces
    public Parameters getParameters() {
        return parameters;
    }
}
