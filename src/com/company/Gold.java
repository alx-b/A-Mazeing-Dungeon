package com.company;

public class Gold extends Item{

    private int amountOfGold;

    public Gold(String name, int amountOfGold) {
        super(name);
        this.amountOfGold = amountOfGold;
    }

    @Override
    public String toString() {
        return String.format("You received %d gold!", amountOfGold);
    }
}