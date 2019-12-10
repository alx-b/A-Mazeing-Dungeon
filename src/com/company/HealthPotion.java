package com.company;

public class HealthPotion extends Item implements Comparable<HealthPotion>{
    private int healthPoints;


    public HealthPotion(String name, int healthPoints, int value) {
        super(name, value);
        this.healthPoints = healthPoints;

    }

    public int getHealthPoints() {
        return healthPoints;
    }


    @Override
    public String toString() {
        return String.format("%s - Restores %d HP", getName(), healthPoints);
    }

    @Override
    public int compareTo(HealthPotion otherPotion) {
        return -(getHealthPoints() - otherPotion.getHealthPoints());
    }
}
