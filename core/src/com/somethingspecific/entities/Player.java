package com.somethingspecific.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.graphics.SpriteSheet;

public class Player extends Mob {
    public Player(Vector2 position){
        super(position);
        texture = SpriteSheet.bigHead;
    }
    public Player(float x, float y){
        super(x,y);
        System.out.println("{Player} set texture: "+position.x +" "+position.y);
        texture = SpriteSheet.bigHead;
    }
    public Player(float x, float y, Texture t){
        super(x,y);
        System.out.println("{Player} set texture: "+position.x +" "+position.y+" "+t);
        texture = t;
        System.out.println("{Player} set texture: "+position.x +" "+position.y+" "+texture);
    }
    public void jump(){

    }

    public void moveLeft(){
        velocity.x -= 5;
    }
    public void moveRight(){

        velocity.x += 5;
    }

}
