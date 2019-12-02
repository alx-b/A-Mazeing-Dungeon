package com.company;

public abstract class Item {

    private String name;
    protected int amountOfGold;
    private int price = 0;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
