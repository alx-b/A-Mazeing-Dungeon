package com.company;

import java.util.Scanner;

public class Hero extends Creature{
    private int row;
    private int col;
    public Hero(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
        this.row = 12;
        this.col = 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /* moveHero to be developed and adjusted to maze.*/
    /*
    public void moveHero() {
        String wall = "[W]";

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter direction: E W S N");
        String direction = scanner.nextLine();

        if (direction.equals("E") && (y < board.length - 1) && (!board[x][y + 1].equals(wall))) {
            board[x][y] = "[ ]";
            board[x][++y] = hero;
        } else if (direction.equals("W") && (y >= 2) && (!board[x][y - 1].equals(wall))) {
            board[x][y] = "[ ]";
            board[x][--y] = hero;
        } else if (direction.equals("S") && x < board.length - 1 && (!board[x + 1][y].equals(wall))) {
            board[x][y] = "[ ]";
            board[++x][y] = hero;
        } else if (direction.equals("N") && (x >= 2) && (!board[x - 1][y].equals(wall))) {
            board[x][y] = "[ ]";
            board[--x][y] = hero;
        }
    }
    */

    public void moveWest(){
        this.col--;
    }

    public void moveEast(){
        this.col++;
    }

    public void moveNorth(){
        this.row--;
    }

    public void moveSouth(){
        this.row++;
    }

    @Override
    public void getDamage() {

    }

    @Override
    public String toString() {
        return "Hero{}";
    }
}
