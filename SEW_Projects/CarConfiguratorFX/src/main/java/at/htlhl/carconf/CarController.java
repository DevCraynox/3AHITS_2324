package at.htlhl.carconf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Window;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class CarController {

    // Fields *****************************************************************

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button tuneButton;

    @FXML
    private TextField manufacturerTextField;

    @FXML
    private TextField typeTextFlied;

    @FXML
    private Slider powerSlider;

    @FXML
    private Slider rangeSlider;

    private ResourceBundle resourceBundle;

    private Car model;

    private TuningService tuningService;

    // Instanz creation *******************************************************

    public CarController(){
        resourceBundle = ResourceBundle.getBundle("at.htlhl.carconf.Misc");
        tuningService = new TuningService();
    }

    // Logic ******************************************************************

    protected void init(){
        model = new Car();
        model.setManufacturer("Ford");
        model.setType("GT40");
        model.setPower(199);
        model.setRange(360);

        powerSlider.setMax(Car.MAX_POWER);
        rangeSlider.setMax(Car.MAX_RANGE);

        initBinding();
        initValidation();

        // manufacturerTextField.setText(model.getManufacturer());
        // typeTextFlied.setText(model.getType())
        // powerSlider.setValue(model.getPower());
        // rangeSlider.setValue(model.getRange());
    }

    private void initBinding(){
        manufacturerTextField.textProperty().bindBidirectional(model.manufacturerProperty());
        /*

        CHANGELISTENER

        manufacturerTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.println("oldValue='"+oldValue+"', newValue='"+newValue+"'");
            }
        });
        */
        typeTextFlied.textProperty().bindBidirectional(model.typeProperty());
        powerSlider.valueProperty().bindBidirectional(model.powerProperty);
        rangeSlider.valueProperty().bindBidirectional(model.rangeProperty);
    }

    private void initValidation() {
        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(manufacturerTextField, Validator.createEmptyValidator("Manufacturer is required"));
        validationSupport.registerValidator(rangeSlider, new Validator<Double>() {
            @Override
            public ValidationResult apply(Control control, Double newValue) {
                return ValidationResult.fromErrorIf(control, "Range should be greater than 400km", newValue < 400);
            }
        });
        saveButton.disableProperty().bind(validationSupport.invalidProperty());
    }

    @FXML
    private void updateModel(Car newModel){
        model.setManufacturer(newModel.getManufacturer());
        model.setType(newModel.getType());
        model.setPower(newModel.getPower());
        model.setRange(newModel.getRange());
    }

    @FXML
    protected void loadAction(ActionEvent event) throws IOException {
        System.out.println("Load Action executed...");

        File configFile = new File(App.MODEL_FILE_PATH);
        if (configFile.exists()) {
            try {
                updateModel(App.JSON_MAPPER.readValue(configFile, Car.class));
            } catch (IOException ex) {
                System.err.println("Error loading file: " + ex.getMessage());

                throw new IOException("Simulate Loading Error");
            }

        } else {
            System.err.println("File does not exist");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            Window parentWindow = findParentWindow(event);
            alert.initOwner(parentWindow);
            alert.setTitle(App.APP_NAME);
            alert.setHeaderText(resourceBundle.getString("loadErrorAlert.headerText"));
            alert.setContentText(resourceBundle.getString("loadErrorAlert.contentText"));
            alert.showAndWait();
        }
    }

    @FXML
    protected void saveAction(ActionEvent event){
        System.out.println("Save Action executed...");

        File configFile = new File(App.MODEL_FILE_PATH);
        if (!configFile.exists()) {
            File configDir = new File(App.CONFIG_DIR_PATH);
            configDir.mkdirs();
        }
        try {
            App.JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValue(configFile, model);

            throw new IOException("Simulate Save Error");
        } catch (IOException ex) {
            System.err.println("Error writing the json file: " + ex.getMessage());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(findParentWindow(event));
            alert.setTitle(App.APP_NAME);
            alert.setHeaderText(resourceBundle.getString("saveErrorAlert.headerText"));
            alert.setContentText(resourceBundle.getString("saveErrorAlert.contentText") + " " + ex.getLocalizedMessage());

            // GridPane gridPane = new GridPane();
            // gridPane.add(new Label("Leistung:"), 0, 0);
            // gridPane.add(new TextField(), 0, 1);
            // alert.getDialogPane().setContent(gridPane);

            alert.showAndWait();
        }
    }

    @FXML
    protected void tuneAction(ActionEvent event){
        // System.out.println(model.toString());

        /*
        CounterRunnable counterRunnable = new CounterRunnable(1, model);
        Thread thread = new Thread(counterRunnable);
        thread.start();
         */

        tuningService.tune(findParentWindow(event), model);
    }

    private Window findParentWindow(ActionEvent event) {
        return ((Node) event.getTarget()).getScene().getWindow();
    }
}