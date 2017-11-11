package com.somethingspecific.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.graphics.Animation;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.GamePadManager;
import com.somethingspecific.input.InputManager;

public class Player extends Mob {


    static double ANGLE_UP = (Math.PI / 2);
    static double ANGLE_DOWN = (Math.PI / 2) * 3;

    static float jumpForce = 70f;
    static float gravityForce = -1.75f;
    static float moveForce = 3f;
    static float dashForce = 100f;
    static float dashWait = 0.5f;
    static float deathWait = 1.0f;
    static float attackLength = 2.0f; //Length of vector that is shot out to detect a hit
    static float attackWait =  0.4f;


    //Keeps track of which direction the character is facing 1 for right, -1 for left
    float dir;
    int playerNum;
    boolean jumping;
    float dashTimer;
    float deathTimer;
    float attackTimer;
    Vector2 target;
    Animation anim;


    public Player(EntityManager ent, float x, float y, Texture t, int playerNum){
        super(ent, t, x,y);
        this.playerNum =playerNum;
        target = new Vector2();
    }

    public void move(float move){
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
    public void attack(boolean attack) {
        if(attackTimer <= 0f) {
            if(attack) {
                System.out.println("[Player] Attacking");
                //TODO: do attack
                attackTimer = attackWait;
            }
        }else {
            attackTimer -= Gdx.graphics.getDeltaTime();
        }
    }



    public void updateDirection() {
        target.set(ent.players[(playerNum + 1) % 2].position).sub(position).nor().setLength(attackLength);
        if(target.angleRad() > ANGLE_UP && target.angleRad() < ANGLE_DOWN) {
            dir = -1f;
        }else {
            dir = 1f;
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
            float dash = InputManager.trigger[playerNum];
            boolean jump = InputManager.jump[playerNum];
            boolean attack = InputManager.attack[playerNum];
            float move = InputManager.horizontal[playerNum] * moveForce;
            dash(dash);
            jump(jump);
            updateDirection();
            attack(attack);
            move(move);
        }else {
            deathTimer -= Gdx.graphics.getDeltaTime();
        }
    }

    @Override
    public void render(ScreenManager screen) {
        if(deathTimer <= 0) {
            anim.render(screen, position, size, dir);
        }
    }


}
