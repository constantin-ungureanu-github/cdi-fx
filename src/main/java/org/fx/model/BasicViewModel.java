package org.fx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BasicViewModel {
    private final StringProperty field;

    public BasicViewModel(final String field) {
        this.field = new SimpleStringProperty(field);
    }

    public StringProperty getField() {
        return field;
    }
}