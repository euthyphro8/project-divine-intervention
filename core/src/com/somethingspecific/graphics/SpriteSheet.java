package com.somethingspecific.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {

    public static Texture bigHead;
    public static Texture tiles;

    //-----------------------Maps-----------------------------------//
    public static Texture one;



    //------------------------Tiles----------------------------------//
    public static TextureRegion grass;
    public static TextureRegion space;

    public static void init() {
        bigHead = new Texture(Gdx.files.internal("textures/BigHead.png"));
        tiles = new Texture(Gdx.files.internal("textures/spritesheet/tiles.png"));


        one = new Texture(Gdx.files.internal("maps/one.png"));


        grass = new TextureRegion(tiles, 0, 0, 32, 32);
        space = new TextureRegion(tiles, 33, 0, 32, 32);

    }





}
