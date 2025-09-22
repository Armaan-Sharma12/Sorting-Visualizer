package com.example.sortingvisualizer.core;

import java.util.Arrays;
import java.util.Random;

public class ArrayModel {
    private int[] array;
    private final int size;
    private final Random random = new Random();

    public ArrayModel(int size) {
        this.size = size;
        this.array = new int[size];
        generateRandomArray();
    }

    public void generateRandomArray() {
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) + 1; // Values from 1 to 100
        }
    }

    public void resetArray(int[] newArray) {
        this.array = Arrays.copyOf(newArray, newArray.length);
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getValueAt(int index) {
        return array[index];
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public void setArray(int[] newArray) {
        this.array = Arrays.copyOf(newArray, newArray.length);
    }

    public void shuffleArray() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(i, j);
        }
    }
}
