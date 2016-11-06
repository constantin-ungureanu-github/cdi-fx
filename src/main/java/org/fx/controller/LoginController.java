package org.fx.controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import org.fx.custom.LoginBox;
import org.fx.model.LoginViewModel;
import org.fx.services.LoginService;
import org.fx.services.PersistenceService;
import org.fx.transition.EventType;
import org.fx.transition.TransitionService;
import org.fx.transition.implementation.SimpleTransitionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public static final String FXML = "/fxml/view/login.fxml";
    private static final String CREDENTIALS_PATH = "credentials.xml";

    private final LoginService loginService;
    private final PersistenceService persistenceService;
    private final TransitionService transitionService;

    private LoginViewModel loginViewModel;

    @FXML
    LoginBox loginBox;

    @FXML
    private Button loginButton;

    @FXML
    private Text feedback;

    public LoginController(final LoginService loginService, final PersistenceService persistenceService, final TransitionService transitionService) {
        this.loginService = loginService;
        this.persistenceService = persistenceService;
        this.transitionService = transitionService;
    }

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

        transitionService.postEvent(new SimpleTransitionEvent(EventType.LOGIN.NEXT));
    }
}
