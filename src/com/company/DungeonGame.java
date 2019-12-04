package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DungeonGame {
    private Hero hero;
    private Maze maze;

    public DungeonGame() {
        this.hero = new Hero("Player", 100, 1000, 100);
        this.maze = new Maze(hero);
    }

    public void showMainMenu() throws InterruptedException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("---- Welcome to the A-Mazeing Dungeon! ----");
        System.out.println("Start Game: Enter '1'");
        System.out.println("Exit Game: Enter '2'");
        String userInitialChoice = "";
        while (invalidInput(userInitialChoice)) {
            System.out.print("Enter choice: ");
            userInitialChoice = scanner1.next();
            switch (userInitialChoice) {
                case "1":
                    getHeroName();
                    start();
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("To choose, enter either '1' or '2'");
            }
        }
    }

    public boolean isHeroDead() {
        return this.hero.getHealth() <= 0;
    }

    public Hero getHero() {
        return hero;
    }

    private void start() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        while (!isHeroDead()) {
            this.maze.print(this.hero);
            this.hero.displayInfo();

            this.maze.displayCurrentRoom(this.hero);
            if (isHeroDead()) {
                break;
            }
            menu();
            boolean loop = true;
            while (loop) {
                System.out.print("Where do you want to go: ");
                String choice = scan.nextLine();
                switch (choice) {
                    case "a":
                        if (moveHeroWest()) {
                            loop = false;
                        }
                        break;
                    case "w":
                        if (moveHeroNorth()) {
                            loop = false;
                        }
                        break;
                    case "d":
                        if (moveHeroEast()) {
                            loop = false;
                        }
                        break;
                    case "s":
                        if (moveHeroSouth()) {
                            loop = false;
                        }
                        ;
                        break;

                    case "b":
                        hero.openBackpack();
                        loop = false;
                        break;

                    default:
                        System.out.println("Not a valid input!");
                        loop = true;
                        break;
                }
            }
        }
        System.out.println("You died, game over!");
        /*
        if (isHeroDead()){
            System.out.println("YOU DIED, game over!");
        } else {
            System.out.println("\033[33;1;1mCongratulations Hero, you found the exit!\033[0m");
        }*/
    }
    private void menu() {
        System.out.println("---- Actions ----");
        System.out.println("Enter a to go West");
        System.out.println("Enter w to go North");
        System.out.println("Enter d to go East");
        System.out.println("Enter s to go South");
        System.out.println("Enter b to open your backpack");

    }

    private boolean moveHeroWest() {
        if (this.maze.isARoom(this.hero.westOfHero()) && this.hero.getCol() > 0) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveWest();
            return true;
        } else {
            System.out.println("There is a wall in the way.");
            return false;
        }
    }

    private boolean moveHeroEast() {
        if (this.maze.isARoom(this.hero.eastOfHero()) && this.hero.getCol() < this.maze.getMaze()[0].length - 1) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveEast();
            return true;
        } else {
            System.out.println("There is a wall in the way.");
            return false;
        }
    }

    private boolean moveHeroNorth() {
        if (this.maze.isARoom(this.hero.northOfHero()) && this.hero.getRow() > 0) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveNorth();
            return true;
        } else {
            System.out.println("There is a wall in the way.");
            return false;
        }
    }

    private boolean moveHeroSouth() {
        if (this.maze.isARoom(this.hero.southOfHero()) && this.hero.getRow() < this.maze.getMaze().length - 1) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveSouth();
            return true;
        } else {
            System.out.println("There is a wall in the way.");
            return false;
        }
    }

    public void getHeroName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Greetings, Hero! What is your name? ----");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        this.hero.setName(name);
    }

    private boolean invalidInput(String choice) {
        return !choice.equals("1") && !choice.equals("2");
    }

/* NOT NEEDED ANYMORE
    private boolean isHeroInLastRoom() {
        return (hero.getRow() == 0 && hero.getCol() == 1);
    }
*/

}
