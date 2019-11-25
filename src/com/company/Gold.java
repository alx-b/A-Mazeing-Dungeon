package com.company;

public class Gold extends Item{

    public Gold(String name, float weight, int value) {
        super(name, weight, value);
    }


    @Override
    public void showDescription() {
        System.out.println("Item name : "+ getName() + ", Weight : " + getWeight() + " kg, Value : " + getValue()+ "\n");
    }
}
