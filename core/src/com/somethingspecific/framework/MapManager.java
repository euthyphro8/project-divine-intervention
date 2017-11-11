package com.somethingspecific.framework;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.somethingspecific.entities.Tile;
import com.somethingspecific.graphics.SpriteSheet;

public class MapManager {


    public static final int tilesize = 32;

    public short[] tiles;
    public int width;
    public int height;
    public Texture bkgnd;


    public MapManager(Texture map){
        bkgnd = SpriteSheet.background;
        width = map.getWidth();
        height = map.getHeight();
        tiles = new short[width * height];
        if(!map.getTextureData().isPrepared())
            map.getTextureData().prepare();
        Pixmap p = map.getTextureData().consumePixmap();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(p.getPixel(x,y) == Tile.GRASS_COL) tiles[x + ((height - y - 1) * width)] = Tile.GRASS_ID;
                if(p.getPixel(x,y) == Tile.DIRT_COL) tiles[x + ((height - y - 1) * width)] = Tile.DIRT_ID;
                if(p.getPixel(x,y) == Tile.SAND_COL) tiles[x + ((height - y - 1) * width)] = Tile.SAND_ID;
                if(p.getPixel(x,y) == Tile.WATER_COL) tiles[x + ((height - y - 1) * width)] = Tile.WATER_ID;

            }
        }
    }

    public void update(){

    }

    public void render(ScreenManager screen){
        screen.renderFixed(bkgnd, 0, 0, screen.oc.viewportWidth, screen.oc.viewportHeight);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(tiles[x + (y * width)] == Tile.GRASS_ID) screen.render(SpriteSheet.grass, (x * tilesize), (y * tilesize));
                if(tiles[x + (y * width)] == Tile.SAND_ID) screen.render(SpriteSheet.sand, (x * tilesize), (y * tilesize));
                if(tiles[x + (y * width)] == Tile.DIRT_ID) screen.render(SpriteSheet.dirt, (x * tilesize), (y * tilesize));
                if(tiles[x + (y * width)] == Tile.WATER_ID) screen.render(SpriteSheet.water, (x * tilesize), (y * tilesize));
            }
        }
    }

}
