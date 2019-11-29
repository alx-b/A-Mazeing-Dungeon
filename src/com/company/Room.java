package com.company;

import java.util.Random;

public class Room {
    private int posY;
    private int posX;
    private Item item;
    private int gold;
    private Monster monster;
    private String event;
    private boolean visited = false;
    private String name;
    private Store store;

    public Room (String name, int posY, int posX){
        this.name = name;
        this.posY = posY;
        this.posX = posX;
        this.gold = addGold();
        this.event = getRandomEvent();
        if (this.name.equals("Store")){
           this.store = new Store();
        }
    }


    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    // room will have an item (gold), can have enemies.
    // display description of the room?
    // randomize the amount of gold found and where it is found

    private int addGold(){
        Random random = new Random();
        int min = 50;
        int max = 150;
        return random.nextInt(max + 1 - min) + min;
    }

    private String getRandomEvent(){
        Random random = new Random();
        String[] events = {
                "You found " + this.gold + " gold coins in the dirty rags of a skeleton!\n",
                "Something shinny caught your attention in the crevices of the ground, you found " + this.gold + " gold coins!\n",
                "There is nothing in this room.",
                "There is nothing in this room.",
                "There is nothing in this room."
        };
        int max = events.length;
        int idx = random.nextInt(max);
        return events[idx];
    }

    public void heroGetItem(Hero hero){
        if (this.item != null){
            hero.addItemToBackpack(this.item);
        }
        if (this.gold != 0){
            hero.addGoldToBagOfGold(this.gold);
        }
    }

    public void displayRoom(Hero hero){
        if (this.name.equals("Store")){
            this.store.buyItemsInStore(hero);
        }
        if (!this.visited){
            System.out.printf("%s\n", this.event);
            heroGetItem(hero);
            this.visited = true;
        }
        else{
            System.out.println("You've already visited this room, nothing new!");
        }
    }
}
