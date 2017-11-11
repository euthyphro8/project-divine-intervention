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
    int frameCount;
    int currentFrame;
    float frameTimer;


    public Animation(TextureRegion[] idle, TextureRegion[] forward, TextureRegion[] backward, TextureRegion[] attack) {
        this.idle = idle;
        this.forward = forward;
        this.backward = backward;
        this.attack = attack;
        state = AnimState.IDLE;
    }

    public void setAnim(AnimState state) {
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

    public void update() {
        if(frameTimer <= 0) {
            currentFrame = (currentFrame + 1) % frameCount;
            frameTimer = frameDuration;
        }else {
            frameTimer -= Gdx.graphics.getDeltaTime();
        }
    }
    public void render(ScreenManager screen, Vector2 position, Vector2 size, float scaleX) {
        if(state == AnimState.IDLE) {
            screen.render(idle[currentFrame], position, size, scaleX, 1f);
        }else if(state == AnimState.FORWARD) {
            screen.render(forward[currentFrame], position, size, scaleX, 1f);
        }else if(state == AnimState.BACKWARD) {
            screen.render(backward[currentFrame], position, size, scaleX, 1f);
        }else if(state == AnimState.ATTACK) {
            screen.render(attack[currentFrame], position, size, scaleX, 1f);
        }

    }

}
