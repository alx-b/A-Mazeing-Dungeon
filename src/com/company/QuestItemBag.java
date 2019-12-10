package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestItemBag implements Serializable {
    private ArrayList<QuestItem> questItems = new ArrayList<>();

    public QuestItemBag() {
    }

    public void addItem(QuestItem questItem){
        this.questItems.add(questItem);
    }

    public void removeItemByName(String name){
        this.questItems.removeIf(item -> item.getName().equals(name));
    }

    public boolean contains(String name) {
        for (QuestItem item : this.questItems){
            if (item.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
