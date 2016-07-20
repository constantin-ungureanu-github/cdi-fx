package org.fx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BasicModel {
    private final StringProperty field;

    public BasicModel(final String field) {
        this.field = new SimpleStringProperty(field);
    }

    public StringProperty getField() {
        return field;
    }
}
