package com.company;

import java.io.Serializable;

public class QuestItem implements Serializable {
    private String name;
    private String description;

    public QuestItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
