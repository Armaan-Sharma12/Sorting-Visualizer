package com.example.sortingvisualizer.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SortingVisualizerApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var fxmlUrl = getClass().getResource("/com/example/sortingvisualizer/ui/SortingVisualizer.fxml");
        System.out.println("FXML path: " + fxmlUrl); // Should NOT be null

        if (fxmlUrl == null) {
            throw new RuntimeException("FXML file not found on classpath at /com/example/sortingvisualizer/ui/SortingVisualizer.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load());
        stage.setTitle("Sorting Algorithm Visualizer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}