package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Backpack extends Item {

    private static final float MAX_TOTAL_WEIGHT = 5.0f;
    private ArrayList<Item> items = new ArrayList<>();
    private float totalWeightWithBackpack = 0;
    private int totalGold = 0;

    public Backpack(String name, float weight, int value) {
        super(name, weight, value);
    }


    public void addItem(Item newItem) {
        totalWeightWithBackpack = getWeight() + newItem.getWeight();
        if (totalWeightWithBackpack <= MAX_TOTAL_WEIGHT) {
            items.add(newItem);
        } else {
            totalWeightWithBackpack = totalWeightWithBackpack - newItem.getWeight();
            System.out.println("Too heavy, can't add item.");
        }
    }


    public float getWeight() {
        return super.getWeight() + getTotalWeightWithoutBP();
    }   ///total weight with backpack

    private float getTotalWeightWithoutBP() {
        float total = 0;
        for (Item item : items) {
            total += item.getWeight();
        }
        return total;
    }

    public void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input item name which you want to remove from the Backpack");
        String str = scanner.nextLine();
        String nametoSearchFor = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();   // when you input "gold", it transforms Gold automatiaclly
        for (Item item : items) {
            if (nametoSearchFor.equals(item.getName())) {
                items.remove(item);
                totalWeightWithBackpack -= item.getWeight();
            }
        }
    }

    public int totalGold() {

        for (Item item : items) {
            String[] parts = item.getName().split("-");         //it works iff golds names are like Gold-1, Gold-2 ...
            String firstPart = parts[0];
            if (firstPart.equals("Gold")) {
                totalGold += item.getValue();
            }
        }
        return totalGold;
    }

    public void buyItemWithGold(Item newItem) {
        if (totalGold > newItem.getValue()) {
            addItem(newItem);
            totalGold -= newItem.getValue();
        } else {
            System.out.println("You don't have enough gold.");
        }
    }


    @Override
    public void showDescription() {
        System.out.println("This backpack is " + super.getWeight()+ "kg. Total gold is "+ totalGold + " and it contains the following items:");
        for (Item item : items){
            item.showDescription();
        }
    }
}