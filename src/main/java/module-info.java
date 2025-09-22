module com.example.sortingvisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.sortingvisualizer.ui;
    opens com.example.sortingvisualizer.ui to javafx.fxml;
}
