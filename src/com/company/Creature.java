package com.company;

public abstract class Creature {
    String name;
    int health;
    int damage;
    int maxHealth;

    //private final int MAX_HEALTH =  200;

    public Creature(String name, int health, int damage, int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = maxHealth;
    }

    public abstract void getDamage();

}
