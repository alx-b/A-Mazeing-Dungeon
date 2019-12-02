package com.company;

import java.util.Random;
import java.util.Scanner;


public class Hero extends Creature {
    private int row;
    private int col;
    private Backpack backpack = new Backpack("Backpack");
    private BagOfGold bagOfGold = new BagOfGold("Bag of gold", 100);

    public Hero(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
        this.row = 12;
        this.col = 1;
    }

    public int getTotalGoldInBag() {
        return this.bagOfGold.getAmountOfGold();
    }

    public void addItemToBackpack(Item item) {
        backpack.addItem(item);
    }

    public void addGoldToBagOfGold(int gold) {
        this.bagOfGold.addAmountOfGold(gold);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void heroFight(Monster monster){

        boolean control = true;

        while (control) {

            int fight = attack();

            if (fight < 50 && super.getHealth() > 0 && monster.getHealth() > 0) {
                int changeHeroHealth = getHealth();
                System.out.println("The enemy hit you!");
                System.out.println("Health: " + super.setHeroHealth(changeHeroHealth - monster.getDamage()) + "/" + super.maxHealth);
            } else if (fight >= 50 && super.getHealth() > 0 && monster.getHealth() > 0) {
                int changeMonsterHealth = monster.getHealth();
                System.out.println("You hit the enemy!");
                System.out.println("Enemy health: " + monster.setHealth(changeMonsterHealth - getDamage()) + "/" + monster.maxHealth);
            } else if (super.getHealth() <= 0) {
                restart();
            } else if (monster.getHealth() <= 0) {
                levelUp();
                control = false;
            }

        }
    }

    private void restart() {
        String yesNo;
        System.out.println("You are dead");
        System.out.println("Restart game, Yes or No?");
        Scanner scanner = new Scanner(System.in);
        yesNo = scanner.nextLine();
        if (yesNo.equals("Yes")) {
            System.out.println("Returning to beginning of map");
            //dungeonGame.showMainMenu();
        } else if (yesNo.equals("No")) {
            System.exit(0);
        }

    }

    private int attack() {
        Random r = new Random();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high - low) + low;
        return result;
    }

    public void openBackpack() {
        boolean backpackIsOpen = true;
        while (backpackIsOpen) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inventory: ");
                backpack.showItemsInBackpack();
                System.out.println("'1' To heal yourself");
                System.out.println("'2' To equip a weapon");
                System.out.println("'3' To close backpack");
                int userInput = Integer.parseInt(scanner.nextLine());
                switch (userInput) {

                    case 1:
                        if (getHealth() < getMaxHealth()) {
                            consumeHealthPotion();
                            System.out.println("Your health is now " + getHealth());
                        } else if (getHealth() >= getMaxHealth()) {
                            setHeroHealth(getMaxHealth());
                            System.out.println("Your health is full.");
                        }

                        break;
                    case 2:
                        break;

                    case 3:
                        backpackIsOpen = false;
                        break;

                    default:
                        System.out.println("Incorrect button. To choose between options use '1', '2' or '3'");
                }
            } catch (Exception ex) {
                System.out.println("Letters are not allowed! You have to enter a number.");
                System.out.println("Hit <enter> to try again.");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }

        }
    }

    private void levelUp() {
        super.setHeroMaxHealth(super.getMaxHealth() + 10);
        setHeroDamage(getDamage() + 10);
        System.out.println("You won, game continues...add function");
        System.out.println("Health is: " + getHealth());
        System.out.println("Max health is: " + getMaxHealth());
        System.out.println("Damage is: " + getDamage());
        //dungeonGame.start(); need to be public.
    }
    public HealthPotion returnHealthPotion() {
        for (Item item : backpack.getItems()) {
            if (item instanceof HealthPotion) {
                return (HealthPotion)item;
            }
        }
        return null;
    }
    public void consumeHealthPotion() {
        if (returnHealthPotion() != null) {
            restoreHealth(returnHealthPotion());
            backpack.removeItemFromBackpack(returnHealthPotion());
        } else {
            System.out.println("You do not have any health potions.");
        }
    }

    public int[] westOfHero() {
        return new int[]{this.row, this.col - 1};
    }

    public int[] eastOfHero() {
        return new int[]{this.row, this.col + 1};
    }

    public int[] northOfHero() {
        return new int[]{this.row - 1, this.col};
    }

    public int[] southOfHero() {
        return new int[]{this.row + 1, this.col};
    }

    public void moveWest() {
        this.col -= 1;
    }

    public void moveEast() {
        this.col += 1;
    }

    public void moveNorth() {
        this.row -= 1;
    }

    public void moveSouth() {
        this.row += 1;
    }

    public void restoreHealth(HealthPotion potion) { //Added method restore health
        if (getHealth() < getMaxHealth()) {
            setHeroHealth(getHealth() + potion.getHealthPoints());
            if (getHealth() >= getMaxHealth()) {
                setHeroHealth(getMaxHealth());
            }
        }
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public BagOfGold getBagOfGold() {
        return bagOfGold;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    public void displayInfo() {
        System.out.println("---- Hero ----");
        super.displayInfo();
        System.out.println("Gold: " + this.bagOfGold);
        System.out.println("---- Backpack ----");
        this.backpack.showDescription();
    }
}
