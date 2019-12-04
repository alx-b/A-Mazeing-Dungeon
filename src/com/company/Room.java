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
    private DragonBoss dragon = null;

    public DragonBoss getDragon() {
        return dragon;
    }

    public Room(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;

        if (this.name.equals("Store")) {
            addStoreToRoom();
        } else if (this.name.equals("Dragon")){
            addDragonToRoom();
        }
        else {
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
        int rand = randomizer(1, 10);
        if  (rand == 1 || rand == 5){addGoldToRoom();}
        else if (rand == 2 || rand == 7){addRandomPotionToRoom();}
        else if (rand == 4){addRandomSwordToRoom();}
        else if (rand == 8){addRandomMonsterToRoom();}
        else if (rand == 10){
            addRandomMonsterToRoom();
            addGoldToRoom();
        }
        else if (rand == 3 || rand == 6 || rand == 9) {
            addEmptyRoomEvent();
        }
        else{
            System.out.println("That wasn't suppose to happen");
        }
    }

    private void addGoldEvent(){
        String[] events = {
                "You found " + this.gold + " gold coins in the dirty rags of a skeleton!",
                "Something shinny caught your attention in the crevices of the ground,\nyou found " + this.gold + " gold coins!",
                "You found " + this.gold + " gold coins in an unlocked chest!",
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
                "You enter a spacious room with several pillars that reach floor to ceiling,\nunfortunately there is nothing for you",
                "There is nothing in this room.",
                "There is nothing in this room3."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addStoreToRoom() {
        this.store = new Store();
    }

    private void addDragonToRoom(){this.dragon = new DragonBoss("Draken", 1000, 100, 1000 );}

    private void addDragonToothToRoom(Hero hero){
        System.out.println("You have found a dragon tooth!");
         hero.getQuestItemBag().setDragonToothInBag(true);
    }

    private int randomizer(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    private void addPotionEvent(){
        String[] events = {
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addRandomPotionToRoom() {
        HealthPotion[] potions = {
                new HealthPotion("Small health potion", 10),
                new HealthPotion("Medium health potion", 50),
                new HealthPotion("Big health potion", 100)
        };
        int idx = randomizer(0, potions.length - 1);
        this.item = potions[idx];
        addPotionEvent();
    }

    private void addMonsterEvent(){
        String[] events = {
                "This room smells of blood, " + this.monster + " wants to fight!",
                "You sense danger approaching... " + this.monster + " wants to fight!",
                "This " + this.monster + " wants to fight!"
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }
    private void addRandomMonsterToRoom(){
        Monster[] monsters = {
                new Spider("Charlotte the spider", 50,5,50),
                new Bandit("Robin the bandit", 100, 10, 100)
        };
        int idx = randomizer(0, monsters.length - 1);
        this.monster = monsters[idx];
        addMonsterEvent();
    }

    private void addSwordEvent(){
        String[] events = {
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room.",
                "You got " + this.item + " in this room."
        };
        int idx = randomizer(0, events.length - 1);
        this.events.add(events[idx]);
    }

    private void addRandomSwordToRoom(){
        Sword[] swords = {
                new Sword("Wooden Dagger", 2),
                new Sword("Wooden Sword", 4),
                new Sword("Fake Excalibur", 10)
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

    public void displayRoom(Hero hero) throws InterruptedException {
        if (this.store != null) {
            this.store.buyItemsInStore(hero);
        }else if (this.name.equals(("Dragon Tooth"))){
            addDragonToothToRoom(hero);
            this.name = "Room";
            this.visited = true;
        } else if (this.dragon != null){
            this.dragon.quest(hero);
        } else if (!this.visited) {
            for (String event : this.events){
                System.out.printf("%s\n", event);
            }
            if (this.monster != null){
                hero.heroFight(this.monster);
            }
            heroGetItem(hero);
            this.visited = true;
        } else {
            System.out.println("You've already visited this room, nothing new!");
        }
    }
}
