package org.fx.nested;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;

    public Person(final String firstName, final String lastName) {
        this.firstName = new SimpleStringProperty(this, "firstName", firstName);
        this.lastName = new SimpleStringProperty(this, "lastName", lastName);
    }

    public final StringProperty firstNameProperty() {
        return firstName;
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(final String firstName) {
        this.firstName.set(firstName);
    }

    public final StringProperty lastNameProperty() {
        return lastName;
    }

    public final String getLastName() {
        return lastName.get();
    }

    public final void setLastName(final String lastName) {
        this.lastName.set(lastName);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
