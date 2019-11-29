package com.company;

public abstract class Monster extends Creature{

    public Monster(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }


    @Override
    public int getDamage() {
        return getDamage();
    }

    @Override
    public String toString() {
        return "Monster{}";
    }
}
