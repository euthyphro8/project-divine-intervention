package com.somethingspecific.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {


    //-----------------------Character----------------------------//

    public static CharacterSheet HOOD_GOD, FENRIR;


    //------------------------Background-------------------------------------//
    public static Texture temple;
    public static Texture house;
    public static Texture person;
    public static Texture person_2;

    //-----------------------Maps-----------------------------------//
    public static Texture one;
    public static Texture two;



    //------------------------Tiles----------------------------------//
    public static TextureRegion grass;
    public static TextureRegion sand;
    public static TextureRegion dirt;
    public static TextureRegion water;
    public static TextureRegion space;




    public static void init() {
        Texture tiles = new Texture(Gdx.files.internal("textures/spritesheet/tiles.png"));


        //---------------------------------------HOOD GOD-----------------------------------------------------//
        Texture HOOD_GOD_SHEET = new Texture(Gdx.files.internal("textures/spritesheet/hoodGod.png"));

        TextureRegion[] HOOD_GOD_IDLE = {
                new TextureRegion(HOOD_GOD_SHEET, 0,0, 200, 320)
        };
        TextureRegion[] HOOD_GOD_FORWARD = {
                new TextureRegion(HOOD_GOD_SHEET, 0,324, 200, 320)
        };
        TextureRegion[] HOOD_GOD_BACKWARD = {
                new TextureRegion(HOOD_GOD_SHEET, 0,648, 200, 320)
        };
        TextureRegion[] HOOD_GOD_ATTACK = {
                new TextureRegion(HOOD_GOD_SHEET, 0,972, 200, 320)
        };

        HOOD_GOD = new CharacterSheet(HOOD_GOD_IDLE, HOOD_GOD_FORWARD, HOOD_GOD_BACKWARD, HOOD_GOD_ATTACK);


        temple = new Texture(Gdx.files.internal("textures/temple.png"));
        house = new Texture(Gdx.files.internal("textures/house.png"));
        person = new Texture(Gdx.files.internal("textures/person.png"));
        person_2 = new Texture(Gdx.files.internal("textures/person_2.png"));


        one = new Texture(Gdx.files.internal("maps/one.png"));
        two = new Texture(Gdx.files.internal("maps/two.png"));


        grass = new TextureRegion(tiles, 0, 0, 32, 32);
        dirt = new TextureRegion(tiles, 96, 0, 32, 32);
        sand = new TextureRegion(tiles, 96, 32, 32, 32);
        water = new TextureRegion(tiles, 32, 32, 32, 32);
        space = new TextureRegion(tiles, 32, 0, 32, 32);

    }





}
