package org.fx.services.implementation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.fx.services.LoginService;
import org.slf4j.Logger;

@Singleton
public class SimpleLoginService implements LoginService {
    @Inject
    private Logger logger;

    @Override
    public String login(final String login, final String password) {
        if ((password != null) && (password.trim().length() > 0)) {
            logger.info("{} logged in successfully", login);
            return String.format("%s logged in successfully", login);
        }

        logger.info("{} failed to login", login);
        return String.format("%s failed to login", login);
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing simple login service.");
    }

    @PreDestroy
    public void cleanup() {
        logger.info("Cleaning up simple login service.");
    }
}
