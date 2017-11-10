package com.somethingspecific.framework;

public class EntityManager {
    AssetManager assets;
    ScreenManager screen;
    ArrayList<Entity> entities;

    public EntityManager(AssetManager assets, ScreenManager screen){
        this.assets = assets;
        this.screen = screen;
        entities = new ArrayList<Entity>;

    }

    public void update(){
    }

    public void render(){
    }
}
