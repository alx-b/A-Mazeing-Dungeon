package com.company;

import java.util.Random;
import java.util.Scanner;

public class Hero extends Creature {
    private int row;
    private int col;
    private Backpack backpack = new Backpack("Backpack");
    private BagOfGold bagOfGold = new BagOfGold("Bag of gold", 100);
    //DungeonGame dungeonGame = new DungeonGame();

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


    public void heroFight(Monster monster) throws InterruptedException {

        boolean control = true;

        while (control) {

            int fight = attack();
            Thread.sleep(1000);

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

    private void levelUp() {
        super.setHeroMaxHealth(super.getMaxHealth() + 10);
        setHeroDamage(getDamage() + 10);
        System.out.println("You won, game continues...add function");
        System.out.println("Health is: " + getHealth());
        System.out.println("Max health is: " + getMaxHealth());
        System.out.println("Damage is: " + getDamage());
        //dungeonGame.start(); need to be public.
    }

    /* moveHero to be developed and adjusted to maze.*/
    /*
    public void moveHero() {
        String wall = "[W]";

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter direction: E W S N");
        String direction = scanner.nextLine();

        if (direction.equals("E") && (y < board.length - 1) && (!board[x][y + 1].equals(wall))) {
            board[x][y] = "[ ]";
            board[x][++y] = hero;
        } else if (direction.equals("W") && (y >= 2) && (!board[x][y - 1].equals(wall))) {
            board[x][y] = "[ ]";
            board[x][--y] = hero;
        } else if (direction.equals("S") && x < board.length - 1 && (!board[x + 1][y].equals(wall))) {
            board[x][y] = "[ ]";
            board[++x][y] = hero;
        } else if (direction.equals("N") && (x >= 2) && (!board[x - 1][y].equals(wall))) {
            board[x][y] = "[ ]";
            board[--x][y] = hero;
        }
    }
    */

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
        if (getHealth() < 100) {
            setHeroHealth(getHealth() + potion.getHealthPoints());
            if (getHealth() > getMaxHealth()) {
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
