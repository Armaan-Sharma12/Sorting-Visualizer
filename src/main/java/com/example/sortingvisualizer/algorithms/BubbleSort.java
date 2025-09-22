package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static List<SortStep> sort(int[] array) {
        List<SortStep> steps = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                steps.add(new SortStep(SortStep.Type.COMPARE, j, j + 1));
                if (array[j] > array[j + 1]) {
                    steps.add(new SortStep(SortStep.Type.SWAP, j, j + 1));
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return steps;
    }
}
