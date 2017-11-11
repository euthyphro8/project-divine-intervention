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
    public static Texture background;
    public static Texture menu_background;
    public static Texture title;
    public static Texture start_message;
    public static Texture cloud;

    //-----------------------Maps-----------------------------------//
    public static Texture one;
    public static Texture two;
    public static Texture valleys;



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


        //---------------------------------------HOOD GOD-----------------------------------------------------//
        Texture FENRIR_SHEET = new Texture(Gdx.files.internal("textures/spritesheet/fenrir_sprites.png"));
        int FENRIR_FRAME_COUNT = 30;

        TextureRegion[] FENRIR_IDLE = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_FORWARD = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_BACKWARD = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_ATTACK = new TextureRegion[FENRIR_FRAME_COUNT];

        for(int i = 0; i < FENRIR_FRAME_COUNT; i++) {
            FENRIR_ATTACK[i] = new TextureRegion(FENRIR_SHEET, i * 320, 0, 320, 320);
            FENRIR_IDLE[i] = new TextureRegion(FENRIR_SHEET, i * 320, 320, 320, 320);
            FENRIR_FORWARD[i] = new TextureRegion(FENRIR_SHEET, i * 320, 640, 320, 320);
            FENRIR_BACKWARD[i] = new TextureRegion(FENRIR_SHEET, i * 320, 960, 320, 320);
        }
        FENRIR = new CharacterSheet(FENRIR_IDLE, FENRIR_FORWARD, FENRIR_BACKWARD, FENRIR_ATTACK);



        temple = new Texture(Gdx.files.internal("textures/temple.png"));
        house = new Texture(Gdx.files.internal("textures/house.png"));
        person = new Texture(Gdx.files.internal("textures/person.png"));
        person_2 = new Texture(Gdx.files.internal("textures/person_2.png"));
        cloud = new Texture(Gdx.files.internal("textures/cloud.png"));

        background = new Texture(Gdx.files.internal("textures/background.png"));
        menu_background = new Texture(Gdx.files.internal("background.png"));
        title = new Texture(Gdx.files.internal("title.png"));
        start_message = new Texture(Gdx.files.internal("start_message.png"));

        one = new Texture(Gdx.files.internal("maps/one.png"));
        two = new Texture(Gdx.files.internal("maps/two.png"));
        valleys = new Texture(Gdx.files.internal("maps/valleys.png"));


        grass = new TextureRegion(tiles, 0, 0, 32, 32);
        dirt = new TextureRegion(tiles, 96, 0, 32, 32);
        sand = new TextureRegion(tiles, 96, 32, 32, 32);
        water = new TextureRegion(tiles, 32, 32, 32, 32);
        space = new TextureRegion(tiles, 32, 0, 32, 32);

    }





}
