package com.somethingspecific.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.GamePadManager;
import com.somethingspecific.input.InputManager;

public class Player extends Mob {
    int playerNum;
    boolean jumping = false;
    boolean dashing = false;

    public Player(EntityManager ent, Vector2 position, int playerNum){
        super(ent, position);
        texture = SpriteSheet.bigHead;
        this.playerNum =playerNum;
    }
    public Player(EntityManager ent, float x, float y, int playerNum){
        super(ent, x,y);
        texture = SpriteSheet.bigHead;
        this.playerNum =playerNum;
    }
    public Player(EntityManager ent, float x, float y, Texture t, int playerNum){
        super(ent, x,y);
        texture = t;
        this.playerNum =playerNum;
    }
    public void jump(){
        velocity.y += 20;
    }
    public void dashLeft(){
        newPosition.x -=20 ;
        dashing = true;
    }
    public void dashRight(){
        newPosition.x += 20;
        dashing = true;
    }

    public void move(){
        if(InputManager.jump[playerNum] && !jumping) {
            jump();
            jumping = true;
        }
        else if(!InputManager.jump[playerNum]){
            jumping = false;
        }
        if(InputManager.trigger[playerNum]>=1){
            dashLeft();
        }else if(InputManager.trigger[playerNum]<=-1) {
            dashRight();
        }
        else if(InputManager.trigger[playerNum]<1&&InputManager.trigger[playerNum]>-1){
            dashing = false;
        }

        position.x += InputManager.horizontal[playerNum];
    }

    @Override
    public void update(){
        super.update();
        move();
    }

}
