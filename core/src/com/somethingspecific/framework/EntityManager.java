package com.somethingspecific.framework;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.entities.*;
import com.somethingspecific.graphics.SpriteSheet;

import java.util.ArrayList;

public class EntityManager {


    public Entity[] players;
    public Vector2 xBounds;
    MapManager map;
    ArrayList<Entity> entities;

    public EntityManager(MapManager map){
        this.map = map;
        entities = new ArrayList<Entity>();
        players = new Entity[2];
        players[0] = new Player(this, 200.0f,200.0f, SpriteSheet.bigHead, 0);
        players[1] = new Player(this, 800.0f,200.0f,SpriteSheet.bigHead, 1);
        xBounds = new Vector2(-100000,100000);
    }


    public void update(){
        for(int i=0; i < players.length; i++){
            players[i].update();
        }
    }

    public void render(ScreenManager screen){
        screen.setPosition((players[0].position.x + players[1].position.x) / 2f);
        xBounds.set(screen.getBounds().x, screen.getBounds().x + screen.getWidth());
//        System.out.println(xBounds.toString());


        for(int i = 0; i < players.length; i++){
            players[i].render(screen);
        }
    }

    public boolean checkCollision(Entity entity, float x, float y, Vector2 size) {
        entity.body.setPosition(x, y);
        float x0 = x;
        float x1 = x0 + size.x;
        float y0 = y; //(y - (size.y / 2f));
        float y1 = y0 + size.y;
        //Screen Collision
//        if(x0 < xBounds.x) return false;
//        if(x1 > xBounds.y) return false;
        //Tile Collision
        for(int ty = 0; ty < map.height; ty++) {
            for(int tx = 0; tx < map.width; tx++) {
                if(map.tiles[tx + ( ty * map.width)] >= 0) continue;
                float tx0 = (tx * MapManager.tilesize); //- (MapManager.tilesize / 2f);
                float tx1 = tx0 + (MapManager.tilesize);
                float ty0 = (ty * MapManager.tilesize);// - (MapManager.tilesize / 2f);
                float ty1 = ty0 + (MapManager.tilesize);
                if(x0 <= tx0 && x1 > tx0 && y0 <= ty0 && y1 > ty0)
                    return false;
                if(x0 <= tx1 && x1 > tx1 && y0 <= ty1 && y1 > ty1)
                    return false;
                if(x0 <= tx0 && x1 > tx0 && y0 <= ty1 && y1 > ty1)
                    return false;
                if(x0 <= tx1 && x1 > tx1 && y0 <= ty0 && y1 > ty0)
                    return false;
            }
        }
        return true;
    }
}
