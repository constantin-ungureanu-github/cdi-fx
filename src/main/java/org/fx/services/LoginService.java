package org.fx.services;

import javax.inject.Singleton;

@Singleton
public interface LoginService {
    public String login(String login, String password);
}
