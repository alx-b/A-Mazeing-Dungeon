package com.company;

import java.util.Random;

public class Room {
    private int posY;
    private int posX;
    private Item item;
    private Monster monster;
    private String event;
    private boolean visited = false;

    public Room (int posY, int posX){
        this.posY = posY;
        this.posX = posX;
        this.item = createGold();
        this.event = getRandomEvent();
    }
    // room will have an item (gold), can have enemies.
    // display description of the room?
    // randomize the amount of gold found and where it is found

    private Gold createGold(){
        Random random = new Random();
        int min = 50;
        int max = 150;
        int value = random.nextInt(max + 1 - min) + min;
        return new Gold("Gold", value);
    }

    private String getRandomEvent(){
        Random random = new Random();
        String[] events = {
                "You found %d gold coins in the dirty rags of a skeleton!\n",
                "Something shinny caught your attention in the crevices of the ground, you found %d gold coins!\n"
        };
        int max = events.length;
        int idx = random.nextInt(max);
        return events[idx];
    }

    public void displayRoom(){
        System.out.printf("%s\n", this.event);
    }
}
