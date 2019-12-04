package com.company;

import java.util.Scanner;

public class Store {

    private Sword goldenSword = new Sword("Golden Sword", 50);
    private Sword dagger = new Sword("Iron Dagger", 100);
    private Sword claymore = new Sword("Steel Claymore", 150);
    private HealthPotion weakHealthPotion = new HealthPotion("Weak Health Potion", 20);
    private HealthPotion mediumHealthPotion = new HealthPotion("Medium Health Potion", 40);
    private HealthPotion strongHealthPotion = new HealthPotion("Strong Health Potion", 100);


    public Store() {
        goldenSword.setPrice(70);
        dagger.setPrice(100);
        claymore.setPrice(200);
        weakHealthPotion.setPrice(10);
        mediumHealthPotion.setPrice(20);
        strongHealthPotion.setPrice(50);
    }

    public void buyItemsInStore(Hero hero) {
        boolean isBuying = true;
        while (isBuying) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\033[33;1;1mWelcome to the store, traveler!\033[0m");
                System.out.println("\033[33;1;1mWhat would you like to buy?\033[0m");
                System.out.printf(
                        "'1' Name: %s. Sword damage: %d. Price: %d gold.\n",
                        goldenSword.getName(), goldenSword.getSwordDamage(), goldenSword.getPrice()
                );
                System.out.printf(
                        "'2' Name: %s. Sword damage: %d. Price: %d gold.\n",
                        dagger.getName(), dagger.getSwordDamage(), dagger.getPrice()
                );
                System.out.printf(
                        "'3' Name: %s. Sword damage: %d. Price: %d gold.\n",
                        claymore.getName(), claymore.getSwordDamage(), claymore.getPrice()
                );
                System.out.printf(
                        "'4' Name: %s. Health Points: %d. Price: %d gold.\n",
                        weakHealthPotion.getName(), weakHealthPotion.getHealthPoints(), weakHealthPotion.getPrice()
                );
                System.out.printf(
                        "'5' Name: %s. Health Points: %d. Price: %d gold.\n",
                        mediumHealthPotion.getName(), mediumHealthPotion.getHealthPoints(), mediumHealthPotion.getPrice()
                );
                System.out.printf(
                        "'6' Name: %s. Health Points: %d. Price: %d gold.\n",
                        strongHealthPotion.getName(), strongHealthPotion.getHealthPoints(), strongHealthPotion.getPrice()
                );
                System.out.println("'7' Exit store");
                System.out.print("Enter number: ");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        if (hero.getTotalGoldInBag() >= goldenSword.getPrice()) {
                            youBoughtSword(hero, goldenSword);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 2:
                        if (hero.getTotalGoldInBag() >= dagger.getPrice()) {
                            youBoughtSword(hero, dagger);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 3:
                        if (hero.getTotalGoldInBag() >= claymore.getPrice()) {
                            youBoughtSword(hero, claymore);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 4:
                        if (hero.getTotalGoldInBag() >= weakHealthPotion.getPrice()) {
                            youBoughtPotion(hero, weakHealthPotion);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 5:
                        if (hero.getTotalGoldInBag() >= mediumHealthPotion.getPrice()) {
                            youBoughtPotion(hero, mediumHealthPotion);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 6:
                        if (hero.getTotalGoldInBag() >= strongHealthPotion.getPrice()) {
                            youBoughtPotion(hero, strongHealthPotion);
                        } else {
                            notEnoughGold();
                        }
                        break;
                    case 7:
                        System.out.println("Bye, hope to see you soon!");
                        isBuying = false;
                        break;
                    default:
                        System.out.println("Enter a number between 1-7 to make a choice.");
                        System.out.println("Hit <enter> to continue");
                        scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.println("Enter a number between 1-7 to make a choice.");
                System.out.println("Hit <enter> to try again.");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        }
    }

    private void youBoughtSword(Hero hero, Sword sword) {
        hero.getBackpack().addItem(sword);
        hero.getBagOfGold().removeGold(sword.getPrice());
        System.out.println("You just bought yourself " + sword.getName() + "!");
        System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
        System.out.println("You now deal " + hero.getDamage() + " damage to your enemies.");

    }

    private void youBoughtPotion(Hero hero, HealthPotion potion) {
        hero.getBackpack().addItem(potion);
        hero.getBagOfGold().removeGold(potion.getPrice());
        System.out.println("You just bought yourself " + potion.getName() + "!");
        System.out.println("You have " + hero.getBagOfGold().getAmountOfGold() + " gold left");
        System.out.println("Your health is now " + hero.getHealth());

    }

    private void notEnoughGold() {
        System.out.println("You don't have enough gold.");
        System.out.println("Hit <enter> to buy something else");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}
