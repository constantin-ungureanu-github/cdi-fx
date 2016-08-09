package org.fx.red;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainController {
    @FXML
    private Parent red;

    @FXML
    private RedController redController;

    public void initialize() {
        System.out.println(redController);
        System.out.println(red);
        redController.foo("YEHA");
    }
}
