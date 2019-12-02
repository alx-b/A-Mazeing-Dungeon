package com.company;

public class HealthPotion extends Item {
    private int healthPoints;

    public HealthPotion(String name, int healthPoints) {
        super(name);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
        return String.format("%s - Restores %d HP", getName(), healthPoints);
    }
}
