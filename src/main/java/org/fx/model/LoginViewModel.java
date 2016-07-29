package org.fx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.fx.cdi.api.ViewModel;

public class LoginViewModel implements ViewModel {
    private final StringProperty username;
    private final StringProperty password;

    public LoginViewModel(final String username, final String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public StringProperty getUsername() {
        return username;
    }

    public StringProperty getPassword() {
        return password;
    }
}
