package org.fx.controller;

import java.io.IOException;
import java.net.URL;

import javax.inject.Inject;

import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.fx.model.LoginViewModel;
import org.fx.services.LoginService;
import org.slf4j.Logger;

public class LoginController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Text feedback;

    @Inject
    private Logger logger;

    @Inject
    Parameters applicationParameters;

    @Inject
    private LoginService loginService;

    private LoginViewModel loginModel;

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private Stage stage;

    public void load() {
        try {
            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/login.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();

            logger.info("Loaded login view.");
        } catch (final IOException ioe) {
            throw new IllegalStateException("Cannot load FXML login screen", ioe);
        }
    }

    @FXML
    void handleSubmitButtonAction(final ActionEvent event) {
        feedback.setText(loginService.login(username.getText(), password.getText()));
    }

    @FXML
    public void initialize() {
        logger.info("Initialize LoginController.");

        loginModel = new LoginViewModel("", "");

        username.textProperty().bindBidirectional(loginModel.getUsername());
        password.textProperty().bindBidirectional(loginModel.getPassword());

        login.disableProperty().bind(username.textProperty().isNotEmpty().and(password.textProperty().isNotEmpty()).not());
    }
}
