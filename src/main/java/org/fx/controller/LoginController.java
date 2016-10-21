package org.fx.controller;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.fx.custom.CustomController;
import org.fx.model.LoginViewModel;
import org.fx.services.LoginService;
import org.slf4j.Logger;

public class LoginController {

    @Inject
    private Logger logger;

//    @Inject
//    private FXMLLoader fxmlLoader;
//
//    @Inject
//    private Stage stage;

    @Inject
    private LoginService loginService;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Text feedback;

    @FXML
    private Parent custom;

    @FXML
    private CustomController customController;

    private LoginViewModel loginModel;

    @FXML
    public void initialize() {
        logger.info("Initialize LoginController.");

        logger.info("Parent custom: {}", custom);
        logger.info("CustomController basicController: {}", customController);

        loginModel = new LoginViewModel("", "");

        username.textProperty().bindBidirectional(loginModel.getUsername());
        password.textProperty().bindBidirectional(loginModel.getPassword());

        login.disableProperty().bind(username.textProperty().isNotEmpty().and(password.textProperty().isNotEmpty()).not());
    }

//    public void load() {
//        try {
//            final Parent root = fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/login.fxml"));
//
//            stage.setScene(new Scene(root));
//            stage.setTitle("Login");
//            stage.show();
//
//            logger.info("Loaded login view.");
//        } catch (final Exception ioe) {
//            throw new IllegalStateException("Cannot load FXML login screen", ioe);
//        }
//    }

    @FXML
    void handleSubmitButtonAction() {
        feedback.setText(loginService.login(username.getText(), password.getText()));
    }
}
