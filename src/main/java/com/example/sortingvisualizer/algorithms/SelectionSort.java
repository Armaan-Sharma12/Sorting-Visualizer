package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static List<SortStep> sort(int[] array) {
        List<SortStep> steps = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                steps.add(new SortStep(SortStep.Type.COMPARE, minIdx, j));
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                steps.add(new SortStep(SortStep.Type.SWAP, i, minIdx));
                int temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }

        return steps;
    }
}
