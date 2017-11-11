package com.somethingspecific.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class ScreenManager {

    public OrthographicCamera oc;
    SpriteBatch sb;

    public ScreenManager() {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        oc = new OrthographicCamera(width * 2, width * 2 * (height / width));
        oc.position.set(oc.viewportWidth / 2f, oc.viewportHeight/2, 0);
        oc.update();
        sb = new SpriteBatch();
    }

    public void start() {
        oc.update();
        sb.setProjectionMatrix(oc.combined);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        sb.begin();
    }
    public void stop() {
        sb.end();
    }

    public void setPosition(float x) {
        oc.position.set(x, oc.viewportHeight / 2, 1.0f);
        sb.setProjectionMatrix(oc.combined);
        oc.update();
    }
    public void render(Texture texture, float x, float y, float w, float h) {
        sb.draw(texture, x, y, w, h);
    }

    public void render(TextureRegion texture, float x, float y) {
        sb.draw(texture, x, y);
    }
    public void render(Texture texture, float x, float y) {
        sb.draw(texture, x, y);
    }
    public void renderFixed(Texture texture, float x, float y, float w, float h) {
        sb.draw(texture, x  + oc.position.x - (oc.viewportWidth / 2f), y + oc.position.y - (oc.viewportHeight / 2f), w, h);
    }
    public void render(Texture texture, Vector2 position) {
        sb.draw(texture, position.x, position.y);
    }
    public void render(TextureRegion texture, Vector2 position) {
        sb.draw(texture, position.x, position.y);
    }

//    public void render(Texture texture, Vector2 position, Vector2 size, float xScale, float yScale) {
//        sb.draw(texture, position.x, position.y, 0, 0, size.x, size.y, xScale, yScale, 0);
//    }
    public void render(TextureRegion texture, float x, float y, Vector2 size, float xScale, float yScale) {
        sb.draw(texture, x, y, 0, 0, size.x, size.y, xScale, yScale, 0);
    }



}
