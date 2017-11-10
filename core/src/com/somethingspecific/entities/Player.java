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

    public Player(EntityManager ent, float x, float y, Texture t, int playerNum){
        super(ent, t, x,y);
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



        if(velocity.x > 10) velocity.x = 10;
        if(velocity.y > 10) velocity.y = 10;
        if(velocity.x < -10) velocity.x = -10;
        if(velocity.y < -10) velocity.y = -10;

        velocity.add(Entity.gravity);
        newPosition.x += InputManager.horizontal[playerNum];
        newPosition.add(velocity);



        if(ent.checkCollision(newPosition, size)) {
            position.set(newPosition);
        }
    }
    float xStep, yStep;


    @Override
    public void update(){
        super.update();
        move();
    }

}
