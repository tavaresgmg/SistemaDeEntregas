module SistemaDeEntregas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.teamg.entregas to javafx.fxml;

    exports com.teamg.entregas;
}