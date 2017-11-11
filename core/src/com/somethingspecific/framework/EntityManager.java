package com.somethingspecific.framework;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.entities.*;
import com.somethingspecific.graphics.SpriteSheet;

import java.util.ArrayList;

public class EntityManager {


    public Monument[] monuments;
    public Player[] players;
    public Vector2 xBounds;
    public MapManager map;
    public ScreenManager screen;
    public ArrayList<Entity> entities;
    public UIManager ui;

    public EntityManager(MapManager map, UIManager ui, ScreenManager screen){
        this.map = map;
        this.ui = ui;
        this.screen = screen;
        entities = new ArrayList<Entity>();
        players = new Player[2];
        players[0] = new Player(this, 3300.0f,800.0f, SpriteSheet.HOOD_GOD, 0);
        players[1] = new Player(this, 6000.0f,800.0f, SpriteSheet.FENRIR, 1);

        xBounds = new Vector2(-100000,100000);

        monuments = new Monument[2];
        monuments[0] = new Monument(SpriteSheet.temple, 32, 288, 0);
        monuments[1] = new Monument(SpriteSheet.temple, 9440, 288, 1);
        entities.add(monuments[0]);
        entities.add(monuments[1]);
    }


    public void update(){
        for(int i=0; i < players.length; i++){
            players[i].update();
        }
        screen.setPosition((players[0].position.x + players[1].position.x) / 2f);
    }

    public void render(ScreenManager screen){

        for(int i = 0; i < players.length; i++){
            players[i].render(screen);
        }
        for(Entity e: entities) {
            e.render(screen);
        }

//        xBounds.set(screen.oc.position.x - ((screen.oc.viewportWidth) / 2f), screen.oc.position.x + ((screen.oc.viewportHeight) / 2f));
//        System.out.println("Bounds: " + xBounds.toString() + ", zoom: " + screen.oc.zoom + ", position" + screen.oc.position.toString() + ", vpW: " + screen.oc.viewportWidth + ", vpH: " + screen.oc.viewportHeight);
//        System.out.println("Entity Position: " + players[1].position.toString());
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
        if(x0 <= 0) return false;
        if(x1 > 301*32) return false;
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
