module at.htlhl.carconf {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;

    opens at.htlhl.carconf to javafx.fxml;
    exports at.htlhl.carconf;
}