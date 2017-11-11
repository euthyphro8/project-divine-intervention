package com.somethingspecific.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {


    //-----------------------Character----------------------------//

    public static CharacterSheet JOR, FENRIR;


    //------------------------Background-------------------------------------//
    public static Texture temple;
    public static Texture house;
    public static Texture person;
    public static Texture person_2;
    public static Texture background;
    public static Texture menu_background;
    public static Texture title;
    public static Texture start_message;
    public static Texture jTitle;
    public static Texture fTitle;
    public static Texture jWins;
    public static Texture fWins;
    public static Texture mHealth;

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




        //---------------------------------------Fenrir-----------------------------------------------------//
        Texture FENRIR_SHEET = new Texture(Gdx.files.internal("textures/spritesheet/fenrir_sprites.png"));
        int FENRIR_FRAME_COUNT = 30;
        TextureRegion[] FENRIR_IDLE = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_FORWARD = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_BACKWARD = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_ATTACK = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_IN = new TextureRegion[FENRIR_FRAME_COUNT];
        TextureRegion[] FENRIR_OUT = new TextureRegion[FENRIR_FRAME_COUNT];

        for(int i = 0; i < FENRIR_FRAME_COUNT; i++) {
            FENRIR_ATTACK[i] = new TextureRegion(FENRIR_SHEET, i * 320, 0, 320, 320);
            FENRIR_IDLE[i] = new TextureRegion(FENRIR_SHEET, i * 320, 320, 320, 320);
            FENRIR_FORWARD[i] = new TextureRegion(FENRIR_SHEET, i * 320, 640, 320, 320);
            FENRIR_BACKWARD[i] = new TextureRegion(FENRIR_SHEET, i * 320, 960, 320, 320);
            FENRIR_IN[i] = new TextureRegion(FENRIR_SHEET, i * 320, 1280, 320, 320);
            FENRIR_OUT[i] = new TextureRegion(FENRIR_SHEET, i * 320, 1600, 320, 320);
        }
        FENRIR = new CharacterSheet(FENRIR_IDLE, FENRIR_FORWARD, FENRIR_BACKWARD, FENRIR_ATTACK, FENRIR_IN, FENRIR_OUT);

        //---------------------------------------Jor-----------------------------------------------------//
        Texture JOR_SHEET = new Texture(Gdx.files.internal("textures/spritesheet/snake_sprites.png"));
        int JOR_FRAME_COUNT = 30;
    //300
        TextureRegion[] JOR_IDLE = new TextureRegion[JOR_FRAME_COUNT];
        TextureRegion[] JOR_FORWARD = new TextureRegion[JOR_FRAME_COUNT];
        TextureRegion[] JOR_BACKWARD = new TextureRegion[JOR_FRAME_COUNT];
        TextureRegion[] JOR_ATTACK = new TextureRegion[JOR_FRAME_COUNT];
        TextureRegion[] JOR_IN = new TextureRegion[JOR_FRAME_COUNT];
        TextureRegion[] JOR_OUT = new TextureRegion[JOR_FRAME_COUNT];

        for(int i = 0; i < JOR_FRAME_COUNT; i++) {
            JOR_IN[i] = new TextureRegion(JOR_SHEET, i * 300, 0, 300, 330);
            JOR_OUT[i] = new TextureRegion(JOR_SHEET, i * 300, 330, 300, 330);
            JOR_IDLE[i] = new TextureRegion(JOR_SHEET, i * 300, 660, 300, 330);
            JOR_ATTACK[i] = new TextureRegion(JOR_SHEET, i * 300, 990, 300, 330);
            JOR_FORWARD[i] = new TextureRegion(JOR_SHEET, i * 300, 1320, 300, 330);
            JOR_BACKWARD[i] = new TextureRegion(JOR_SHEET, i * 300, 1650, 300, 330);
        }
        JOR = new CharacterSheet(JOR_IDLE, JOR_FORWARD, JOR_BACKWARD, JOR_ATTACK, JOR_IN, JOR_OUT);


        temple = new Texture(Gdx.files.internal("textures/temple.png"));
        house = new Texture(Gdx.files.internal("textures/house.png"));
        person = new Texture(Gdx.files.internal("textures/person.png"));
        person_2 = new Texture(Gdx.files.internal("textures/person_2.png"));

        background = new Texture(Gdx.files.internal("textures/background.png"));
        menu_background = new Texture(Gdx.files.internal("background.png"));
        title = new Texture(Gdx.files.internal("title.png"));
        start_message = new Texture(Gdx.files.internal("start_message.png"));
        fTitle = new Texture(Gdx.files.internal("fTitle.png"));
        jTitle = new Texture(Gdx.files.internal("jTitle.png"));
        jWins = new Texture(Gdx.files.internal("jWin.png"));
        fWins = new Texture(Gdx.files.internal("fWin.png"));
        mHealth = new Texture(Gdx.files.internal("mHealth.png"));

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
