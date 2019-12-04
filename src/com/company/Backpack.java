package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Backpack extends Item {

    private static final int MAX_TOTAL_ITEM = 10;
    private ArrayList<Item> items = new ArrayList<>();

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input item name which you want to remove from the Backpack");
        String nameToSearchFor = scanner.nextLine();
        //nameToSearchFor.toLowerCase();

        java.util.Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            if (iter.next().getName().equals(nameToSearchFor)) {
                iter.remove();
                break;
            }
        }
    }

    public void showItemsInBackpack() {
        if (items == null) {
            System.out.println("Backpack is empty.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void removeItemFromBackpack(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showDescription() {
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
