package com.somethingspecific.entities;

public class Entity {
    AssetManager assets;
    ScreenManager screen;
    float x;
    float y;
    float dx;
    float dy;

    public Entity(AssetManager assets, ScreenManager screen, float xPosition, float yPosition, float xVelocity, float yVelocity){
        this.assets = assets;
        this.screen = screen;
        x = xPosition;
        y = yPosition;
        dx = xVelocity;
        dy = yVelocity;
    }
}
