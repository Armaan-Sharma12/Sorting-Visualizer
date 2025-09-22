package com.example.sortingvisualizer.core;

public class SortStep {
    public enum Type { COMPARE, SWAP }

    private final Type type;
    private final int index1;
    private final int index2;

    public SortStep(Type type, int index1, int index2) {
        this.type = type;
        this.index1 = index1;
        this.index2 = index2;
    }

    public Type getType() { return type; }
    public int getIndex1() { return index1; }
    public int getIndex2() { return index2; }
}
