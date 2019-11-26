package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Backpack backpack = new Backpack("backpack", 0.5f, 0);
        Gold gold1 = new Gold("Gold-1", 0.1f, 1);
        Gold gold2 = new Gold("Gold-2", 0.1f, 12);
        Gold gold3 = new Gold("Gold-3", 0.1f, 2);
        Gold gold4 = new Gold("Gold-4", 0.1f, 10);
        Gold gold5 = new Gold("Gold-5", 0.1f, 20);
        //Sword sword = new Sword("Dragons toothbrush", 0.1f, 10000);
        backpack.addItem(gold1);
        backpack.addItem(gold2);
        backpack.addItem(gold3);
        backpack.addItem(gold4);
        backpack.addItem(gold5);
       // backpack.addItem(sword);
        backpack.showDescription();
        backpack.totalGold();
        //backpack.removeItem();
        backpack.showDescription();
       // Sword tom = new Sword("Dragons gosedjur", 0.1f, 30);
       // backpack.buyItemWithGold(tom);
        backpack.showDescription();

        new Maze();

    }
}