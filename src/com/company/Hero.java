package com.company;

import java.util.Random;
import java.util.Scanner;

public class Hero extends Creature {
    private int row;
    private int col;
    private Backpack backpack = new Backpack("Backpack");


    public Hero(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
        this.row = 12;
        this.col = 1;
    }

    public void addItemToBackpack(Item item) {
        backpack.addItem(item);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void heroFight(Creature creature) { //in parameter monster, bara test

        boolean control = true;

        while (control) {

            int fight = attack();

            if (fight <= 50 && getHealth() > 0 && creature.getHealth() > 0) { //getHealthSpider
                getHealth() -= spider.getDamage();
                System.out.println("The enemy hit you!");
                System.out.println("Health: " + getHealth());
            } else if (fight >= 50 && getHealth() > 0 && creature.getHealth() > 0) {
                spider.getHealth() -= getDamage();
                System.out.println("You hit the enemy!");
                System.out.println("Health: " + getHealth());
            } else if (getHealth() == 0) {
                restart();
            } else {
                getMaxHealth() += 10; //Setter?
                setHeroDamage(getDamage() += 10);
                System.out.println("You won, game continues...add function");
                System.out.println("Max health is now: " + getMaxHealth());
                System.out.println("Damage is now: " + getDamage());
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
            System.out.println("Return to beginning of map, add function."); //Behöver åtgärdas.
            System.exit(0);
        } else if (yesNo.equals("No")){
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

    public void restoreHealth(HealthPotion potion){ //Added method restore health
        if(getHealth() < 100){
            setHeroHealth(potion.getHealthPoints());
            if(getHealth() > getMaxHealth()){
                setHeroHealth(getMaxHealth());
            }
        }
    }

    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public int getDamage() {
        return getDamage();
    }

    public void displayInfo(){
        System.out.println("---- Hero ----");
        super.displayInfo();
        System.out.println("---- Backpack ----");
        this.backpack.showDescription();
    }
}
