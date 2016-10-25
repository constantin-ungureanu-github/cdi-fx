package org.fx.address;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.fx.address.controller.BirthdayStatisticsController;
import org.fx.address.controller.PersonEditDialogController;
import org.fx.address.controller.PersonOverviewController;
import org.fx.address.controller.RootLayoutController;
import org.fx.address.model.Person;
import org.fx.address.model.PersonListWrapper;

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            final Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            final RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        final File file = getPersonFilePath();
        if (file != null) {
            loadPersonDataFromFile(file);
        }
    }

    public void showPersonOverview() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/view/PersonOverview.fxml"));
            final AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            final PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(final Person person) {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/view/PersonEditDialog.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();

            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            final PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (final IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showBirthdayStatistics() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/view/BirthdayStatistics.fxml"));
            final AnchorPane page = (AnchorPane) loader.load();
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            final Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            final BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);

            dialogStage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public File getPersonFilePath() {
        final Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        final String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setPersonFilePath(final File file) {
        final Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");
            primaryStage.setTitle("AddressApp");
        }
    }

    public void loadPersonDataFromFile(final File file) {
        try {
            final JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            final Unmarshaller unmarshaller = context.createUnmarshaller();

            final PersonListWrapper wrapper = (PersonListWrapper) unmarshaller.unmarshal(file);

            personData.clear();
            personData.addAll(wrapper.getPersons());

            setPersonFilePath(file);

        } catch (final Exception e) {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public void savePersonDataToFile(final File file) {
        try {
            final JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
            final Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            final PersonListWrapper wrapper = new PersonListWrapper();
            wrapper.setPersons(personData);

            marshaller.marshal(wrapper, file);

            setPersonFilePath(file);
        } catch (final Exception e) {
            final Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
