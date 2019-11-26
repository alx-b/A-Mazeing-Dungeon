package com.company;

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

    String hero = "H";
    String wall = "#";
    String room = " ";
    int hero_pos_y = 12;
    int hero_pos_x = 1;

    public Maze() {
        print();

    }

    public void print(){
        printHeroOnMap();
        printHeroSurrounding();
        printMap();


    }
    public void teleportHero(int pos_y, int pos_x) {
        if (!maze[pos_y][pos_x].equals(wall)) {
            map[hero_pos_y][hero_pos_x] = room;
            maze[hero_pos_y][hero_pos_x] = room; // Hjältens pos på kartan blir pos i labyrint,
            hero_pos_y = pos_y;
            hero_pos_x = pos_x;
        }
    }
    private void printMap() {
        for (String[] row : map) {
            for (String elem : row) {
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }

    public void printMaze() {
        for (String[] row : maze) {
            for (String elem : row) {
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }
    private void printHeroOnMap() {
        map[hero_pos_y][hero_pos_x] = hero; //Växlar mellan map och maze.
        maze[hero_pos_y][hero_pos_x] = hero;
    }
    private void printHeroSurrounding() {
        // left of hero
        if (hero_pos_x > 0) {
            map[hero_pos_y][hero_pos_x - 1] = maze[hero_pos_y][hero_pos_x - 1];
        }
        // right
        if (hero_pos_x + 1 < map.length) {
            map[hero_pos_y][hero_pos_x + 1] = maze[hero_pos_y][hero_pos_x + 1];
        }
        // top
        if (hero_pos_y > 0) {
            map[hero_pos_y - 1][hero_pos_x] = maze[hero_pos_y - 1][hero_pos_x];
        }
        // bottom
        if (hero_pos_y + 1 < map.length) {
            map[hero_pos_y + 1][hero_pos_x] = maze[hero_pos_y + 1][hero_pos_x];
        }
    }

}
