package com.company;

import java.util.Scanner;

public class Store {
    //private Hero hero;

    private Sword woodenSword = new Sword("Wooden Sword", 50);
    private Sword dagger = new Sword("Iron Dagger", 100);
    private Sword claymore = new Sword("Steel Claymore", 150);
    private HealthPotion weakHealthPotion = new HealthPotion("Weak Health Potion", 20);
    private HealthPotion mediumHealthPotion = new HealthPotion("Medium Health Potion", 40);
    private HealthPotion strongHealthPotion = new HealthPotion("Strong Health Potion", 70);


    public void buyItemsInStore(Hero hero) throws InterruptedException {
        boolean isBuying = true;
        while (isBuying) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the store, traveler!");
            System.out.println("What would you like to buy? ");
            System.out.printf("%s \nSword damage: %d \nPrice: 20 gold \ntype 1 and hit <enter> \n", woodenSword.getName(), woodenSword.getSwordDamage());
            System.out.println("__________________________");
            System.out.printf("%s \nSword damage: %d \nPrice: 40 gold \ntype 2 and hit <enter> \n", dagger.getName(), dagger.getSwordDamage());
            System.out.println("__________________________");
            System.out.printf("%s \nSword damage: %d \nPrice: 60 gold \ntype 3 and hit <enter> \n", claymore.getName(), claymore.getSwordDamage());
            System.out.println("__________________________");
            System.out.printf("%s \nHealth Points: %d \nPrice: 5 gold \ntype 4 and hit <enter> \n", weakHealthPotion.getName(), weakHealthPotion.getHealthPoints());
            System.out.println("__________________________");
            System.out.printf("%s \nHealth Points: %d \nPrice: 10 gold \ntype 5 and hit <enter> \n", mediumHealthPotion.getName(), mediumHealthPotion.getHealthPoints());
            System.out.println("__________________________");
            System.out.printf("%s \nHealth Points: %d \nPrice: 15 gold \ntype 6 and hit <enter> \n", strongHealthPotion.getName(), strongHealthPotion.getHealthPoints());
            System.out.println("__________________________");
            System.out.println("To exit store: type 7 and hit <enter>");
            int userInput = Integer.parseInt(scanner.nextLine());
            switch (userInput) {
                case 1:
                    if (hero.getBackpack().totalGold() >= 20) {
                        hero.getBackpack().addItem(woodenSword);
                        hero.setHeroDamage(hero.getDamage() + woodenSword.getSwordDamage()); // Plus both together, or assign swordDamage to heroDamage?
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 2:
                    if (hero.getBackpack().totalGold() >= 40) {
                        hero.getBackpack().addItem(dagger);
                        hero.setHeroDamage(hero.getDamage() + dagger.getSwordDamage());
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 3:
                    if (hero.getBackpack().totalGold() >= 60) {
                        hero.getBackpack().addItem(claymore);
                        hero.setHeroDamage(hero.getDamage() + claymore.getSwordDamage());
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 4:
                    if (hero.getBackpack().totalGold() >= 5) {
                        hero.getBackpack().addItem(weakHealthPotion);
                        hero.restoreHealth(weakHealthPotion);
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 5:
                    if (hero.getBackpack().totalGold() >= 10) {
                        hero.getBackpack().addItem(mediumHealthPotion);
                        hero.restoreHealth(mediumHealthPotion);
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 6:
                    if (hero.getBackpack().totalGold() >= 15) {
                        hero.getBackpack().addItem(strongHealthPotion);
                        hero.restoreHealth(strongHealthPotion);
                    } else {
                        System.out.println("You don't have enough gold.");
                        Thread.sleep(1000);
                    }
                    break;

                case 7:
                    System.out.println("Are you sure you want to quit? \n 'Yes: type 1 and hit <enter>' : 'No: type 2 and hit <enter>'");
                    Thread.sleep(1000);
                    int quitOrStay = Integer.parseInt(scanner.nextLine());
                    switch (quitOrStay) {
                        case 1:
                            isBuying = false;
                            break;
                        case 2:
                            isBuying = true;
                    }
                    break;
            }
        }
    }
}
