package com.somethingspecific.framework;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.entities.*;
import com.somethingspecific.graphics.SpriteSheet;

import java.util.ArrayList;

public class EntityManager {
    ArrayList<Entity> entities;
    Entity[] players;

    public EntityManager(){
        entities = new ArrayList<Entity>();
        players = new Entity[2];
        players[0] = new Player(-300.0f,0.0f, SpriteSheet.bigHead, 0);
        players[1] = new Player(300.0f,0.0f,SpriteSheet.bigHead, 1);


    }

    public Vector2 findPosition(){
        return new Vector2((players[0].position.x+ players[1].position.x)/2,0);
    }

    public void update(){
        for(int i=0;i<players.length;i++){
            players[i].update();
        }
    }

    public void render(ScreenManager screen){
        screen.setPosition(findPosition());

        for(int i=0;i<players.length;i++){
            players[i].render(screen);
        }


    }
}
