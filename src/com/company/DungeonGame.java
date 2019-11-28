package com.company;

import java.util.Scanner;

public class DungeonGame {
    private Hero hero;
    private Maze maze;

    public DungeonGame(){
        this.hero = new Hero("Barry", 100, 10, 100);
        this.maze = new Maze(hero);
    }

    public boolean isHeroInLastRoom(){
        return (hero.getRow() == 0 && hero.getCol() == 1);
    }

    public void start(){

        while (!isHeroInLastRoom()){
            this.maze.print(this.hero);
            this.hero.displayInfo();

            this.maze.displayCurrentRoom(this.hero);

            String choice = menu();

            if (choice.equals("w")){moveHeroWest();}
            else if (choice.equals("n")){moveHeroNorth();}
            else if (choice.equals("e")){moveHeroEast();}
            else if (choice.equals("s")){moveHeroSouth();}
        }
        System.out.println("You found the exit!");
    }


    public String menu(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter w to go West");
        System.out.println("Enter n to go North");
        System.out.println("Enter e to go East");
        System.out.println("Enter s to go South");

        System.out.print("Where do you want to go: ");
        return scan.nextLine();
    }

    public void moveHeroWest(){
        if (this.maze.isARoom(this.hero.westOfHero()) && this.hero.getCol() > 0) {
            this.maze.removeHero(this.hero);
            this.hero.moveWest();
        }
    }

    public void moveHeroEast(){
        if (this.maze.isARoom(this.hero.eastOfHero()) && this.hero.getCol() < this.maze.getMaze()[0].length-1){
            this.maze.removeHero(this.hero);
            this.hero.moveEast();
        }
    }

    public void moveHeroNorth(){
        if (this.maze.isARoom(this.hero.northOfHero()) && this.hero.getRow() > 0){
            this.maze.removeHero(this.hero);
            this.hero.moveNorth();
        }
    }

    public void moveHeroSouth(){
        if (this.maze.isARoom(this.hero.southOfHero()) && this.hero.getRow() < this.maze.getMaze().length-1) {
            this.maze.removeHero(this.hero);
            this.hero.moveSouth();
        }
    }

}
