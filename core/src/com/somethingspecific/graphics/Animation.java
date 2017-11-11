package com.somethingspecific.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.ScreenManager;

public class Animation {

    static float frameDuration = 0.1f;

    TextureRegion[] idle, forward, backward, attack;
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
        state = AnimState.IDLE;
    }

    public void setAnim(AnimState state) {
        if(stateLocked) return;
        this.state = state;
        if(state == AnimState.IDLE) {
            frameCount = idle.length;
        }else if(state == AnimState.FORWARD) {
            frameCount = forward.length;
        }else if(state == AnimState.BACKWARD) {
            frameCount = backward.length;
        }else if(state == AnimState.ATTACK) {
            frameCount = attack.length;
        }
    }
    public void lockState(AnimState state) {
        if(!stateLocked) {
            setAnim(state);
            stateLocked = true;
        }
    }
    public void update() {
        if(frameTimer <= 0) {
            currentFrame = currentFrame + 1;
            if(currentFrame == frameCount) {
                stateLocked = false;
                currentFrame %= frameCount;
            }
            frameTimer = frameDuration;
        }else {
            frameTimer -= Gdx.graphics.getDeltaTime();
        }
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
        }

    }

}
