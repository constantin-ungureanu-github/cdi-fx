package org.fx.application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RedController {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    public void foo(final String foo) {
        System.out.println(foo);
    }
}
