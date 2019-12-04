package com.company;


import java.util.ArrayList;

public class Maze {
    private String[][] map = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", "D", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
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
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "D", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "T", " ", "#"},
            {"#", " ", "#", "#", " ", " ", " ", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", " ", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", " ", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", " ", " ", " ", " ", " ", " ", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", " ", "#", "#", "#", " ", "#", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", " ", " ", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "H", " ", " ", " ", "#", "#", "#", "#", " ", " ", " ", " ", "S", "#"},
            {"#", "#", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
    };
    private final String WALL = "#";
    private final String HERO = "H";
    private final String ROOM = " ";
    private final String STORE = "S";
    private final String DRAGON = "D";
    private final String TOOTH = "T";
    private ArrayList<Room> rooms = new ArrayList<>();
    private Room currentRoom;

    public Maze(Hero hero) {
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        createRoom();
    }

    public String[][] getMaze() {
        return maze;
    }

    public void print(Hero hero) {
        // Print Map, Hero and their surrounding
        //================================
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        printMap();
    }

    public void displayCurrentRoom(Hero hero) throws InterruptedException {
        // Display whatever happens in the current Room.
        //===================================
        System.out.println("---- Event ----");
        for (Room room : this.rooms) {
            if (room.getRow() == hero.getRow() && room.getCol() == hero.getCol()) {
                room.displayRoom(hero);
                this.currentRoom = room;
            }
        }
    }

    private void createRoom() {
        for (int row = 0; row < this.maze.length; row++) {
            for (int col = 0; col < this.maze[0].length; col++) {
                if (isARoom(new int[]{row, col})) {
                    if (this.maze[row][col].equals(STORE)) {
                        this.rooms.add(new Room("Store", row, col));
                    } else if (this.maze[row][col].equals(DRAGON)){
                        this.rooms.add(new Room("Dragon", row, col));
                    } else if (this.maze[row][col].equals(TOOTH)){
                        this.rooms.add(new Room("Dragon Tooth", row, col));
                    } else {
                        this.rooms.add(new Room("Room", row, col));
                    }
                }
            }
        }
    }

    public boolean isARoom(int[] position) {
        int row = position[0];
        int col = position[1];
        return !this.maze[row][col].equals(WALL);
    }

    public void removeHeroFromMapAndMaze(Hero hero) {
        // Reset the map tile the Hero was on to its old icon.
        //=========================================
        if (this.currentRoom.getName().equals("Store")) {
            this.map[hero.getRow()][hero.getCol()] = STORE;
            this.maze[hero.getRow()][hero.getCol()] = STORE;
        } else if (this.currentRoom.getName().equals("Dragon")) {
            this.map[hero.getRow()][hero.getCol()] = DRAGON;
            this.maze[hero.getRow()][hero.getCol()] = DRAGON;
        } else {
            this.map[hero.getRow()][hero.getCol()] = ROOM;
            this.maze[hero.getRow()][hero.getCol()] = ROOM;
        }
    }

    private void addHeroOnMapAndMaze(Hero hero) {
        this.map[hero.getRow()][hero.getCol()] = HERO;
        this.maze[hero.getRow()][hero.getCol()] = HERO;
    }

    public void printMap() {
        // Print map with some colour/styling added.
        //==================================
        System.out.println("------ Map ------");
        for (String[] row : this.map) {
            for (String elem : row) {
                if (elem.equals("#")) {
                    elem = " ";
                    System.out.printf("\033[1;47m %s \033[0m", elem);
                } else if (elem.equals("H")) {
                    System.out.printf("\033[30;1;44m %s \033[0m", elem);
                } else if (elem.equals("D")) {
                    System.out.printf("\033[30;1;42m %s \033[0m", elem);
                } else if (elem.equals("S")) {
                    System.out.printf("\033[30;1;43m %s \033[0m", elem);
                } else if (elem.equals("T")) {
                    System.out.printf("\033[30;1;42m %s \033[0m", elem);
                } else {
                    System.out.printf(" %s ", elem);
                }
            }
            System.out.println();
        }
    }

    private void addHeroSurroundingToMap(Hero hero) {
        // Show the map as the Hero explores it.
        //=========================================
        int heroPosY = hero.getRow();
        int heroPosX = hero.getCol();
        // left of hero
        if (heroPosX > 0) {
            this.map[heroPosY][heroPosX - 1] = this.maze[heroPosY][heroPosX - 1];
        }
        // right
        if (heroPosX + 1 < this.map[0].length) {
            this.map[heroPosY][heroPosX + 1] = this.maze[heroPosY][heroPosX + 1];
        }
        // top
        if (heroPosY > 0) {
            this.map[heroPosY - 1][heroPosX] = this.maze[heroPosY - 1][heroPosX];
        }
        // bottom
        if (heroPosY + 1 < this.map.length) {
            this.map[heroPosY + 1][heroPosX] = this.maze[heroPosY + 1][heroPosX];
        }
    }
}
