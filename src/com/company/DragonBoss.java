package com.company;

import java.util.Scanner;

public class DragonBoss extends Monster {

    public DragonBoss(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    public void quest(Hero hero) {
        boolean isMakingChoice = true;
        while (isMakingChoice) {
            try {
                System.out.println("Hello, traveler! Are you here for my treasure? You can either fight me for it, or do me a quest and I'll give it to you.");
                System.out.println("___________________");
                System.out.println("'1' To fight dragon");
                System.out.println("'2' To receive quest");
                System.out.println("'3' To quit dialog");
                Scanner scanner = new Scanner(System.in);
                int userInput = Integer.parseInt(scanner.nextLine());

                Scanner scanner = new Scanner(System.in);
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        System.out.println("Shall be it!");
                        hero.heroFight(this);
                        if (hero.getHealth() > 0 && this.getHealth() <= 0) {

                            System.out.println("It's enough! I give up. You are a worthy opponent, therefore, i grant you my treasure! ");
                            System.out.println("---CONGRATULATIONS ON COMPLETING THE GAME!---");
                            System.out.println("Hit <enter> to EXIT.");
                            scanner.nextLine();
                            System.exit(0);
                        }
                        break;
                    case 2:
                        System.out.println("I have lost my precious tooth somewhere in this maze, go find it, and I will reward you.");
                        if (hero.getQuestItemBag().isDragonToothInBag()) {
                            System.out.println("I see you have found my tooth! Thank you, traveler. I'll give you my treasure for your troubles.");
                            System.out.println("---CONGRATULATIONS ON COMPLETING THE GAME!---");
                            System.out.println("Hit <enter> to EXIT.");
                            scanner.nextLine();
                            System.exit(0);
                        }
                        System.out.println("Hit <enter> to continue.");
                        scanner.nextLine();
                        break;
                    case 3:
                        isMakingChoice = false;
                        break;
                    default:
                        System.out.println("Enter number between 1 - 2 to make a choice.");
                        break;
                }
            }
            catch (Exception ex) {
                    System.out.println("Enter number between 1 - 2 to make a choice.");
                    System.out.println("Hit <enter> to try again.");
                    Scanner scanner = new Scanner(System.in);
                    scanner.nextLine();
            }
        }
    }

    public int getDamage() {
        return this.damage;
    }
}
