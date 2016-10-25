package org.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javax.inject.Inject;

import org.fx.custom.LoginBox;
import org.fx.model.LoginViewModel;
import org.fx.services.LoginService;
import org.slf4j.Logger;

public class LoginController {
    @Inject
    private Logger logger;

    @Inject
    private LoginService loginService;

    @FXML
    LoginBox loginBox;

    @FXML
    private Button loginButton;

    @FXML
    private Text feedback;

    private LoginViewModel loginModel;

    @FXML
    public void initialize() {
        logger.info("Initialize LoginController.");

        loginModel = new LoginViewModel("", "");

        loginBox.userProperty().bindBidirectional(loginModel.getUsername());
        loginBox.passwordProperty().bindBidirectional(loginModel.getPassword());

        loginButton.disableProperty().bind(loginBox.userProperty().isNotEmpty().and(loginBox.passwordProperty().isNotEmpty()).not());
    }

    @FXML
    void handleLoginButtonAction() {
        feedback.setText(loginService.login(loginBox.getUser(), loginBox.getPassword()));
    }
}
