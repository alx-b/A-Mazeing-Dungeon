package com.company;

public class Sword extends Item {

    public Sword(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("You just got a new sword! Sword name: %s", getName());
    }
}
