package org.fx.transition.implementation;

import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.TransitionEvent;

public class SimpleTransitionEvent implements TransitionEvent {
    private final LoginService loginService;
    private final PersistenceService persistenceService;
    private final String message;

    public SimpleTransitionEvent(final LoginService loginService, final PersistenceService persistenceService, final String message) {
        this.loginService = loginService;
        this.persistenceService = persistenceService;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    public PersistenceService getPersistenceService() {
        return persistenceService;
    }

    public LoginService getLoginService() {
        return loginService;
    }
}
