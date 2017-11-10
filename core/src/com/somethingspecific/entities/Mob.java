package com.somethingspecific.entities;

import com.badlogic.gdx.math.Vector2;

public class Mob extends Entity {

    Vector2 velocity;


    public Mob(Vector2 position, Vector2 velocity){
        super(position);
        this.velocity = velocity;
    }
    public Mob(Vector2 position){
        super(position);
        velocity.x = 0f;
        velocity.y = 0f;
    }
    public Mob(float x, float y){
        super(x,y);
        Vector2 v = new Vector2();
        v.x = 0f;
        v.y = 0f;
        velocity =v;
    }

    public void setVelocity(Vector2 v){
        velocity = v;
    }
    public void setXVelocity(float x){
        velocity.x =x;
    }
    public void setYVelocity(float y){
        velocity.y =y;
    }
@Override
    public void update(){
        position.x+=velocity.x;
        position.y+=velocity.y;
        if(position.y>0)
        velocity.y -=1;
    }
}
