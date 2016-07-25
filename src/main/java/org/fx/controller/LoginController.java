package org.fx.controller;

import javax.inject.Inject;

import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.fx.model.LoginModel;
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

    private LoginModel loginModel;

    @FXML
    void handleSubmitButtonAction(final ActionEvent event) {
        feedback.setText(loginService.login(username.getText(), password.getText()));
    }

    @FXML
    public void initialize() {
        logger.info("Initialize LoginController.");

        loginModel = new LoginModel("", "");

        username.textProperty().bindBidirectional(loginModel.getUsername());
        password.textProperty().bindBidirectional(loginModel.getPassword());

        login.disableProperty().bind(username.textProperty().isNotEmpty().and(password.textProperty().isNotEmpty()).not());
    }
}
