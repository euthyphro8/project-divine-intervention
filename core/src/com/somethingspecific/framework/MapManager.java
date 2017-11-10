package com.somethingspecific.framework;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.somethingspecific.entities.Tile;
import com.somethingspecific.graphics.SpriteSheet;

public class MapManager {


    public static final int tilesize = 32;

    public short[] tiles;
    public int width;
    public int height;


    public MapManager(Texture map){
        width = map.getWidth();
        height = map.getHeight();
        tiles = new short[width * height];
        if(!map.getTextureData().isPrepared())
            map.getTextureData().prepare();
        Pixmap p = map.getTextureData().consumePixmap();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(p.getPixel(x,y) == Tile.GRASS_COL) tiles[(width - x - 1) + ((height - y - 1) * width)] = Tile.GRASS_ID;

            }
        }
    }

    public void update(){

    }

    public void render(ScreenManager screen){
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(tiles[x + (y * width)] == Tile.GRASS_ID) screen.render(SpriteSheet.grass, (x * tilesize), (y * tilesize));
            }
        }
    }

}
