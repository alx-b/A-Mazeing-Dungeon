package com.company;

public abstract class Creature {
    private String name;
    private int health;
    private int damage;
    private int maxHealth;

    //private final int MAX_HEALTH =  200;

    public Creature(String name, int health, int damage, int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = maxHealth;
    }

    public abstract void getDamage();

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
