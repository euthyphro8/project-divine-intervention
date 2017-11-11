package com.somethingspecific.framework;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.somethingspecific.graphics.SpriteSheet;

public class GameManager {


    EntityManager ent;
    MapManager map;
    UIManager ui;
    Sound sound;
    public GameManager(ScreenManager screen) {
        ui = new UIManager();
        map = new MapManager(SpriteSheet.valleys);
        ent = new EntityManager(map, ui, screen);
        //song by Joshua Empyre from freesound.org
        sound = Gdx.audio.newSound(Gdx.files.internal("gameMusic.mp3"));
        long id = sound.play(1.0f);
        sound.setLooping(id, true);
    }

    public void update(){
        ent.update();
    }

    public void render(ScreenManager screen){
        map.render(screen);
        ent.render(screen);
        ui.render(screen);
    }
}
