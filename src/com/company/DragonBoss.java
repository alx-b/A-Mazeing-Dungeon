package com.company;

import java.util.Scanner;

public class DragonBoss extends Monster {

    public DragonBoss(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }


    public int getDamage(){
        return this.damage;
    }
}
