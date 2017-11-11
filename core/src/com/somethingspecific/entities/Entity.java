package com.somethingspecific.entities;

import com.badlogic.gdx.math.Rectangle;
import com.somethingspecific.framework.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Entity {

    public Vector2 size;
    public Vector2 position;
    public Texture texture;
    public Rectangle body;

    public Entity(Texture t, float x, float y){
        texture = t;
        position = new Vector2(x , y);
        if(t !=null) {
            size = new Vector2(texture.getWidth(), texture.getHeight());
            body = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        }
        else System.out.println("[Entity] WARNING: SIZE and BODY are null, be sure to set them elsewhere.");
    }



    public void update(){
    }

    public void render(ScreenManager screen){
        screen.render(texture, position.x, position.y);
    }
}
