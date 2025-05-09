module at.htlhl.kkm.klassenkassamanagment {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens at.htlhl.kkm.klassenkassamanagment to javafx.fxml;
    exports at.htlhl.kkm.klassenkassamanagment;
}