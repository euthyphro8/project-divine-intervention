package com.somethingspecific.framework;


import com.somethingspecific.graphics.SpriteSheet;

public class GameManager {


    EntityManager ent;
    MapManager map;
    UIManager ui;

    public GameManager(ScreenManager screen) {
        ui = new UIManager();
        map = new MapManager(SpriteSheet.valleys);
        ent = new EntityManager(map, ui, screen);
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
