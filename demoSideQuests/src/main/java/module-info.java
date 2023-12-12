module com.example.demosidequests {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.demosidequests to javafx.fxml;
    exports com.example.demosidequests;
}