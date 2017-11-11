package com.somethingspecific.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.ScreenManager;

public class Animation {

    static float animDuration = 0.5f;

    TextureRegion[] idle, forward, backward, attack, in, out;
    AnimState state;
    boolean stateLocked;
    int frameCount;
    int currentFrame;
    float frameTimer;


    public Animation(CharacterSheet c) {
        this.idle = c.idle;
        this.forward = c.forward;
        this.backward = c.backward;
        this.attack = c.attack;
        this.in = c.in;
        this.out = c.out;
        state = AnimState.IDLE;
    }

    public void setAnim(AnimState state) {
        if(stateLocked) return;
        this.state = state;
        if(state == AnimState.IDLE) {
            frameCount = idle.length;
            animDuration = 0.7f;
        }else if(state == AnimState.FORWARD) {
            frameCount = forward.length;
            animDuration = 0.7f;
        }else if(state == AnimState.BACKWARD) {
            frameCount = backward.length;
            animDuration = 0.7f;
        }else if(state == AnimState.ATTACK) {
            frameCount = attack.length;
            animDuration = 0.4f;
            currentFrame = 0;
        }else if(state == AnimState.IN) {
            frameCount = in.length;
            animDuration = 0.7f;
            currentFrame = 0;
        }else if(state == AnimState.OUT) {
            frameCount = out.length;
            animDuration = 0.7f;
            currentFrame = 0;
        }
    }
    public boolean lockState(AnimState state) {
        if(!stateLocked) {
            setAnim(state);
            stateLocked = true;
            return true;
        }
        return false;
    }
    public void update() {
        frameTimer += Gdx.graphics.getDeltaTime();
        if(frameTimer >= animDuration) {
            frameTimer = 0;
            stateLocked = false;
        }
        currentFrame = (int) ((frameTimer / animDuration) * frameCount);
//        if(frameTimer <= 0) {
//            currentFrame = currentFrame + ((int)frameTimer * 1);
//            if(currentFrame >= frameCount) {
//                stateLocked = false;
//                currentFrame %= frameCount;
//            }
//            frameTimer = frameDuration;
//        }else {
//            frameTimer -= Gdx.graphics.getDeltaTime();
//        }
    }
    public void render(ScreenManager screen, Vector2 position, Vector2 size, float scaleX) {
        float x = position.x;
        float y = position.y;
        if(scaleX < 0) x -= (size.x * scaleX);
        if(state == AnimState.IDLE) {
            screen.render(idle[currentFrame], x, y, size, scaleX, 1f);
        }else if(state == AnimState.FORWARD) {
            screen.render(forward[currentFrame], x, y, size, scaleX, 1f);
        }else if(state == AnimState.BACKWARD) {
            screen.render(backward[currentFrame], x, y, size, scaleX, 1f);
        }else if(state == AnimState.ATTACK) {
            screen.render(attack[currentFrame], x, y, size, scaleX, 1f);
        }else if(state == AnimState.IN) {
            screen.render(in[currentFrame], x, y, size, scaleX, 1f);
        }else if(state == AnimState.OUT) {
            screen.render(out[currentFrame], x, y, size, scaleX, 1f);
        }

    }

}
