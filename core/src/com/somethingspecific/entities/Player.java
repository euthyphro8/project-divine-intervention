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


    static float jumpForce = 50f;
    static float gravityForce = -1.5f;
    static float moveForce = 3f;

    public Player(EntityManager ent, float x, float y, Texture t, int playerNum){
        super(ent, t, x,y);
        this.playerNum =playerNum;
    }





    public void jump(boolean jump) {
        if(jump && !jumping && !inAir) {
            velocity.add(0, jumpForce);
            jumping = true;
            inAir = true;
        }else if(!jump){
            jumping = false;
        }
    }

    public void move(){
        boolean dashRight = (InputManager.trigger[playerNum]<=-.5f);
        boolean dashLeft = (InputManager.trigger[playerNum]>=.5f);
        boolean jump = InputManager.jump[playerNum];
        float move = InputManager.horizontal[playerNum] * moveForce;
        jump(jump);

        velocity.add(move, gravityForce);
        newPosition.set(position);
        newPosition.add(velocity);

        float xStep = 1f;
        if(position.x > newPosition.x) xStep = -1f;
        while(Math.floor(position.x) != Math.floor(newPosition.x)) {
        //while(!((newPosition.x < position.x + 0.6f) && (newPosition.x > position.x - 0.6f))) {
            if(ent.checkCollision(this,position.x + xStep, position.y, size)) {
                position.add(xStep, 0);
            }else{
                velocity.set(0, velocity.y);
                break;
            }
        }
        float yStep = 1f;
        if(position.y > newPosition.y) yStep = -1f;
        while(!((newPosition.y < position.y + 0.6f) && (newPosition.y > position.y - 0.6f))) {
            if(ent.checkCollision(this, position.x, position.y + yStep, size)) {
                position.add(0, yStep);
            }else{
                if(yStep == -1) {
                    inAir = false;
                }
                break;
            }
        }

        friction();
        capVelocity();
        body.setPosition(position);
    }
    public void friction() {
        velocity.set(velocity.x * 0.9f, velocity.y * 0.9f);
    }

    public void capVelocity() {
        if(velocity.x > 100) velocity.x = 100;
        if(velocity.y > 100) velocity.y = 100;
        if(velocity.x < -100) velocity.x = -100;
        if(velocity.y < -100) velocity.y = -100;
    }

    @Override
    public void update(){
        super.update();
        move();
    }

}
