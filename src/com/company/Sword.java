package com.company;

public class Sword extends Item {
    private int swordDamage;

    public Sword(String name, int swordDamage) {
        super(name);
        this.swordDamage = swordDamage;
    }

    public int getSwordDamage() {
        return swordDamage;
    }

    @Override
    public String toString() {
        return String.format("You just got a new sword! \n Sword name: %s \n Sword damage: %d", getName(), swordDamage);
    }
}
