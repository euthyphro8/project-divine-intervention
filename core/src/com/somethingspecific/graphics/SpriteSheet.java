package com.somethingspecific.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {


    //-----------------------Character----------------------------//
    public static Texture bigHead;
    public static Texture hoodGod;
    public static Texture hoodGodHit;
    public static Texture temple;

    //------------------------Background-------------------------------------//
    public static Texture house;
    public static Texture person;
    public static Texture person_2;

    //-----------------------Maps-----------------------------------//
    public static Texture one;


    //------------------------TileSheet---------------------------//
    public static Texture tiles;

    //------------------------Tiles----------------------------------//
    public static TextureRegion grass;
    public static TextureRegion space;





    public static void init() {
        bigHead = new Texture(Gdx.files.internal("textures/BigHead.png"));
        tiles = new Texture(Gdx.files.internal("textures/spritesheet/tiles.png"));
        hoodGod = new Texture(Gdx.files.internal("textures/hood_god.png"));
        hoodGodHit  = new Texture(Gdx.files.internal("textures/hood_god.png"));
        temple = new Texture(Gdx.files.internal("textures/temple.png"));


        house = new Texture(Gdx.files.internal("textures/house.png"));
        person = new Texture(Gdx.files.internal("textures/person.png"));
        person_2 = new Texture(Gdx.files.internal("textures/person_2.png"));


        one = new Texture(Gdx.files.internal("maps/one.png"));


        grass = new TextureRegion(tiles, 0, 0, 32, 32);
        space = new TextureRegion(tiles, 33, 0, 32, 32);

    }





}
