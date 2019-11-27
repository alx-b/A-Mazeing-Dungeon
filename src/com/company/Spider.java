package com.company;

public class Spider extends Monster {

    public Spider(String name, int health, int damage, int maxHealth) {
        super(name, health, damage, maxHealth);
    }

    @Override
    public String toString() {
        return "Spider{}";
    }
}
