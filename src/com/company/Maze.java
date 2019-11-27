package com.company;


import java.util.ArrayList;

public class Maze {
    private String[][] map = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
    };
    private String[][] maze = {
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", " ", " ", "#"},
            {"#", " ", "#", "#", " ", " ", " ", " ", "#", " ", "#", "#", "#", " ", "#"},
            {"#", " ", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", " ", " ", " ", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "H", " ", " ", " ", "#", "#", "#", "#", " ", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
    };
    private ArrayList<Room> rooms = new ArrayList<>();

    private final String WALL = "#";
    private final String HERO = "H";
    private final String ROOM = " ";

    public Maze(Hero hero){
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        printMap();
    }

    public void createRoom(){
        for (int row = 0; row < this.maze.length; row++){
            for (int col = 0; col < this.maze[0].length; col++){
                if (isARoom(row, col)){
                    this.rooms.add(new Room(row, col));
                }
            }
        }
    }

    private boolean isARoom(int pos_y, int pos_x){
        return this.maze[pos_y][pos_x].equals(ROOM);
    }
/*
    public void teleportHero(Hero hero, int posY, int posX){
        if (isARoom(posY, posX)){
            removeHero(hero);
            changeHeroPositionTo(hero, posY, posX);
            addHeroOnMapAndMaze(hero);
            addHeroSurroundingToMap(hero);
        }
    }
*/
    private void removeHero(Hero hero){
        this.map[hero.getRow()][hero.getCol()] = ROOM;
        this.maze[hero.getRow()][hero.getCol()] = ROOM;
    }
/*
    private void changeHeroPositionTo(Hero hero, int posY, int posX){
        hero.move(posY, posX);
    }
*/
    public void moveHeroWest(Hero hero){
        if (isARoom(hero.getRow(), hero.getCol() - 1) && hero.getCol() > 0) {
            hero.moveWest();
        }
    }

    public void moveHeroEast(Hero hero){
        if (isARoom(hero.getRow(), hero.getCol() + 1) && hero.getCol() < this.maze[0].length-1){
            hero.moveEast();
        }
    }

    public void moveHeroNorth(Hero hero){
        if (isARoom(hero.getRow() - 1, hero.getCol()) && hero.getRow() > 0){
            hero.moveNorth();
        }
    }

    public void moveHeroSouth(Hero hero){
        if (isARoom(hero.getRow() + 1, hero.getCol()) && hero.getRow() < this.maze.length-1) {
            hero.moveSouth();
        }
    }


    private void addHeroOnMapAndMaze(Hero hero){
        this.map[hero.getRow()][hero.getCol()] = HERO;
        this.maze[hero.getRow()][hero.getCol()] = HERO;
    }

    public void printMap(){
        for (String[] row : this.map){
            for (String elem : row){
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }

    public void printMaze(){
        for (String[] row : this.maze){
            for (String elem : row){
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }

    private void addHeroSurroundingToMap(Hero hero){
        int heroPosY = hero.getRow();
        int heroPosX = hero.getCol();

        // left of hero
        if (heroPosX > 0) {
            this.map[heroPosY][heroPosX - 1] = this.maze[heroPosY][heroPosX - 1];
        }
        // right
        if (heroPosX + 1 < this.map[0].length){
            this.map[heroPosY][heroPosX + 1] = this.maze[heroPosY][heroPosX + 1];
        }
        // top
        if (heroPosY > 0) {
            this.map[heroPosY - 1][heroPosX] = this.maze[heroPosY - 1][heroPosX];
        }
        // bottom
        if (heroPosY + 1 < this.map.length){
            this.map[heroPosY + 1][heroPosX] = this.maze[heroPosY + 1][heroPosX];
        }
    }

}
