package com.company;

import java.util.Scanner;

public class DungeonGame {
    private Hero hero;
    private Maze maze;

    public DungeonGame(){
        this.hero = new Hero("Barry", 100, 10, 100);
        this.maze = new Maze(hero);
    }

    public void start(){
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            this.maze.print(this.hero);

            System.out.println("Enter w to go West");
            System.out.println("Enter n to go North");
            System.out.println("Enter e to go East");
            System.out.println("Enter s to go South");

            System.out.print("Where do you want to go: ");
            String choice = scan.nextLine();

            if (choice.equals("w")){moveHeroWest();}
            else if (choice.equals("n")){moveHeroNorth();}
            else if (choice.equals("e")){moveHeroEast();}
            else if (choice.equals("s")){moveHeroSouth();}
        }
    }

    public void moveHeroWest(){
        if (this.maze.isARoom(this.hero.westOfHero()) && this.hero.getCol() > 0) {
            this.hero.moveWest();
        }
    }

    public void moveHeroEast(){
        if (this.maze.isARoom(this.hero.eastOfHero()) && this.hero.getCol() < this.maze.getMaze()[0].length-1){
            this.hero.moveEast();
        }
    }

    public void moveHeroNorth(){
        if (this.maze.isARoom(this.hero.northOfHero()) && this.hero.getRow() > 0){
            this.hero.moveNorth();
        }
    }

    public void moveHeroSouth(){
        if (this.maze.isARoom(this.hero.southOfHero()) && this.hero.getRow() < this.maze.getMaze().length-1) {
            this.hero.moveSouth();
        }
    }

}
