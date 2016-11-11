package org.fx.producers;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import com.google.common.eventbus.EventBus;

@Singleton
public class EventBusProducer {
    private final EventBus eventBus = new EventBus();

    @Produces
    public EventBus getEventBus() {
        return eventBus;
    }
}
