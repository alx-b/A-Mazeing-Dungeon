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

    //int hero_pos_y = 12;
    //int hero_pos_x = 1;

    public Maze(){
        //addHeroOnMapAndMaze();
        //addHeroSurroundingToMap();
        //printMap();
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

    private void removeHero(Hero hero){
        this.map[hero.getPosY()][hero.getPosX()] = ROOM;
        this.maze[hero.getPosY()][hero.getPosX()] = ROOM;
    }

    private void changeHeroPositionTo(Hero hero, int posY, int posX){
        hero.move(posY, posX);
    }

    private void addHeroOnMapAndMaze(Hero hero){
        this.map[hero.getPosY()][hero.getPosX()] = HERO;
        this.maze[hero.getPosY()][hero.getPosX()] = HERO;
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
        int heroPosY = hero.getPosY();
        int heroPosX = hero.getPosX();

        // left of hero
        if (heroPosX > 0) {
            this.map[heroPosY][heroPosX - 1] = this.maze[heroPosY][heroPosX - 1];
        }
        // right
        if (heroPosX + 1 < this.map.length){
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
*/
}
