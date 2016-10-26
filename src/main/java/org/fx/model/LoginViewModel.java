package org.fx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "credentials")
public class LoginViewModel {
    private final StringProperty user = new SimpleStringProperty() ;
    private final StringProperty password = new SimpleStringProperty();

    public LoginViewModel() {
    }

    public StringProperty getUserProperty() {
        return user;
    }

    public String getUser() {
        return user.get();
    }

    public void setUser(final String user) {
        this.user.set(user);
    }

    public StringProperty getPasswordProperty() {
        return password;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(final String password) {
        this.password.set(password);
    }
}
