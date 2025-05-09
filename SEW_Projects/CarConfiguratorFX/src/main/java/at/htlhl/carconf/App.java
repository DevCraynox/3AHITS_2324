package at.htlhl.carconf;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {

    // Constants **************************************************************

    public static final String APP_NAME = "CarConfiguratorFX";

    public static final String CONFIG_DIR_PATH = System.getProperty("user.home") + "/." + APP_NAME;

    public static final String MODEL_FILE_PATH = CONFIG_DIR_PATH + "/car.json";

        public static final ObjectMapper JSON_MAPPER = new ObjectMapper();


    // Logic ******************************************************************

    @Override
    public void start(Stage stage) throws IOException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("at.htlhl.carconf.car-view");

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("car-view.fxml"), resourceBundle);

        Pane carViewPane = fxmlLoader.load();

        CarController carController = fxmlLoader.getController();
        carController.init();

        Scene scene = new Scene(carViewPane, 640, 480);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    // Main *******************************************************************

    public static void main(String[] args) {

        // Force a specific locale (e.g. ENGLISH, GERMAN, ...)
        // Locale.setDefault(Locale.ENGLISH);
        Locale.setDefault(new Locale("de", "DE"));

        launch();
    }
}