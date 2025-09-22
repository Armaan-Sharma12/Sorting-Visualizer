package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    public static List<SortStep> sort(int[] array) {
        List<SortStep> steps = new ArrayList<>();
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                steps.add(new SortStep(SortStep.Type.COMPARE, j, j + 1));
                array[j + 1] = array[j];
                steps.add(new SortStep(SortStep.Type.SWAP, j, j + 1));
                j--;
            }
            array[j + 1] = key;
        }

        return steps;
    }
}
