package com.somethingspecific.entities;
import com.somethingspecific.framework.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    Vector2 position;
    Vector2 velocity;
    Texture texture;

    public Entity(Vector2 position, Vector2 velocity){
        this.position = position;
        this.velocity = velocity;
    }

    public void update(){
    }

    public void render(ScreenManager screen){
        screen.render(texture, position);
    }
}
