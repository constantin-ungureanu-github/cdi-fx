package org.fx.login;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import javafx.application.Application.Parameters;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController implements Initializable {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Text feedback;

    @Inject
    private LoginService loginService;

    @Inject
    Parameters applicationParameters;

    @FXML
    protected void handleSubmitButtonAction(final ActionEvent event) {
        feedback.setText(loginService.login(username.getText(), password.getText()));
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        username.setText(applicationParameters.getNamed().get("user"));
    }
}
