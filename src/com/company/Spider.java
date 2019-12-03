package com.company;

public class Spider extends Monster {

    public Spider(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    public int getDamage() {
        return this.damage;
    }

}
