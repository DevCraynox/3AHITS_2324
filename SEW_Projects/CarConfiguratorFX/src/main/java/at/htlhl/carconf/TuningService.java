package at.htlhl.carconf;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Window;

public class TuningService extends Service<Integer> {

    // Fields *****************************************************************

    private Alert tuneAlert;
    private final Label progressLabel;
    private final ProgressBar progressBar;

    private Window actualParentWindow;
    private Car model;

    // Instance creation ******************************************************

    public TuningService() {
        super();

        progressLabel = new Label();
        progressBar = new ProgressBar(0);

        progressLabel.textProperty().bind(messageProperty());
        progressBar.progressProperty().bind(progressProperty());

        progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                model.setPower(model.getPower() + 1);
            }
        });

        setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
                tuneAlert.hide();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(actualParentWindow);
                alert.setTitle(App.APP_NAME);
                alert.setHeaderText("Tuning erfolgreich");
                alert.show();
            }
        });

        setOnCancelled(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                tuneAlert.hide();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(actualParentWindow);
                alert.setTitle(App.APP_NAME);
                alert.setHeaderText("Tuning abgebrochen!");
                alert.show();
            }
        });
    }

    @Override
    protected Task<Integer> createTask() {
        return new TuneTask();
    }

    // Helper Methods *********************************************************

    private Alert buildProgressAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(App.APP_NAME);
        alert.setHeaderText("Tuning in progress...");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(progressLabel, 0, 0);
        gridPane.add(progressBar, 0, 1);

        GridPane.setHgrow(progressLabel, Priority.ALWAYS);
        GridPane.setHgrow(progressBar, Priority.ALWAYS);
        progressBar.setMaxWidth(Double.MAX_VALUE);

        alert.getDialogPane().setContent(gridPane);
        alert.getDialogPane().setPrefWidth(400);

        alert.getButtonTypes().setAll(ButtonType.CANCEL);

        return alert;
    }

    // Public API *************************************************************

    public void tune(Window parentWindow, Car model) {
        this.actualParentWindow = parentWindow;
        this.model = model;

        tuneAlert = buildProgressAlert();
        tuneAlert.initOwner(parentWindow);
        tuneAlert.show();

        reset();
        start();
    }




    /**
     * Inner class TuneTask
     */
    private class TuneTask extends Task<Integer> {

        // Instance creation **************************************************

        private TuneTask() {
            super();
        }

        // Methods ************************************************************

        @Override
        protected Integer call() throws Exception {
            int actualTunePart;
            int totalTuneParts = 10;

            for (actualTunePart = 1; actualTunePart <= totalTuneParts; actualTunePart++) {

                System.out.println("Part: " + actualTunePart);

                updateProgress(actualTunePart, totalTuneParts);
                updateMessage("Part " + actualTunePart + " of " + totalTuneParts + " is tuned!");

                if (tuneAlert.getResult() == ButtonType.CANCEL) {
                    cancel();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    if (isCancelled()) {
                        updateMessage("Tuning canelled");
                        break;
                    }
                }
            }
            return actualTunePart;
        }
    }
}
