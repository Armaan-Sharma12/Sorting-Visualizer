package com.example.sortingvisualizer.ui;

import com.example.sortingvisualizer.core.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.List;

public class SortingVisualizerController {
    @FXML private Canvas canvas;
    @FXML private ComboBox<String> algorithmSelector;
    @FXML private Slider speedSlider;

    private SortController sortController;
    private GraphicsContext gc;
    private Timeline timeline;
    private int currentStepIndex;
    private List<SortStep> steps;

    @FXML
    public void initialize() {
        sortController = new SortController(new ArrayModel(50));
        gc = canvas.getGraphicsContext2D();
        algorithmSelector.getItems().addAll("Bubble", "Selection", "Insertion", "Merge", "Quick", "Heap");
        algorithmSelector.setValue("Bubble");
        drawArray();
    }

    @FXML
    public void handleStart() {
        SortController.Algorithm algo = switch (algorithmSelector.getValue()) {
            case "Selection" -> SortController.Algorithm.SELECTION;
            case "Insertion" -> SortController.Algorithm.INSERTION;
            case "Merge" -> SortController.Algorithm.MERGE;
            case "Quick" -> SortController.Algorithm.QUICK;
            case "Heap" -> SortController.Algorithm.HEAP;
            default -> SortController.Algorithm.BUBBLE;
        };

        sortController.runSort(algo);
        steps = sortController.getSteps();
        currentStepIndex = 0;

        timeline = new Timeline(new KeyFrame(Duration.seconds(speedSlider.getValue()), e -> playStep()));
        timeline.setCycleCount(steps.size());
        timeline.play();
    }

    @FXML
    public void handleShuffle() {
        sortController.shuffleArray();
        drawArray();
    }

    @FXML
    public void handleReset() {
        sortController.resetArray();
        drawArray();
    }

    private void playStep() {
        if (currentStepIndex >= steps.size()) return;

        SortStep step = steps.get(currentStepIndex);
        if (step.getType() == SortStep.Type.SWAP) {
            sortController.getArrayModel().swap(step.getIndex1(), step.getIndex2());
        }
        drawArray(step.getIndex1(), step.getIndex2());
        currentStepIndex++;
    }

    private void drawArray() {
        drawArray(-1, -1);
    }

    private void drawArray(int highlight1, int highlight2) {
        int[] array = sortController.getArrayModel().getArray();
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double barWidth = width / array.length;

        gc.clearRect(0, 0, width, height);

        for (int i = 0; i < array.length; i++) {
            double barHeight = array[i] * (height / 100);
            gc.setFill((i == highlight1 || i == highlight2) ? Color.RED : Color.BLUE);
            gc.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }
}
