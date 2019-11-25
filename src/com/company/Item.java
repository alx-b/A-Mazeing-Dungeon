package com.company;

public abstract class Item {

    private String name;
    private float weight;
    private int value;

    public Item(String name, float weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public abstract String toString();
}