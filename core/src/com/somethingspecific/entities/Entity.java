package com.somethingspecific.entities;
import com.somethingspecific.framework.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    Vector2 position;
    Texture texture;

    public Entity(Vector2 position){
        this.position = position;
    }
    public Entity(float x, float y){
        Vector2 p=new Vector2();
        p.x = x;
        p.y = y;
        position = p;
    }



    public void update(){
    }

    public void render(ScreenManager screen){
        screen.render(texture, position.x,position.y);
    }
}
