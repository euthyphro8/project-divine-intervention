package com.somethingspecific.entities;

import com.badlogic.gdx.graphics.Texture;

public class Monument extends Entity {

    int playerID;
    int health;

    public Monument(Texture t, float x, float y, int playerID) {
        super(t, x, y);
        this.playerID = playerID;
        health = 12;
    }
}
