module com.example.tp_inf1034_implementation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.tp_inf1034_implementation to javafx.fxml;
    exports com.example.tp_inf1034_implementation;
}