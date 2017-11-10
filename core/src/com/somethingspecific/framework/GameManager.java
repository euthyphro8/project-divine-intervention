package com.somethingspecific.framework;

import javax.swing.*;

public class GameManager {
    EntityManager entityManager;
    MapManager mapManager;
    UIManager uiManager;
    AssetManager assets;
    ScreenManager screen;

    public GameManager(AssetManager assets, ScreenManager screen) {
        this.assets = assets;
        this.screen = screen;
        entityManager = new EntityManager(assets, screen);
        mapManager = new MapManager(assets, screen);
        uiManager = new UIManager();
    }
}
