package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Backpack extends Item {

    private static final int MAX_TOTAL_ITEM = 10;
    private ArrayList<Item> items = new ArrayList<>();

    public Backpack(String name, int value) {
        super(name, value);
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
        System.out.println("Enter item name, in lower case letters, you wish to remove");
        String nameToSearchFor = scanner.nextLine();
        nameToSearchFor.toLowerCase();

        java.util.Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            if (iter.next().getName().equals(nameToSearchFor)) {
                iter.remove();
                System.out.println(nameToSearchFor + " is removed from your backpack.");
                break;
            }
            else{
                System.out.println("Item with this name not found.");
                break;
            }
        }
    }

    public void showItemsInBackpack() {
        if (items.isEmpty()) {
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

    public int numberOfItem(){
        return this.items.size();
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public String toString() {
        String results = "+";
        for (Item item : items) {
            results += item.toString();
        }
        return results;
    }
}
