package com.somethingspecific.input;

public class InputManager {


    static GamePadManager game;


    public static float[] vertical, horizontal;
    public static boolean[] jump;
    public static boolean[] attack;
    public static float[] trigger;

    public static void init() {
        game = new GamePadManager();

        horizontal = new float[2];
        vertical = new float[2];

        jump = new boolean[2];
        attack = new boolean[2];
        trigger = new float[2];
    }

    public static void update() {

    }


}
