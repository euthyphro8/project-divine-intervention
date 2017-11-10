package com.somethingspecific.input;

public class InputManager {


    static GamePadManager game;


    public static float[] vertical, horizontal;
    public static boolean[] jump;
    public static boolean[] dash;

    public static void init() {
        game = new GamePadManager();

        horizontal = new float[2];
        vertical = new float[2];

        jump = new boolean[2];
        dash = new boolean[2];
    }

    public static void update() {

    }




}
