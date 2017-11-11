package com.somethingspecific.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.EntityManager;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.graphics.AnimState;
import com.somethingspecific.graphics.Animation;
import com.somethingspecific.graphics.CharacterSheet;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.GamePadManager;
import com.somethingspecific.input.InputManager;

public class Player extends Mob {


//    static double ANGLE_UP = (Math.PI / 2);
//    static double ANGLE_DOWN = (Math.PI / 2) * 3;
    static float ANGLE_UP = 90f;
    static float ANGLE_DOWN = 270f;

    static float jumpForce = 70f;
    static float gravityForce = -1.75f;
    static float moveForce = 3f;
    static float dashForce = 100f;
    static float dashWait = 0.5f;
    static float deathWait = 1.0f;
    static float attackWait =  0.4f;
    static float attackRange = 200f;

    //Keeps track of which direction the character is facing 1 for right, -1 for left
    float dir;
    int playerNum;
    boolean jumping;
    boolean nearMonument;
    float dashTimer;
    float deathTimer;
    float attackTimer;
    Vector2 target;
    Animation anim;


    public Player(EntityManager ent, float x, float y, CharacterSheet c, int playerNum){
        super(ent, null, x,y);
        this.playerNum = playerNum;
        target = new Vector2();
        anim = new Animation(c);
        size = new Vector2(c.idle[0].getRegionWidth(), c.idle[0].getRegionHeight());
        body = new Rectangle(x, y, size.x, size.y);
        dir = 1f;
    }

    public void move(float move){
        velocity.add(move, gravityForce);
        newPosition.set(position);
        newPosition.add(velocity);
        float xStep = 1f;
        if(-0.9f < velocity.x  && velocity.x < 0.9f) anim.setAnim(AnimState.IDLE);
        if(position.x > newPosition.x) xStep = -1f;
        while(Math.floor(position.x) != Math.floor(newPosition.x)) {
            if(ent.checkCollision(this,position.x + xStep, position.y, size)) {
                position.add(xStep, 0);
                if(dir < 0) {
                    if(xStep < 0) {
                        anim.setAnim(AnimState.FORWARD);
                    }else {
                        anim.setAnim(AnimState.BACKWARD);
                    }
                }else {
                    if(xStep < 0) {
                        anim.setAnim(AnimState.BACKWARD);
                    }else {
                        anim.setAnim(AnimState.FORWARD);
                    }
                }
            }else{
                velocity.set(0, velocity.y);
                anim.setAnim(AnimState.IDLE);
                break;
            }
        }
        float yStep = 1f;
        if(position.y > newPosition.y) yStep = -1f;
        while(Math.floor(position.y) != Math.floor(newPosition.y)) {
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
                anim.lockState(AnimState.ATTACK);
                attackTimer = attackWait;
                if(ent.players[(playerNum + 1) % 2].deathTimer <= 0) {
                    double dist = position.dst(target);
                    if (dist < attackRange) {
                        if(nearMonument) {
                            int health = --ent.monuments[(playerNum + 1) % 2].health;
                            ent.ui.setHealth(playerNum,  health / 12f);
                        }else {
                            ent.players[(playerNum + 1) % 2].deathTimer = deathWait;
                        }
                    }
                }
            }
        }else {
            attackTimer -= Gdx.graphics.getDeltaTime();
        }
    }



    public void updateDirection() {
        Vector2 otherP;
        Vector2 otherS;
        Vector2 monP = ent.monuments[(playerNum + 1) % 2].position;
        if(position.dst(monP) < attackRange * 2) {
            otherP = monP;
            otherS = ent.monuments[(playerNum + 1) % 2].size;
            nearMonument = true;
        }else {
            otherP = ent.players[(playerNum + 1) % 2].position;
            otherS = ent.players[(playerNum + 1) % 2].size;
            nearMonument = false;
        }
        target.set(position.x + (size.x / 2f), position.y + (size.y / 2f));
        target.sub(otherP.x + (otherS.x / 2f), otherP.y + (otherS.y / 2f));
        target.setLength(attackRange);
        double angle = target.angle();
        if(angle > ANGLE_UP && angle < ANGLE_DOWN) {
            dir = 1f;
        }else {
            dir = -1f;
        }
        target.set(otherP);

    }





    public void friction() {
        velocity.set(velocity.x * 0.6f, velocity.y * 0.9f);
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
            move(move);
            dash(dash);
            jump(jump);
            updateDirection();
            attack(attack);
            anim.update();
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
