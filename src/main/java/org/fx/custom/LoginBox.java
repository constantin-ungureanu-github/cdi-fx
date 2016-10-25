package org.fx.custom;

import java.io.IOException;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginBox extends VBox {
    private static final String FXML_FILE = "/fxml/view/custom/login.fxml";

//    @Inject
//    private Logger logger;
//
//    @Inject
//    FXMLLoader fxmlLoader;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
    }

    public LoginBox() {
//        try {
//            fxmlLoader.setRoot(this);
//            fxmlLoader.setController(this);
//            fxmlLoader.load(getClass().getResourceAsStream(FXML_FILE));
//
//            logger.info("Loaded {}.", FXML_FILE);
//        } catch (final IOException ioe) {
//            throw new IllegalStateException("Cannot load FXML", ioe);
//        }

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_FILE));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (final IOException exception) {
            throw new RuntimeException(exception);
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
