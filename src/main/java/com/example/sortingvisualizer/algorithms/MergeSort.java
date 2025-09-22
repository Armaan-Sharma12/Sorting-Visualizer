package com.example.sortingvisualizer.algorithms;

import com.example.sortingvisualizer.core.SortStep;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static List<SortStep> steps;

    public static List<SortStep> sort(int[] array) {
        steps = new ArrayList<>();
        mergeSort(array, 0, array.length - 1);
        return steps;
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            steps.add(new SortStep(SortStep.Type.COMPARE, i, j));
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int m = 0; m < temp.length; m++) {
            array[left + m] = temp[m];
            steps.add(new SortStep(SortStep.Type.SWAP, left + m, left + m));
        }
    }
}
