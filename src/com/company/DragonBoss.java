package com.company;

import java.util.Scanner;

public class DragonBoss extends Monster{


    public DragonBoss(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    public void dragonBossQuest() throws InterruptedException {
        System.out.println("Hello, traveler! Are you here for my treasure? You can either fight me for it, or do me a quest and I'll give it to you.");
        System.out.println("___________________");
        System.out.println("To fight dragon: type 1 and hit <enter>");
        System.out.println("To receive quest: type 2 and hit <enter>");
        Scanner scanner = new Scanner(System.in);
        int userInput = Integer.parseInt(scanner.nextLine());

        switch (userInput){
            case 1:
                System.out.println("Shall be it!");
                //hero.heroFight();
                Thread.sleep(1000);
                break;

            case 2:
                System.out.println("I have lost my precious tooth somewhere in this maze, go find it, and I will reward you.");


        }
    }
    public int getDamage(){
        return this.damage;
    }

    @Override
    public String toString() {
        return "DragonBoss{}";
    }
}
