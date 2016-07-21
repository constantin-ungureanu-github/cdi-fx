package org.fx.application;

import javafx.fxml.FXML;

public class MainController {
//    @FXML
//    private Parent redView;

    @FXML
    private RedController redController;

    public void initialize() {
        System.out.println(redController);
//        System.out.println(redView);
        redController.foo("YEHA");
    }
}
