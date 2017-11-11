package com.somethingspecific.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.GamePadManager;
import com.somethingspecific.input.InputManager;

public class Player extends Mob {

    static float jumpForce = 60f;
    static float gravityForce = -1.75f;
    static float moveForce = 3f;
    static float dashForce = 100f;
    static float dashWait = 0.5f;
    static float deathWait = 1.0f;
    static float attackLength = 2.0f; //Length of vector that is shot out to detect a hit
    static float attackWait =  0.3f;

    int playerNum;
    boolean jumping;
    float dashTimer;
    float deathTimer;
    Vector2 target ;


    public Player(EntityManager ent, float x, float y, Texture t, int playerNum){
        super(ent, t, x,y);
        this.playerNum =playerNum;
        target = new Vector2();
    }



    public void move(){
        float dash = InputManager.trigger[playerNum];
        boolean jump = InputManager.jump[playerNum];
        float move = InputManager.horizontal[playerNum] * moveForce;
        dash(dash);
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

    public void jump(boolean jump) {
        if(jump && !jumping && !inAir) {
            velocity.add(0, jumpForce);
            jumping = true;
            inAir = true;
        }else if(!jump){
            jumping = false;
        }
    }
    public void dash(float dash) {
        if(dashTimer <= 0f) {
            if(dash == 0)
                return;
            else if(dash > 0) {
                velocity.add(-dashForce, 0);
            }else {
                velocity.add(dashForce, 0);
            }
            dashTimer = dashWait;
        }else {
            dashTimer -= Gdx.graphics.getDeltaTime();
        }
    }
    public void friction() {
        velocity.set(velocity.x * 0.7f, velocity.y * 0.9f);
    }

    public void capVelocity() {
        if(velocity.x > 100) velocity.x = 100;
        if(velocity.y > 100) velocity.y = 100;
        if(velocity.x < -100) velocity.x = -100;
        if(velocity.y < -100) velocity.y = -100;
    }

    @Override
    public void update(){
        if(deathTimer <= 0) {
            super.update();
            move();
        }else {
            deathTimer -= Gdx.graphics.getDeltaTime();
        }
    }

    @Override
    public void render(ScreenManager screen) {
        if(deathTimer <= 0) {
            super.render(screen);
        }
    }

    public void getAttackVector() {
        target.set(ent.players[(playerNum + 1) % 2].position).sub(position).nor().setLength(attackLength);
    }

}
