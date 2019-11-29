package com.company;

import java.util.Random;

public class Room {
    private String name;
    private int row;
    private int col;
    private int gold = 0;
    private boolean visited = false;
    private String event = null;
    private Item item = null;
    private Monster monster = null;
    private Store store = null;

    public Room(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;

        if (this.name.equals("Store")) {
            addStoreToRoom();
        } else {
            addRandomEventToRoom();
        }

    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private void addGoldToRoom() {
        this.gold = randomizer(50, 100);
    }

    private void addRandomEventToRoom() {
        String[] events = {
                "You found " + this.gold + " gold coins in the dirty rags of a skeleton!\n",
                "Something shinny caught your attention in the crevices of the ground,\n you found " + this.gold + " gold coins!\n",
                "There is nothing in this room3.",
                "There is nothing in this room4.",
                "There is nothing in this room5."
        };
        int idx = randomizer(0, events.length - 1);
        this.event = events[idx];
    }

    private void addStoreToRoom() {
        this.store = new Store();
    }

    private int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private void addRandomPotionToRoom() {
        HealthPotion[] potions = {
                new HealthPotion("Small health potion", 50),
                new HealthPotion("Medium health potion", 100),
                new HealthPotion("Big health potion", 150)
        };
        int idx = randomizer(0, potions.length - 1);
        this.item = potions[idx];
    }

    public void heroGetItem(Hero hero) {
        if (this.item != null) {
            hero.addItemToBackpack(this.item);
        }
        if (this.gold != 0) {
            hero.addGoldToBagOfGold(this.gold);
        }
    }

    public void displayRoom(Hero hero) {
        if (this.store != null) {
            this.store.buyItemsInStore(hero);
        } else if (!this.visited) {
            System.out.printf("%s\n", this.event);
            heroGetItem(hero);
            this.visited = true;
        } else {
            System.out.println("You've already visited this room, nothing new!");
        }
    }
}
