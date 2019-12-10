package com.company;

import java.util.Random;

public class Room {
    private String name;
    private int row;
    private int col;
    private boolean visited = false;

    public Room(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }
    // Getters
    public String getName() { return name; }
    public int getRow() { return row; }
    public int getCol() { return col; }

    private void addRandomEventToRoom(Hero hero) throws InterruptedException {
        int rand = randomizer(1, 10);
        if (rand == 1 || rand == 5) {
            gold(hero);
        } else if (rand == 2 || rand == 7) {
            potion(hero);
        } else if (rand == 4) {
            sword(hero);
        } else if (rand == 8) {
            monster(hero);
        } else if (rand == 10) {
            monster(hero);
            gold(hero);
        } else if (rand == 3 || rand == 6 || rand == 9) {
            emptyRoomEvent();
        } else {
            System.out.println("That wasn't suppose to happen");
        }
    }

    public void displayRoom(Hero hero) throws InterruptedException {
        // Display whatever is going on in a specific room.
        //=================================================
        /*
        if (this.name.equals(("Dragon Tooth"))) {
            addDragonToothToRoom(hero);
            this.name = "Room";
            this.visited = true;
        } else
        */
        if (!this.visited) {
            addRandomEventToRoom(hero);
            this.visited = true;
        } else {
            System.out.println("You've already visited this room, nothing new!");
        }
    }

    private void gold(Hero hero){
        int gold = randomizer(50, 100);
        String event = goldEvent(gold);
        System.out.println(event);
        hero.addGoldToBagOfGold(gold);
    }

    private String goldEvent(int gold){
        String[] events = {
                "You found " + gold + " gold coins in the dirty rags of a skeleton!",
                "Something shinny caught your attention in the crevices of the ground,\nyou found " + gold + " gold coins!",
                "You found " + gold + " gold coins in an unlocked chest!",
        };
        int idx = randomizer(0, events.length - 1);
        return events[idx];
    }

    private void emptyRoomEvent(){
        String[] events = {
                "You enter a spacious room with several pillars that reach floor to ceiling,\nunfortunately there is nothing for you",
                "There is nothing in this room.",
                "There is nothing in this room."
        };
        int idx = randomizer(0, events.length - 1);
        System.out.println(events[idx]);
    }
/*
    private void addDragonToothToRoom(Hero hero) {
        System.out.println("You have found a dragon tooth!");
        hero.getQuestItemBag().setDragonToothInBag(true);
    }
*/
    private int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private void potion(Hero hero){
        HealthPotion potion = randomPotion();
        String event = itemEvent(potion);
        System.out.println(event);
        hero.addItemToBackpack(potion);
    }

    private HealthPotion randomPotion() {
        HealthPotion[] potions = {
                new HealthPotion("Small health potion", 10, 5),
                new HealthPotion("Medium health potion", 50, 15),
                new HealthPotion("Big health potion", 100, 30)
        };
        int idx = randomizer(0, potions.length - 1);
        return potions[idx];
    }

    private String itemEvent(Item item){
        String[] events = {
                "You got " + item + " in this room.",
                "You got " + item + " in this room.",
                "You got " + item + " in this room."
        };
        int idx = randomizer(0, events.length - 1);
        return events[idx];
    }

    private void monster(Hero hero) throws InterruptedException{
        Monster monster = randomMonster();
        String event = monsterEvent(monster);
        System.out.println(event);
        hero.heroFight(monster);
    }

    private Monster randomMonster(){
        Monster[] monsters = {
                new Spider("Charlotte the spider", 50, 5, 50),
                new Bandit("Robin the bandit", 100, 10, 100)
        };
        int idx = randomizer(0, monsters.length - 1);
        return monsters[idx];
    }

    private String monsterEvent(Monster monster){
        String[] events = {
                "This room smells of blood, " + monster + " wants to fight!",
                "You sense danger approaching... " + monster + " wants to fight!",
                "This " + monster + " wants to fight!"
        };
        int idx = randomizer(0, events.length - 1);
        return events[idx];
    }

    private void sword(Hero hero){
        Sword sword = randomSword();
        String event = itemEvent(sword);
        System.out.println(event);
        hero.addItemToBackpack(sword);
    }

    private Sword randomSword() {
        Sword[] swords = {
                new Sword("Wooden Dagger", 2, 10),
                new Sword("Wooden Sword", 4, 20),
                new Sword("Fake Excalibur", 10, 50)
        };
        int idx = randomizer(0, swords.length - 1);
        return swords[idx];
    }

}
