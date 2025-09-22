package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    private static List<SortStep> steps;

    public static List<SortStep> sort(int[] array) {
        steps = new ArrayList<>();
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            steps.add(new SortStep(SortStep.Type.SWAP, 0, i));
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        return steps;
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) steps.add(new SortStep(SortStep.Type.COMPARE, left, largest));
        if (right < n) steps.add(new SortStep(SortStep.Type.COMPARE, right, largest));

        if (left < n && array[left] > array[largest]) largest = left;
        if (right < n && array[right] > array[largest]) largest = right;

        if (largest != i) {
            steps.add(new SortStep(SortStep.Type.SWAP, i, largest));
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }
}
