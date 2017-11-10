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





    public void jump() {
        velocity.y += 20;
    }
    public void dashLeft(){
        newPosition.x -=20 ;
        dashing = true;
    }



    public void dashRight(){
        newPosition.x += 1;
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
        if(InputManager.trigger[playerNum]>=.5f){
            System.out.println("{Player} triggerValue "+ InputManager.trigger[playerNum]);
            dashLeft();
        }else if(InputManager.trigger[playerNum]<=-.5f) {
            System.out.println("{Player} triggerValue "+ InputManager.trigger[playerNum]);
            dashRight();
        }
        else if(InputManager.trigger[playerNum]>.5||InputManager.trigger[playerNum]<-.5){
            System.out.println("{Player} triggerValue "+ InputManager.trigger[playerNum]);
            dashing = false;
        }



        if(velocity.x > 10) velocity.x = 10;
        if(velocity.y > 10) velocity.y = 10;
        if(velocity.x < -10) velocity.x = -10;
        if(velocity.y < -10) velocity.y = -10;

        velocity.add(Entity.gravity);
        newPosition.x += InputManager.horizontal[playerNum];
        newPosition.add(velocity);


        collPosition.set(position);
        int scale = 1;
        boolean collided = false;
        if(position.x > newPosition.x) scale = -1;
        for(float x = position.x; x < newPosition.x; x += 1 * scale) {
            collPosition.add(x, 0);
            if(!ent.checkCollision(collPosition, size))  {
                position.set(collPosition);
                collided = true;
                break;
            }
        }
        if(!collided) position.set(collPosition);
        collPosition.set(position);
        scale = 1;
        collided = false;
        if(position.x > newPosition.x) scale = -1;
        for(float x = position.x; x < newPosition.x; x += 1 * scale) {
            collPosition.add(x, 0);
            if(!ent.checkCollision(collPosition, size))  {
                position.set(collPosition);
                collided = true;
                break;
            }
        }
        if(!collided) position.set(collPosition);

    }


    @Override
    public void update(){
        super.update();
        move();
    }

}
