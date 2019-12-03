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
            {"\033[32;1m█1\033[0m", " ", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m", "\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," "," ","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m"," "," "," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," "," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," "," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," "," "," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","H"," ","\033[33;1;1mS\033[0m"," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," "," ","\033[33;1;1mS\033[0m","\033[32;1m#\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," "," "," ","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"," ","\033[29;m█\033[0m"},
        {"\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m","\033[29;m█\033[0m"}
        };
private ArrayList<Room> rooms=new ArrayList<>();
private final String WALL="#";
private final String HERO="\033[34;1;1mH\033[0m"; // Added blue color to Hero "H"
private final String ROOM=" ";
private final String STORE="S";

private Room currentRoom;

public Maze(Hero hero){
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        createRoom();
        }

public String[][]getMaze(){
        return maze;
        }

public void print(Hero hero){
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        printMap();
        //::wa
        // printMaze(); // Temporary there, delete later
        //System.out.println(hero.getRow());
        //System.out.println(hero.getCol());
        }

public void displayCurrentRoom(Hero hero){
        System.out.println("---- Event ----");
        for(Room room:this.rooms){
        if(room.getRow()==hero.getRow()&&room.getCol()==hero.getCol()){
        room.displayRoom(hero);
        this.currentRoom=room;
        }
        }
        }

private void createRoom(){
        for(int row=0;row< this.maze.length;row++){
        for(int col=0;col< this.maze[0].length;col++){
        if(isARoom(new int[]{row,col})){
        if(row==12&&col==13||row==12&&col==3){
        this.rooms.add(new Room("Store",row,col));
        }else{
        this.rooms.add(new Room("Room",row,col));
        }
        }
        }
        }
        }

public boolean isARoom(int[]position){
        int row=position[0];
        int col=position[1];
        return!this.maze[row][col].equals(WALL);
        }

public void removeHeroFromMapAndMaze(Hero hero){
        if(this.currentRoom.getName().equals("Store")){
        this.map[hero.getRow()][hero.getCol()]=STORE;
        this.maze[hero.getRow()][hero.getCol()]=STORE;
        System.out.println("HELLO");
        }else{
        this.map[hero.getRow()][hero.getCol()]=ROOM;
        this.maze[hero.getRow()][hero.getCol()]=ROOM;
        System.out.println("BYE");
        }
        }

    /*
        private void changeHeroPositionTo(Hero hero, int posY, int posX){
            hero.move(posY, posX);
        }
    */
private void addHeroOnMapAndMaze(Hero hero){
        this.map[hero.getRow()][hero.getCol()]=HERO;
        this.maze[hero.getRow()][hero.getCol()]=HERO;
        }

public void printMap(){
        System.out.println("------ Map ------");
        for(String[]row:this.map){
        for(String elem:row){
        System.out.printf("[%s]",elem);
        }
        System.out.println();
        }
        }

public void printMaze(){
        System.out.println("------ Maze ------");
        for(String[]row:this.maze){
        for(String elem:row){
        System.out.printf("[%s]",elem);
        }
        System.out.println();
        }
        }

private void addHeroSurroundingToMap(Hero hero){
        int heroPosY=hero.getRow();
        int heroPosX=hero.getCol();

        // left of hero
        if(heroPosX>0){
        this.map[heroPosY][heroPosX-1]=this.maze[heroPosY][heroPosX-1];
        }
        // right
        if(heroPosX+1< this.map[0].length){
        this.map[heroPosY][heroPosX+1]=this.maze[heroPosY][heroPosX+1];
        }
        // top
        if(heroPosY>0){
        this.map[heroPosY-1][heroPosX]=this.maze[heroPosY-1][heroPosX];
        }
        // bottom
        if(heroPosY+1< this.map.length){
        this.map[heroPosY+1][heroPosX]=this.maze[heroPosY+1][heroPosX];
        }
        }
        }
