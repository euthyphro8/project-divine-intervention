package com.somethingspecific.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SpriteSheet {

    public static Texture bigHead;

    public static void init() {
        bigHead = new Texture(Gdx.files.internal("textures/BigHead.png"));
    }





}
