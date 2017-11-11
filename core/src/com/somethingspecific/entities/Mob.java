package com.somethingspecific.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;

public class Mob extends Entity {

    public Vector2 velocity;
    Vector2 newPosition;
    EntityManager ent;
    boolean inAir;


    public Mob(EntityManager ent, Texture t, float x, float y){
        super(t, x, y);
        this.ent = ent;
        velocity = new Vector2(0, 0);
        newPosition = new Vector2(x,y);
    }


    @Override
    public void update(){
        super.update();
    }




}
