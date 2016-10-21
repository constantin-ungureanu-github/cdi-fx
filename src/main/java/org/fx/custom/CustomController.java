package org.fx.custom;

import javax.inject.Inject;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.slf4j.Logger;

public class CustomController {
    @Inject
    private Logger logger;

    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        logger.info("Initialize CustomController.");
    }

//    public CustomControl(FXMLLoader fxmlLoader, Logger logger) {
////        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view/custom_control.fxml"));
//        this.logger = logger;
//        this.fxmlLoader = fxmlLoader;
//
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load(getClass().getResourceAsStream("/fxml/view/custom_control.fxml"));
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(final String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    @FXML
    protected void doSomething() {
        logger.info("The button was clicked!");
//        System.out.println();
    }
}
