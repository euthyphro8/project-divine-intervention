package com.somethingspecific.entities;

import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;

public class Mob extends Entity {

    Vector2 velocity;
    EntityManager ent;


    public Mob(EntityManager ent, Vector2 position, Vector2 velocity){
        super(position);
        this.ent = ent;
        this.velocity = velocity;
    }
    public Mob(EntityManager ent, Vector2 position){
        super(position);
        this.ent = ent;
        velocity.x = 0f;
        velocity.y = 0f;
    }
    public Mob(EntityManager ent, float x, float y){
        super(x,y);
        this.ent = ent;
        velocity = new Vector2(x, y);
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
        position.x+=velocity.x;
        position.y+=velocity.y;
        if(position.y>0)
            velocity.y -=1;
    }




}
