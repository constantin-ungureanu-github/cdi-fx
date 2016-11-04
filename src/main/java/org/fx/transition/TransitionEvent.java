package org.fx.transition;

import org.fx.services.LoginService;
import org.fx.services.PersistenceService;

public interface TransitionEvent {
    public String getMessage();
    public LoginService getLoginService();
    public PersistenceService getPersistenceService();
}
