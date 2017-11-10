package com.somethingspecific.framework;


import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.graphics.SpriteSheet;

public class GameManager {
    EntityManager entityManager;
    MapManager mapManager;
    UIManager uiManager;
    LoadManager assets;

    public GameManager(LoadManager assets) {
        this.assets = assets;
        entityManager = new EntityManager();
        mapManager = new MapManager(SpriteSheet.one);
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
