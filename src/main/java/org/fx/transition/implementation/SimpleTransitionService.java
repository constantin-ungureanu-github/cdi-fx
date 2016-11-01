package org.fx.transition.implementation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.fx.transition.TransitionEvent;
import org.fx.transition.TransitionService;
import org.slf4j.Logger;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

@Singleton
public class SimpleTransitionService implements TransitionService {
    @Inject
    private Logger logger;

    @Inject
    EventBus eventBus;

    @Override
    public void postEvent(final TransitionEvent event) {
        eventBus.post(event);
    }

    @Subscribe
    public void handleEvent(final TransitionEvent event) {
        logger.info("Handle of {}", event);
    }

    @PostConstruct
    public void init() {
        eventBus.register(this);
        logger.info("Initializing transition service");
    }

    @PreDestroy
    public void cleanup() {
        eventBus.unregister(this);
        logger.info("Closing transition service");
    }
}
