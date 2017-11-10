package com.somethingspecific.framework;


import com.somethingspecific.graphics.SpriteSheet;

public class GameManager {
    EntityManager entityManager;
    MapManager mapManager;
    UIManager uiManager;
    LoadManager assets;
    ScreenManager screen;

    public GameManager(LoadManager assets) {
        this.assets = assets;
        this.screen = screen;
        entityManager = new EntityManager();
        mapManager = new MapManager(SpriteSheet.one);
        uiManager = new UIManager();
    }

    public void update(){

    }

    public void render(ScreenManager screen){
        mapManager.render(screen);
        entityManager.render(screen);
    }
}
