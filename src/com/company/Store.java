package com.company;

import java.util.Scanner;

public class Store {

    private Sword woodenSword = new Sword("Wooden Sword", 50);
    private Sword dagger = new Sword("Iron Dagger", 100);
    private Sword claymore = new Sword("Steel Claymore", 150);
    private HealthPotion weakHealthPotion = new HealthPotion("Weak Health Potion", 20);
    private HealthPotion mediumHealthPotion = new HealthPotion("Medium Health Potion", 40);
    private HealthPotion strongHealthPotion = new HealthPotion("Strong Health Potion", 70);


    public void buyItemsInStore(Hero hero) {
        boolean isBuying = true;
        while (isBuying) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Welcome to the store, traveler!");
                System.out.println("What would you like to buy?");
                System.out.printf("'1' Name: %s. Sword damage: %d. Price: 20 gold.\n", woodenSword.getName(), woodenSword.getSwordDamage());
                System.out.printf("'2' Name: %s. Sword damage: %d. Price: 40 gold.\n", dagger.getName(), dagger.getSwordDamage());
                System.out.printf("'3' Name: %s. Sword damage: %d. Price: 60 gold.\n", claymore.getName(), claymore.getSwordDamage());
                System.out.printf("'4' Name: %s. Health Points: %d. Price: 5 gold.\n", weakHealthPotion.getName(), weakHealthPotion.getHealthPoints());
                System.out.printf("'5' Name: %s. Health Points: %d. Price: 10 gold.\n", mediumHealthPotion.getName(), mediumHealthPotion.getHealthPoints());
                System.out.printf("'6' Name: %s. Health Points: %d. Price: 15 gold.\n", strongHealthPotion.getName(), strongHealthPotion.getHealthPoints());
                System.out.println("'7' Exit store");
                System.out.print("Enter number: ");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        if (hero.getTotalGoldInBag() >= 20) {
                            youBoughtSword(hero, woodenSword);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                    case 2:
                        if (hero.getTotalGoldInBag() >= 40) {
                            youBoughtSword(hero, dagger);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                case 3:
                        if (hero.getTotalGoldInBag() >= 60) {
                            youBoughtSword(hero, claymore);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                case 4:
                        if (hero.getTotalGoldInBag() >= 5) {
                            youBoughtPotion(hero, weakHealthPotion);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                    case 5:
                        if (hero.getTotalGoldInBag() >= 10) {
                            youBoughtPotion(hero, mediumHealthPotion);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                    case 6:
                        if (hero.getTotalGoldInBag() >= 15) {
                            youBoughtPotion(hero, strongHealthPotion);
                            isBuying = isBuyingMore(hero);
                        } else {
                            notEnoughGold();
                        }
                        break;

                    case 7:
                        System.out.println("Are you sure you want to quit? '1' Yes -- '2' No");
                        int quitOrStay = Integer.parseInt(scanner.nextLine());
                        switch (quitOrStay) {
                            case 1:
                                isBuying = false;
                                break;
                            case 2:
                                isBuying = true;
                        }
                        break;

                    default:
                        System.out.println("You have to choose between 1 and 6!");
                        System.out.println("Hit <enter> to continue");
                        scanner.nextLine();

                }
            } catch (Exception ex) {
                System.out.println("Letters are not allowed! You have to enter a number.");
                System.out.println("Hit <enter> to try again.");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        }
    }

    private void youBoughtSword(Hero hero, Sword sword){
        hero.getBackpack().addItem(sword);
        hero.setHeroDamage(hero.getDamage() + sword.getSwordDamage()); // Plus both together, or assign swordDamage to heroDamage?
        hero.getBagOfGold().removeGold(20);
        System.out.println("You just bought yourself " + sword.getName() + "!");
        System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
        System.out.println("You now deal " + hero.getDamage() + " damage to your enemies.");
        System.out.println("Would you like to buy something else? '1' Yes -- '2' No");
        System.out.print("Enter number: ");
    }

    private void youBoughtPotion(Hero hero, HealthPotion potion){
        hero.getBackpack().addItem(potion);
        hero.restoreHealth(potion);
        hero.getBagOfGold().removeGold(5);
        System.out.println("You just bought yourself " + potion.getName() + "!");
        System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
        System.out.println("Your health is now " + hero.getHealth());
        System.out.println("Would you like to buy something else? '1' Yes -- '2' No");
        System.out.print("Enter number: ");
    }

    private boolean isBuyingMore(Hero hero){
        Scanner scan = new Scanner(System.in);
        int buyMoreOreLeave = Integer.parseInt(scan.nextLine());
        if (buyMoreOreLeave == 1) {
            buyItemsInStore(hero);
        } else if (buyMoreOreLeave == 2) {
            return false;
        }
        return true;
    }

    private void notEnoughGold(){
        System.out.println("You don't have enough gold.");
        System.out.println("Hit <enter> to buy something else");
    }
}
