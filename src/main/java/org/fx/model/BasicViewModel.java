package org.fx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.fx.cdi.api.ViewModel;

public class BasicViewModel implements ViewModel {
    private final StringProperty field;

    public BasicViewModel(final String field) {
        this.field = new SimpleStringProperty(field);
    }

    public StringProperty getField() {
        return field;
    }
}
