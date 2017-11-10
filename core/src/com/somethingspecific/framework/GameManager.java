package com.somethingspecific.framework;


public class GameManager {
    EntityManager entityManager;
    MapManager mapManager;
    UIManager uiManager;
    LoadManager assets;
    ScreenManager screen;

    public GameManager(LoadManager assets, ScreenManager screen) {
        this.assets = assets;
        this.screen = screen;
        entityManager = new EntityManager();
        mapManager = new MapManager();
        uiManager = new UIManager();
    }
}
