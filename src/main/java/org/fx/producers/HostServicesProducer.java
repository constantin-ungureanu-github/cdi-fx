package org.fx.producers;

import javafx.application.HostServices;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class HostServicesProducer {
    private HostServices hostServices;

    @Produces
    public HostServices getHostServices() {
        if (hostServices == null) {
            throw new IllegalStateException("The host services are not available for injection.");
        }

        return hostServices;
    }

    public void setHostServices(final HostServices hostServices) {
        this.hostServices = hostServices;
    }
}
