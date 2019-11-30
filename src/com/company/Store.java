package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
                System.out.println("");
                System.out.println("Welcome to the store, traveler!");
                System.out.println("What would you like to buy? ");
                System.out.println("");
                System.out.printf("Name: %s. Sword damage: %d. Price: 20 gold. Type '1' to buy and hit <enter> \n", woodenSword.getName(), woodenSword.getSwordDamage());
                System.out.println("__________________________");
                System.out.printf("Name: %s. Sword damage: %d. Price: 40 gold. Type '2' to buy and hit <enter> \n", dagger.getName(), dagger.getSwordDamage());
                System.out.println("__________________________");
                System.out.printf("Name: %s. Sword damage: %d. Price: 60 gold. Type '3' to buy and hit <enter> \n", claymore.getName(), claymore.getSwordDamage());
                System.out.println("__________________________");
                System.out.printf("Name: %s. Health Points: %d. Price: 5 gold. Type '4' and hit <enter> \n", weakHealthPotion.getName(), weakHealthPotion.getHealthPoints());
                System.out.println("__________________________");
                System.out.printf("Name: %s. Health Points: %d. Price: 10 gold. Type '5' and hit <enter> \n", mediumHealthPotion.getName(), mediumHealthPotion.getHealthPoints());
                System.out.println("__________________________");
                System.out.printf("Name: %s. Health Points: %d. Price: 15 gold. Type '6' and hit <enter> \n", strongHealthPotion.getName(), strongHealthPotion.getHealthPoints());
                System.out.println("__________________________");
                System.out.println("To exit store: type 7 and hit <enter>");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        if (hero.getTotalGoldInBag() >= 20) {
                            hero.getBackpack().addItem(woodenSword);
                            hero.setHeroDamage(hero.getDamage() + woodenSword.getSwordDamage()); // Plus both together, or assign swordDamage to heroDamage?
                            hero.getBagOfGold().removeGold(20);
                            System.out.println("You just bought yourself " + woodenSword.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("You now deal " + hero.getDamage() + " damage to your enemies.");
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        if (hero.getTotalGoldInBag() >= 40) {
                            hero.getBackpack().addItem(dagger);
                            hero.setHeroDamage(hero.getDamage() + dagger.getSwordDamage());
                            hero.getBagOfGold().removeGold(40);
                            System.out.println("You just bought yourself " + dagger.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("You now deal " + hero.getDamage() + " damage to your enemies.");
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        if (hero.getTotalGoldInBag() >= 60) {
                            hero.getBackpack().addItem(claymore);
                            hero.setHeroDamage(hero.getDamage() + claymore.getSwordDamage());
                            hero.getBagOfGold().removeGold(60);
                            System.out.println("You just bought yourself " + claymore.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("You now deal " + hero.getDamage() + " damage to your enemies.");
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        if (hero.getTotalGoldInBag() >= 5) {
                            hero.getBackpack().addItem(weakHealthPotion);
                            hero.restoreHealth(weakHealthPotion);
                            hero.getBagOfGold().removeGold(5);
                            System.out.println("You just bought yourself " + weakHealthPotion.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("Your health is now " + hero.getHealth());
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 5:
                        if (hero.getTotalGoldInBag() >= 10) {
                            hero.getBackpack().addItem(mediumHealthPotion);
                            hero.restoreHealth(mediumHealthPotion);
                            hero.getBagOfGold().removeGold(10);
                            System.out.println("You just bought yourself " + mediumHealthPotion.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("Your health is now " + hero.getHealth());
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 6:
                        if (hero.getTotalGoldInBag() >= 15) {
                            hero.getBackpack().addItem(strongHealthPotion);
                            hero.restoreHealth(strongHealthPotion);
                            hero.getBagOfGold().removeGold(15);
                            System.out.println("You just bought yourself " + strongHealthPotion.getName() + "!");
                            System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
                            System.out.println("Your health is now " + hero.getHealth());
                            System.out.println("Would you like to buy something else? If YES: type 1 -- If NO: type 2 and hit <enter>");
                            int buyMoreOreLeave = Integer.parseInt(scanner.nextLine());
                            if (buyMoreOreLeave == 1) {
                                buyItemsInStore(hero);
                            } else if (buyMoreOreLeave == 2) {
                                isBuying = false;
                                break;
                            }
                        } else {
                            System.out.println("You don't have enough gold.");
                            System.out.println("Hit <enter> to buy something else");
                            scanner.nextLine();
                        }
                        break;

                    case 7:
                        System.out.println("Are you sure you want to quit? \n 'YES: type 1 and hit <enter>' : 'NO: type 2 and hit <enter>'");
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
}
