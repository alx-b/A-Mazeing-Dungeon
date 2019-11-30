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

            if (choice.equals("w")) {
                moveHeroWest();
            } else if (choice.equals("n")) {
                moveHeroNorth();
            } else if (choice.equals("e")) {
                moveHeroEast();
            } else if (choice.equals("s")) {
                moveHeroSouth();
            }
        }
        System.out.println("You found the exit!");
    }

    private String menu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("---- Actions ----");
        System.out.println("Enter w to go West");
        System.out.println("Enter n to go North");
        System.out.println("Enter e to go East");
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
        System.out.println("Greetings, Hero!\n What is your name?");
        System.out.println("_________________________");
        String name = scanner.nextLine();
        this.hero.setName(name);
    }

    public void showMainMenu() {
        while(true) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Welcome to the A-Mazeing Dungeon!");
                System.out.println("-----------------------------------");
                System.out.println("Start Game: type '1' and hit <enter>");
                System.out.println("Exit Game: type '2' and hit <enter>");

                int userInitialChoice = Integer.parseInt(scanner1.nextLine());

                switch (userInitialChoice) {
                    case 1:
                        getHeroName();
                        start();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                }
                break;
            } catch (Exception ex) {
                System.out.println("To choose, enter either '1' or '2' and hit <enter>");
                System.out.println("___________________________________________________");
            }
        }
    }

}
