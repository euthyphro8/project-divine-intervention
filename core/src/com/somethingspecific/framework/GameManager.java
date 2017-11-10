package com.somethingspecific.framework;


import com.somethingspecific.graphics.SpriteSheet;

public class GameManager {


    EntityManager entityManager;
    MapManager mapManager;
    UIManager uiManager;

    public GameManager(LoadManager assets) {
        mapManager = new MapManager(SpriteSheet.one);
        entityManager = new EntityManager(mapManager);
        uiManager = new UIManager();
    }

    public void update(){
        entityManager.update();
    }

    public void render(ScreenManager screen){
        mapManager.render(screen);
        entityManager.render(screen);
    }
}
