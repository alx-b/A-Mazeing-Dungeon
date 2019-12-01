package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Backpack extends Item {

    private static final int MAX_TOTAL_ITEM = 10;
    private ArrayList<Item> items = new ArrayList<>();
    //private static final int MIN_TOTAL_GOLD = 100;
    //private int totalGold = MIN_TOTAL_GOLD;

    public Backpack(String name) {
        super(name);
    }


    public void addItem(Item newItem) {
        if (items.size() < MAX_TOTAL_ITEM) {
            items.add(newItem);
        } else {
            System.out.println("You have already " + MAX_TOTAL_ITEM + " items. You can't add anymore.");
        }
    }

    public void removeItem() {
        System.out.println("The backpack contains the following items ; ");
        System.out.println(items);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input item name which you want to remove from the Backpack");
        String str = scanner.nextLine();
        String nameToSearchFor = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

        java.util.Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            if (iter.next().getName().equals(nameToSearchFor)) {
                iter.remove();
            }
        }
    }
/*
    public int totalGold() {
        totalGold = MIN_TOTAL_GOLD;
        for (Item item : items) {
            if (item.getName().equals("Gold")) {
                totalGold += item.getAmountOfGold();
            }
        }
        return totalGold;
    }
*/
    //getAmount() == new items pris           här vi måste ändras!
/*
    public void buyItemWithGold(Item newItem) {
        System.out.println("You have "+ totalGold() + " gold.");
        if (totalGold < newItem.getAmount()) {
            System.out.println("You don't have enough gold.");
        }
        else if (totalGold > newItem.getAmount() && items.size()> MAX_TOTAL_ITEM) {
            System.out.println("You have too much items.");
        }
        else if (totalGold > newItem.getAmount() && items.size()< MAX_TOTAL_ITEM){
            System.out.println("Thank you!");
            addItem(newItem);
            totalGold -= newItem.getAmount();
            System.out.println("Now your total gold is " + totalGold);
        }
    }*/


    public void showDescription() {
        //System.out.println("You have "+ totalGold() + " gold.");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public String toString() {
        String results = "+";
        for (Item item : items) {
            results += item.toString();
        }
        return results;
    }
}
