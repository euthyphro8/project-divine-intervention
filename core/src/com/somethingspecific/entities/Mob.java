package com.somethingspecific.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;

public class Mob extends Entity {

    Vector2 velocity;
    Vector2 newPosition, collPosition;
    EntityManager ent;



    public Mob(EntityManager ent, Texture t, float x, float y){
        super(t, x, y);
        this.ent = ent;
        velocity = new Vector2(0, 0);
        newPosition = new Vector2(x,y);
        collPosition = new Vector2(x,y);
    }

    public void setVelocity(Vector2 v){
        velocity = v;
    }
    public void setXVelocity(float x){
        velocity.x = x;
    }
    public void setYVelocity(float y){
        velocity.y = y;
    }

    @Override
    public void update(){
        super.update();
    }




}
