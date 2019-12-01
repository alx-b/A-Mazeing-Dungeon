package com.company;

import java.util.Scanner;

public class DungeonGame {
    private Hero hero;
    private Maze maze;

    public DungeonGame() {
        this.hero = new Hero("Player", 100, 10, 100);
        this.maze = new Maze(hero);
    }

    private boolean isHeroInLastRoom() {
        return (hero.getRow() == 0 && hero.getCol() == 1);
    }

    public void start() {

        while (!isHeroInLastRoom()) {
            this.maze.print(this.hero);
            this.hero.displayInfo();

            this.maze.displayCurrentRoom(this.hero);

            String choice = menu();

            switch (choice) {
                case "a":
                    moveHeroWest();
                    break;
                case "w":
                    moveHeroNorth();
                    break;
                case "d":
                    moveHeroEast();
                    break;
                case "s":
                    moveHeroSouth();
                    break;
                default:
                    System.out.println("Not a valid input!");
                    break;
            }
        }
        System.out.println("You found the exit!");
    }

    private String menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("---- Actions ----");
        System.out.println("Enter a to go West");
        System.out.println("Enter w to go North");
        System.out.println("Enter d to go East");
        System.out.println("Enter s to go South");

        System.out.print("Where do you want to go: ");
        return scan.nextLine();
    }

    private void moveHeroWest() {
        if (this.maze.isARoom(this.hero.westOfHero()) && this.hero.getCol() > 0) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveWest();
        }
    }

    private void moveHeroEast() {
        if (this.maze.isARoom(this.hero.eastOfHero()) && this.hero.getCol() < this.maze.getMaze()[0].length - 1) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveEast();
        }
    }

    private void moveHeroNorth() {
        if (this.maze.isARoom(this.hero.northOfHero()) && this.hero.getRow() > 0) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveNorth();
        }
    }

    private void moveHeroSouth() {
        if (this.maze.isARoom(this.hero.southOfHero()) && this.hero.getRow() < this.maze.getMaze().length - 1) {
            this.maze.removeHeroFromMapAndMaze(this.hero);
            this.hero.moveSouth();
        }
    }


    public void getHeroName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Greetings, Hero! What is your name? ----");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        this.hero.setName(name);
    }

    private boolean invalidInput(String choice){
        return !choice.equals("1") && !choice.equals("2");
    }

    public void showMainMenu() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("---- Welcome to the A-Mazeing Dungeon! ----");
        System.out.println("Start Game: Enter '1'");
        System.out.println("Exit Game: Enter '2'");
        String userInitialChoice = "";
        while(invalidInput(userInitialChoice)) {
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

}
