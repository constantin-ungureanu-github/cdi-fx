package org.fx.nested;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PersonEditorController {
    private final ObjectProperty<Person> person;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    public PersonEditorController() {
        person = new SimpleObjectProperty<>(this, "person", null);
    }

    public void initialize() {
        person.addListener((ChangeListener<Person>) (observable, oldPerson, newPerson) -> {
            if (oldPerson != null) {
                firstName.textProperty().unbindBidirectional(oldPerson.firstNameProperty());
                lastName.textProperty().unbindBidirectional(oldPerson.lastNameProperty());
            }
            if (newPerson != null) {
                firstName.textProperty().bindBidirectional(newPerson.firstNameProperty());
                lastName.textProperty().bindBidirectional(newPerson.lastNameProperty());
            }
        });
    }

    public final ObjectProperty<Person> personProperty() {
        return person;
    }

    public final Person getPerson() {
        return person.get();
    }

    public final void setPerson(final Person person) {
        this.person.set(person);
    }
}
