package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    private static List<SortStep> steps;

    public static List<SortStep> sort(int[] array) {
        steps = new ArrayList<>();
        quickSort(array, 0, array.length - 1);
        return steps;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            steps.add(new SortStep(SortStep.Type.COMPARE, j, high));
            if (array[j] < pivot) {
                i++;
                steps.add(new SortStep(SortStep.Type.SWAP, i, j));
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        steps.add(new SortStep(SortStep.Type.SWAP, i + 1, high));
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
