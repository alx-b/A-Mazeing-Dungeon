package com.company;

public class Sword extends Item implements Comparable<Sword> {
    private int swordDamage;


    public Sword(String name, int swordDamage, int value) {
        super(name, value);
        this.swordDamage = swordDamage;

    }

    public int getSwordDamage() {
        return swordDamage;
    }


    @Override
    public String toString() {
        return String.format("%s - %d damage", getName(), swordDamage);
    }

    @Override
    public int compareTo(Sword otherSword) {
        return -(swordDamage - otherSword.getSwordDamage());
    }
}
