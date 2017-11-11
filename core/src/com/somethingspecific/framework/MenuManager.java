package com.somethingspecific.framework;

import com.badlogic.gdx.graphics.Texture;
import com.somethingspecific.Master;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.InputManager;

public class MenuManager {

    Texture title;
    Texture bkgnd;
    Texture message;
    public MenuManager() {
        title = SpriteSheet.title;
        bkgnd = SpriteSheet.menu_background;
        message = SpriteSheet.start_message;
    }

    public void update() {
        for(int i = 0; i < 2; i++) {
            if(InputManager.jump[i]) Master.state = State.GAME;
        }
    }
    public void render(ScreenManager screen) {
        float w = screen.oc.viewportWidth;
        float h = screen.oc.viewportHeight;
        float x0 = (w * 0.5f) - (title.getWidth() / 2f);
        float y0 = (h * 0.5f) + (title.getHeight()) + 20f;
        float x1 = (w * 0.5f) - (message.getWidth() / 2f);
        screen.render(bkgnd, 0, 0, w, h);
        screen.render(title, x0, y0);
        screen.render(message, x1, y0 - 600f);
    }

    }
