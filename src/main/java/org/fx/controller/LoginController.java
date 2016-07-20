package org.fx.controller;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.fx.model.LoginModel;
import org.fx.services.LoginService;

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
    private LoginService loginService;

    private LoginModel loginModel;

    @FXML
    protected void handleSubmitButtonAction(final ActionEvent event) {
        feedback.setText(loginService.login(username.getText(), password.getText()));
    }

    @FXML
    public void initialize() {
        loginModel = new LoginModel("", "");

        username.textProperty().bindBidirectional(loginModel.getUsername());
        password.textProperty().bindBidirectional(loginModel.getPassword());

        login.disableProperty().bind(username.textProperty().isNotEmpty().and(password.textProperty().isNotEmpty()).not());
    }
}
