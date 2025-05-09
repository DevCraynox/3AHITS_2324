package at.htlhl.kkm.klassenkassamanagment;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

import static at.htlhl.kkm.klassenkassamanagment.App.APP_NAME;

public class KKMController {
    @FXML
    private Button openButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button addButton;

    @FXML
    private Button demandButton;

    @FXML
    private Button depositButton;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> catalogNumberColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, Double> demandColumn;

    @FXML
    private TableColumn<Student, Double> alreadyDepositColumn;

    @FXML
    private TableColumn<Student, Double> haveToDepositColumn;

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Datei öffnen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Dateien", "*.json"));
        File selectedFile = fileChooser.showOpenDialog(openButton.getScene().getWindow());

        if (selectedFile != null) {
            try {
                StringBuilder content = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                }
                JSONObject jsonObject = new JSONObject(content.toString());
                JSONArray studentsArray = jsonObject.getJSONArray("students");

                tableView.getItems().clear();

                for (int i = 0; i < studentsArray.length(); i++) {
                    JSONObject studentObject = studentsArray.getJSONObject(i);
                    String catalogNumber = studentObject.getString("catalogNumber");
                    String firstName = studentObject.getString("firstName");
                    String lastName = studentObject.getString("lastName");
                    double demand = studentObject.getDouble("demand");
                    double alreadyDeposit = studentObject.getDouble("alreadyDeposit");
                    double haveToDeposit = studentObject.getDouble("haveToDeposit");

                    Student student = new Student(catalogNumber, firstName, lastName);
                    student.setDemand(demand);
                    student.setAlreadyDeposit(alreadyDeposit);
                    student.setHaveToDeposit(haveToDeposit);

                    // Update the deposit status for each student
                    student.makeDeposit(alreadyDeposit);

                    tableView.getItems().add(student);
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erfolg");
                alert.setHeaderText(null);
                alert.setContentText("Datei erfolgreich geöffnet und Daten geladen.");
                alert.showAndWait();
            } catch (IOException | JSONException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fehler");
                alert.setHeaderText(null);
                alert.setContentText("Fehler beim Öffnen der Datei.");
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleSave() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Speichern");
        dialog.setHeaderText("Geben Sie den Klassennamen ein:");
        dialog.setContentText("Klasse:");

        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        String className = null;
        boolean validInput = false;
        while (!validInput) {
            dialog.getEditor().clear();
            dialog.showAndWait();
            if (dialog.getResult() == null) {
                return;
            }
            className = dialog.getResult().trim();
            if (!className.isEmpty()) {
                validInput = true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ungültige Eingabe");
                alert.setHeaderText(null);
                alert.setContentText("Bitte geben Sie einen gültigen Klassennamen ein.");
                alert.showAndWait();
            }
        }

        JSONArray studentsArray = new JSONArray();
        for (Student student : tableView.getItems()) {
            JSONObject studentObject = new JSONObject();
            studentObject.put("catalogNumber", student.getCatalogNumber());
            studentObject.put("firstName", student.getFirstName());
            studentObject.put("lastName", student.getLastName());
            studentObject.put("demand", student.getDemand());
            studentObject.put("alreadyDeposited", student.getAlreadyDeposit());
            studentObject.put("haveToDeposit", student.getHaveToDeposit());

            studentsArray.put(studentObject);
        }

        JSONObject jsonData = new JSONObject();
        jsonData.put("students", studentsArray);
        jsonData.put("class", className);

        String userHome = System.getProperty("user.home");
        String saveDir = userHome + "/." + APP_NAME;
        File saveDirectory = new File(saveDir);
        if (!saveDirectory.exists()) {
            saveDirectory.mkdir();
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("KKM_" + className + ".json");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
        fileChooser.setInitialDirectory(saveDirectory);
        File saveFile = fileChooser.showSaveDialog(saveButton.getScene().getWindow());
        if (saveFile != null) {
            try (FileWriter writer = new FileWriter(saveFile)) {
                writer.write(jsonData.toString());
                writer.flush();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Speichern erfolgreich");
                alert.setHeaderText(null);
                alert.setContentText("Die Daten wurden erfolgreich gespeichert.");
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fehler beim Speichern");
                alert.setHeaderText(null);
                alert.setContentText("Beim Speichern der Daten ist ein Fehler aufgetreten.");
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleAdd() {
        Dialog<Student> dialog = new Dialog<>();
        dialog.setTitle("Neuen Schüler hinzufügen");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        TextField catalogNumberField = new TextField();
        catalogNumberField.setPromptText("Katalognr.");
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Vorname");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Nachname");
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(catalogNumberField, firstNameField, lastNameField);
        dialog.getDialogPane().setContent(vbox);

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                Student newStudent = new Student(catalogNumberField.getText(), firstNameField.getText(), lastNameField.getText());
                tableView.getItems().add(newStudent);
                return newStudent;
            }
            return null;
        });

        dialog.showAndWait();
        tableView.refresh();
    }

    @FXML
    private void handleDemand() {
        Stage popoverStage = new Stage();

        TextField amountField = new TextField();
        amountField.setPromptText("Betrag eingeben");

        Button confirmButton = new Button("Bestätigen");
        confirmButton.setOnAction(event -> {
            String amountText = amountField.getText();
            if (!amountText.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    for (Student student : tableView.getItems()) {
                        student.addToDemand(amount);
                    }
                    popoverStage.close();
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Ungültiger Betrag", "Bitte geben Sie eine gültige Zahl ein.");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Betrag erforderlich", "Bitte geben Sie einen Betrag ein.");
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(amountField, confirmButton);
        Scene scene = new Scene(vbox);
        popoverStage.setScene(scene);
        popoverStage.setTitle("Forderungen festlegen");
        popoverStage.show();

        tableView.refresh();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleDeposit() {
        Student selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            showAlert(Alert.AlertType.WARNING, "Kein Schüler ausgewählt", "Bitte wählen Sie einen Schüler aus.");
            return;
        }

        Stage popoverStage = new Stage();

        TextField amountField = new TextField();
        amountField.setPromptText("Betrag eingeben");

        Button confirmButton = new Button("Bestätigen");
        confirmButton.setOnAction(event -> {
            String amountText = amountField.getText();
            if (!amountText.isEmpty()) {
                try {
                    double depositAmount = Double.parseDouble(amountText);
                    selectedStudent.makeDeposit(depositAmount);
                    tableView.refresh();

                    popoverStage.close();
                } catch (NumberFormatException e) {
                    showAlert(Alert.AlertType.ERROR, "Ungültiger Betrag", "Bitte geben Sie eine gültige Zahl ein.");
                }
            } else {
                showAlert(Alert.AlertType.ERROR, "Betrag erforderlich", "Bitte geben Sie einen Betrag ein.");
            }
        });

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(amountField, confirmButton);
        Scene scene = new Scene(vbox);
        popoverStage.setScene(scene);
        popoverStage.setTitle("Einzahlung durchführen");
        popoverStage.show();
    }

    @FXML
    private void initialize() {
        catalogNumberColumn.setCellValueFactory(new PropertyValueFactory<>("catalogNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        alreadyDepositColumn.setCellValueFactory(new PropertyValueFactory<>("alreadyDeposited"));
        haveToDepositColumn.setCellValueFactory(new PropertyValueFactory<>("haveToDeposit"));

        demandColumn.setCellValueFactory(cellData -> cellData.getValue().demandProperty().asObject());
        demandColumn.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Double demand, boolean empty) {
                super.updateItem(demand, empty);
                if (empty || demand == null) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", demand));
                }
            }
        });

        alreadyDepositColumn.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", item));
                }
            }
        });

        haveToDepositColumn.setCellFactory(col -> new TableCell<Student, Double>() {
            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", item));
                }
            }
        });
    }
}