package org.fx.custom;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginBox extends VBox {
    private static final String FXML_FILE = "/fxml/view/custom/loginBox.fxml";

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {
    }

    public LoginBox() {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load(getClass().getResourceAsStream(FXML_FILE));
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML", ioe);
        }
    }

    public String getUser() {
        return userProperty().get();
    }

    public void setUser(final String value) {
        userProperty().set(value);
    }

    public StringProperty userProperty() {
        return user.textProperty();
    }

    public String getPassword() {
        return passwordProperty().get();
    }

    public void setPassword(final String value) {
        passwordProperty().set(value);
    }

    public StringProperty passwordProperty() {
        return password.textProperty();
    }
}
