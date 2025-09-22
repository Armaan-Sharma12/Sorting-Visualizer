package com.example.sortingvisualizer.core;

import com.example.sortingvisualizer.algorithms.*;
import java.util.List;

public class SortController {
    private ArrayModel arrayModel;
    private List<SortStep> steps;

    public enum Algorithm {
        BUBBLE, SELECTION, INSERTION, MERGE, QUICK, HEAP
    }

    public SortController(ArrayModel arrayModel) {
        this.arrayModel = arrayModel;
    }

    public void runSort(Algorithm algorithm) {
        int[] arrayCopy = arrayModel.getArray().clone();

        switch (algorithm) {
            case BUBBLE -> steps = BubbleSort.sort(arrayCopy);
            case SELECTION -> steps = SelectionSort.sort(arrayCopy);
            case INSERTION -> steps = InsertionSort.sort(arrayCopy);
            case MERGE -> steps = MergeSort.sort(arrayCopy);
            case QUICK -> steps = QuickSort.sort(arrayCopy);
            case HEAP -> steps = HeapSort.sort(arrayCopy);
        }
    }

    public List<SortStep> getSteps() {
        return steps;
    }

    public ArrayModel getArrayModel() {
        return arrayModel;
    }

    public void resetArray() {
        arrayModel.generateRandomArray();
    }

    public void shuffleArray() {
        arrayModel.shuffleArray();
    }
}
