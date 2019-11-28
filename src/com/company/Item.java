package com.company;

public abstract class Item {

    private String name;
    protected int amountOfGold;


    public Item(String name) {
        this.name = name;
    }

    public int getAmountOfGold() {
        return amountOfGold;
    }

    public String getName() {
        return name;
    }

  @Override
    public abstract String toString();
}
