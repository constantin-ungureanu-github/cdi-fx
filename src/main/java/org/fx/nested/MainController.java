package org.fx.nested;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class MainController {
    @FXML
    private PersonEditorController personEditorController;

    @FXML
    private ListView<Person> personList;

    public void initialize() {
        personList.getItems().addAll(new Person("Hugo", "Lloris"), new Person("Kyle", "Walker"), new Person("Jan", "Verthongen"), new Person(
                "Younes", "Kaboul"));

        personList.setCellFactory(listView -> new ListCell<Person>() {
            @Override
            public void updateItem(final Person person, final boolean empty) {
                super.updateItem(person, empty);
                textProperty().unbind();
                if (person != null) {
                    textProperty().bind(Bindings.format("%s %s", person.firstNameProperty(), person.lastNameProperty()));
                }
            }
        });

        personEditorController.personProperty().bind(personList.getSelectionModel().selectedItemProperty());
    }
}
