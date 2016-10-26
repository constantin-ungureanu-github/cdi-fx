package org.fx.producers;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import javafx.stage.Stage;

@Singleton
public class PrimaryStageProducer {
    private Stage primaryStage;

    @Produces
    public Stage getPrimaryStage() {
        if (primaryStage == null) {
            throw new IllegalStateException("The primary stage is not available for injection");
        }

        return primaryStage;
    }

    public void setPrimaryStage(final Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
