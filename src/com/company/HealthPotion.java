package com.company;

public class HealthPotion extends Item {
    private int healthPoints;

    public HealthPotion(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return String.format("You found Health Potion that restores %d health points!", healthPoints);
    }
}
