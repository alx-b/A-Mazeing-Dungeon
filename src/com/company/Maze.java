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
            {"#", "#", "D", "#", " ", " ", " ", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "H", "T", "S", " ", "#", "#", "#", "#", " ", " ", " ", " ", "S", "#"},
            {"#", "#", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
    };

    private enum Symbol{
        WALL("#"),
        HERO("H"),
        ROOM(" "),
        STORE("S"),
        DRAGON("D"),
        TOOTH("T");

        public String v;

        Symbol(String value){
            this.v = value;
        }
    }

    private ArrayList<Room> rooms = new ArrayList<>();
    private Room currentRoom;

    public Maze(Hero hero) {
        initHeroOnMap(hero);
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

    public void printMap() {
        // Print map with some colour/styling added.
        //==================================
        System.out.println("------ Map ------");
        for (String[] row : this.map) {
            for (String elem : row) {
                if (elem.equals(Symbol.WALL.v)) {
                    elem = " ";
                    System.out.printf("%s %s %s", Color.BG_GREY.v, elem, Color.DEFAULT.v);
                } else if (elem.equals(Symbol.HERO.v)) {
                    System.out.printf("%s %s %s", Color.WHITE_BG_BLUE.v, elem, Color.DEFAULT.v);
                } else if (elem.equals(Symbol.DRAGON.v)) {
                    System.out.printf("%s %s %s", Color.WHITE_BG_GREEN.v, elem, Color.DEFAULT.v);
                } else if (elem.equals(Symbol.STORE.v)) {
                    System.out.printf("%s %s %s", Color.WHITE_BG_YELLOW.v, elem, Color.DEFAULT.v);
                } else if (elem.equals(Symbol.TOOTH.v)) {
                    System.out.printf("%s %s %s", Color.WHITE_BG_MAGENTA.v, elem, Color.DEFAULT.v);
                } else {
                    System.out.printf(" %s ", elem);
                }
            }
            System.out.println();
        }
    }

    public boolean isARoom(int[] position) {
        int row = position[0];
        int col = position[1];
        return !this.maze[row][col].equals(Symbol.WALL.v);
    }

    public void removeHeroFromMapAndMaze(Hero hero) {
        // Reset the map tile the Hero was on to its old icon.
        //=========================================
        if (this.currentRoom.getName().equals("Store")) {
            this.map[hero.getRow()][hero.getCol()] = Symbol.STORE.v;
            this.maze[hero.getRow()][hero.getCol()] = Symbol.STORE.v;
        } else if (this.currentRoom.getName().equals("Dragon")) {
            this.map[hero.getRow()][hero.getCol()] = Symbol.DRAGON.v;
            this.maze[hero.getRow()][hero.getCol()] = Symbol.DRAGON.v;
        } else {
            this.map[hero.getRow()][hero.getCol()] = Symbol.ROOM.v;
            this.maze[hero.getRow()][hero.getCol()] = Symbol.ROOM.v;
        }
    }

    private void createRoom() {
        for (int row = 0; row < this.maze.length; row++) {
            for (int col = 0; col < this.maze[0].length; col++) {
                if (isARoom(new int[]{row, col})) {
                    if (this.maze[row][col].equals(Symbol.STORE.v)) {
                        this.rooms.add(new SpecialRoom("Store", row, col));
                    } else if (this.maze[row][col].equals(Symbol.DRAGON.v)){
                        this.rooms.add(new SpecialRoom("Dragon", row, col));
                    } else if (this.maze[row][col].equals(Symbol.TOOTH.v)){
                        this.rooms.add(new SpecialRoom("Dragon Tooth", row, col));
                    } else {
                        this.rooms.add(new Room("Room", row, col));
                    }
                }
            }
        }
    }

    private void addHeroOnMapAndMaze(Hero hero) {
        this.map[hero.getRow()][hero.getCol()] = Symbol.HERO.v;
        this.maze[hero.getRow()][hero.getCol()] = Symbol.HERO.v;
    }

    private void initHeroOnMap(Hero hero){
        for (int row = 0; row < this.maze.length; row++){
            for (int col = 0; col < this.maze[0].length; col++){
                if (this.maze[row][col].equals(Symbol.HERO.v)){
                    hero.setRow(row);
                    hero.setCol(col);
                }
            }
        }
    }

    private void addHeroSurroundingToMap(Hero hero) {
        // Show the map as the Hero explores it.1
        //=========================================
        int heroRow = hero.getRow();
        int heroCol = hero.getCol();
        // left of hero
        if (heroCol > 0) {
            this.map[heroRow][heroCol - 1] = this.maze[heroRow][heroCol - 1];
        }
        // right
        if (heroCol + 1 < this.map[0].length) {
            this.map[heroRow][heroCol + 1] = this.maze[heroRow][heroCol + 1];
        }
        // top
        if (heroRow > 0) {
            this.map[heroRow - 1][heroCol] = this.maze[heroRow - 1][heroCol];
        }
        // bottom
        if (heroRow + 1 < this.map.length) {
            this.map[heroRow + 1][heroCol] = this.maze[heroRow + 1][heroCol];
        }
    }
}
