package com.company;

public class DragonBoss extends Monster{


    public DragonBoss(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    @Override
    public String toString() {
        return "DragonBoss{}";
    }
}
