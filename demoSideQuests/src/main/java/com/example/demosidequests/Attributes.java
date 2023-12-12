package com.example.demosidequests;

import javafx.scene.image.Image;

public class Attributes {

    private String description;
    private int level;
    //private Image image;

    Attributes(String description, int level) {
        this.description = description;
        this.level = level;
        //this.image = image;
    }

    Attributes(String description) {

        this.description = description;
    }

    public String getDescription() { return description; }

    public int getLevel() { return level; }

    public void levelUp() {
        this.level++;
}

    @Override
    public String toString() {
        return description + "\t" + level;
    }
}
