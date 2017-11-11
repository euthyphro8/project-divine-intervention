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
        velocity.y += 200;
    }
    public void dashLeft(){
        newPosition.x -=200 ;
        dashing = true;
    }



    public void dashRight(){
        newPosition.x += 1;
        dashing = true;
    }

    public void move(){
        newPosition.set(position);


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
        System.out.println("newPosition "+newPosition.x);
        newPosition.add(velocity);
        if(playerNum == 0)
        System.out.println("Velocity is: " + velocity.toString() + ", position: " + position.toString() + ", newPosition: " + newPosition.toString());

        int scale = 1;
        boolean collided = false;
        //--------------------------------------------------------
        if(position.x != newPosition.x) {
            collPosition.set(position);
            if (position.x < newPosition.x) {
                for (float x = position.x; x < newPosition.x; x += 1) {
                    collPosition.x += 1;
                    if (!ent.checkCollision(collPosition, size)) {
                        break;
                    }
                }
            } else if (position.x > newPosition.x) {
                for (float x = position.x; x > newPosition.x; x -= 1) {
                    collPosition.x -= 1;
                    if (!ent.checkCollision(collPosition, size)) {
                        break;
                    }
                }

            }
            position.set(collPosition);
        }
        if(position.y != newPosition.y) {
            collPosition.set(position);
            if (position.y < newPosition.y) {
                for (float x = position.y; x < newPosition.y; x += 1) {
                    collPosition.y += 1;
                    if (!ent.checkCollision(collPosition, size)) {
                        break;
                    }
                }
            } else if (position.y > newPosition.y) {
                for (float x = position.y; x > newPosition.y; x -= 1) {
                    collPosition.y -= 1;
                    if (!ent.checkCollision(collPosition, size)) {
                        break;
                    }
                }

            }
            position.set(collPosition);
        }

//
//

//            if(position.x > newPosition.x) scale = -1;
//            for(float x = position.x; x < newPosition.x; x += (1 * scale)) {
//                collPosition.add(scale, 0);
//                if(!ent.checkCollision(collPosition, size))  {
//                    position.set(collPosition);
//                    collided = true;
//                    break;
//                }
//            }
//            if(!collided) position.set(newPosition);
//        }

//        if(position.y != newPosition.y) {
//            collPosition.set(position);
//            scale = 1;
//            collided = false;
//            if (position.y > newPosition.y) scale = -1;
//            for (float y = position.y; y < newPosition.y; y += (1 * scale)) {
//                collPosition.add(0, scale);
//                if (!ent.checkCollision(collPosition, size)) {
//                    position.set(collPosition);
//                    collided = true;
//                    break;
//                }
//            }
//            if (!collided) position.set(newPosition);
//        }

    }


    @Override
    public void update(){
        super.update();
        move();
    }

}
