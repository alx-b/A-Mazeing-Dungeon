package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private String name;
    private int row;
    private int col;
    private int gold = 0;
    private boolean visited = false;
    private ArrayList<String> events = new ArrayList<>();
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
    // Getters
    public String getName() { return name; }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }


    private void addRandomEventToRoom() {
        int rand = randomizer(1, 8);
        if  (rand == 1){addGoldToRoom();}
        else if (rand == 2){addRandomPotionToRoom();}
        else if (rand == 3){addRandomSwordToRoom();}
        else if (rand == 4){addRandomMonsterToRoom();}
        else if (rand == 5){
            addGoldToRoom();
            addRandomMonsterToRoom();
        }
        else if (rand == 6 || rand == 7 || rand == 8) {
            addEmptyRoomEvent();
        }
        else{
            System.out.println("That wasn't suppose to happen");
        }
    }

    private void addGoldEvent(){
        String[] events = {
                "You found " + this.gold + " gold coins in the dirty rags of a skeleton!\n",
                "Something shinny caught your attention in the crevices of the ground,\n you found " + this.gold + " gold coins!\n",
                "You found " + this.gold + "gold coins in an unlocked chest!",
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addGoldToRoom() {
        this.gold = randomizer(50, 100);
        addGoldEvent();
    }

    private void addEmptyRoomEvent(){
        String[] events = {
                "There is nothing in this room1.",
                "There is nothing in this room2.",
                "There is nothing in this room3."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addStoreToRoom() {
        this.store = new Store();
    }

    private int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private void addPotionEvent(){
        String[] events = {
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room2.",
                "You got " + this.item + " in this room3."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addRandomPotionToRoom() {
        HealthPotion[] potions = {
                new HealthPotion("Small health potion", 50),
                new HealthPotion("Medium health potion", 100),
                new HealthPotion("Big health potion", 150)
        };
        int idx = randomizer(0, potions.length - 1);
        this.item = potions[idx];
        addPotionEvent();
    }

    private void addMonsterEvent(){
        String[] events = {
                "This " + this.monster + " wants to fight!",
                "This " + this.monster + " wants to fight!2",
                "This " + this.monster + " wants to fight!3"
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }
    private void addRandomMonsterToRoom(){
        Monster[] monsters = {
                new Spider("Spider", 50,5,50),
                new Bandit("Bandit", 100, 10, 100)
        };
        int idx = randomizer(0, monsters.length - 1);
        this.monster = monsters[idx];
        addMonsterEvent();
    }

    private void addSwordEvent(){
        String[] events = {
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room2.",
                "You got " + this.item + " in this room3."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addRandomSwordToRoom(){
        Sword[] swords = {
                new Sword("sword1", 2),
                new Sword("sword2", 4),
        };
        int idx = randomizer(0, swords.length - 1);
        this.item = swords[idx];
        addSwordEvent();
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
            for (String event : this.events){
                System.out.printf("%s\n", event);
            }
            heroGetItem(hero);
            this.visited = true;
        } else {
            System.out.println("You've already visited this room, nothing new!");
        }
    }
}
1