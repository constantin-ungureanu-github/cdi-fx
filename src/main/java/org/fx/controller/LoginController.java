package org.fx.controller;

import java.io.File;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import org.fx.custom.LoginBox;
import org.fx.model.LoginViewModel;
import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;

public class LoginController {
    private static final String NEXT_FXML = "/fxml/view/next.fxml";
    private static final String CREDENTIALS_PATH = "credentials.xml";

    @Inject
    private Logger logger;

    @Inject
    private LoginService loginService;

    @Inject
    private PersistenceService persistenceService;

    @Inject
    private TransitionService transitionService;

    @FXML
    LoginBox loginBox;

    @FXML
    private Button loginButton;

    @FXML
    private Text feedback;

    private LoginViewModel loginViewModel;

    @FXML
    public void initialize() {
        logger.info("Initialize LoginController");

        initializeViewModel();

        loginBox.userProperty().bindBidirectional(loginViewModel.getUserProperty());
        loginBox.passwordProperty().bindBidirectional(loginViewModel.getPasswordProperty());

        loginButton.disableProperty().bind(loginBox.userProperty().isNotEmpty().and(loginBox.passwordProperty().isNotEmpty()).not());
    }

    private void initializeViewModel() {
        loginViewModel = (LoginViewModel) persistenceService.load(new File(CREDENTIALS_PATH), LoginViewModel.class);
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(loginBox.userProperty().get(), loginBox.passwordProperty().get());
        }
    }

    @FXML
    void handleLoginButtonAction() {
        feedback.setText(loginService.login(loginBox.getUser(), loginBox.getPassword()));
        persistenceService.save(new File(CREDENTIALS_PATH), loginViewModel);

        transitionService.postEvent(new SimpleTransitionEvent(NEXT_FXML));
    }
}
