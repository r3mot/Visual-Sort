module visualsort {
    requires javafx.controls;
    requires javafx.fxml;

    opens visualsort to javafx.fxml;
    exports visualsort;
}
