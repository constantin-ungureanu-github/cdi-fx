package org.fx.services.implementation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.fx.services.LoginService;
import org.slf4j.Logger;

public class SimpleLoginService implements LoginService {
    @Inject
    private Logger logger;

    @Override
    public String login(final String login, final String password) {
        if (password != null && password.trim().length() > 0) {
            logger.info("{} logged in successfully", login);
            return String.format("%s logged in successfully", login);
        }

        logger.info("{} failed to login", login);
        return String.format("%s failed to login", login);
    }

    @PostConstruct
    public void init() {
        logger.info("Initializing login service.");
    }

    @PreDestroy
    public void cleanup() {
        logger.info("Cleaning up login service.");
    }
}
