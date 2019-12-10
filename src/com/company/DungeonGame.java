package com.company;


import java.io.Serializable;
import java.util.Scanner;

public class DungeonGame implements Serializable {
    private Hero hero;
    private Maze maze;

    public DungeonGame() {
        this.hero = new Hero("Player", 100, 10, 100);
        this.maze = new Maze(hero);
    }

    public void showMainMenu() throws InterruptedException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("---- Welcome to the A-Mazeing Dungeon! ----");
        System.out.println("Start Game: Enter '1'");
        System.out.println("Load game '2'");
        System.out.println("Exit Game: Enter '3'");
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
                    try {
                        loadGame();
                        start();
                    }catch(Exception ex){
                        System.out.println("Saved game not found!");
                    }
                    break;

                case "3":
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

    //public Hero getHero() {return hero;}

    private void start() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        while (!isHeroDead()) {
            this.hero.displayInfo();

            if (!isHeroDead()) {
                this.maze.displayCurrentRoom(this.hero);
            } else {
                break;
            }

            this.maze.print(this.hero);
            menu();
            if (!isHeroDead()) {
                boolean loop = true;
                while (loop) {
                    System.out.print("Choose an action: \n");
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

                        case "y":
                            FileUtility.writeObject(this, "SaveGame.ser");
                            break;

                        case "u":
                            System.out.println("Save game before leaving! Enter 'y' to quit. Enter 'n' to cancel");
                            Scanner scanner = new Scanner(System.in);
                            String quitGame = scanner.nextLine();
                            switch(quitGame){
                                case "y":
                                    System.out.println("Hope to see you soon!");
                                    System.exit(0);
                                    break;
                                case "n":
                                    loop = true;
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Not a valid input!");
                            loop = true;
                            break;
                    }
                }
            }
        }
        System.out.println("\033[0;31mYou died, game over!\033[0m");
    }

    public void loadGame() {
        DungeonGame gameFromFile = (DungeonGame) (FileUtility.readObject("SaveGame.ser"));
        this.hero = gameFromFile.hero;
        this.maze = gameFromFile.maze;
        System.out.println("Game successfully loaded..");
        System.out.println("Hero name: " + hero.getName());
    }

    private void menu() {
        System.out.println("---- Actions ----");
        System.out.println("Enter a to go West");
        System.out.println("Enter w to go North");
        System.out.println("Enter d to go East");
        System.out.println("Enter s to go South");
        System.out.println("Enter b to open your backpack");
        System.out.println("Enter y to save game");
        System.out.println("Enter u to quit game");
        ;

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

}
