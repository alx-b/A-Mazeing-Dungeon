package com.company;

public class Bandit extends Monster {

    public Bandit(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

}
