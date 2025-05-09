package at.htlhl.kkm.klassenkassamanagment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * <h4>App</h4>
 * Main Class, to execute the App
 * @author Marcel Frischauf, Emanuel Kurz
 * @version 09.01.2024
 */
public class App extends Application {

    // Constants **************************************************************

    public static final String APP_NAME = "Klassenkassamanager";

    public static final String CONFIG_DIR_PATH = System.getProperty("user.home") + "/." + APP_NAME;

    public static final String MODEL_FILE_PATH = CONFIG_DIR_PATH + "/file.txt";

    // Fields *****************************************************************

    public static String defaultFileName = "kkm.json";

    public static String unit = "€";

    // Methods ****************************************************************

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("kkm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle(APP_NAME);
        stage.setScene(scene);
        stage.show();
    }

    // Main *******************************************************************

    public static void main(String[] args) {
        launch();
    }
}