package com.somethingspecific.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class UIManager {

    Pixmap healthBar;
    Texture fenrirHealth, jormundandr;
    float fFill, jFill;

    public UIManager() {
        healthBar = new Pixmap(1, 1, Pixmap.Format.RGB888);
        healthBar.setColor(1f, 0, 0, 1f);
        healthBar.fillRectangle(0, 0, 1, 1);
        fenrirHealth = new Texture(healthBar);
        jormundandr = new Texture(healthBar);
        fFill = 1f;
        jFill = 1f;
    }

    public void render(ScreenManager screen) {
        float w = screen.oc.viewportWidth;
        float h = screen.oc.viewportHeight;
        float x0 = 64;
        float x1 = w - (w * 0.1f) - x0 + ((w * 0.1f) * (1f - jFill));
        float y = h - 128;
        screen.renderFixed(fenrirHealth, x0, y,(w * 0.1f) * fFill, 32);
        screen.renderFixed(jormundandr, x1, y , (w * 0.1f) * jFill, 32);
    }

    public void setHealth(int playerID, float percent) {
        if(playerID == 0) {
            jFill = Math.max(0, percent);
        }else if(playerID == 1) {
            fFill = Math.max(0, percent);
        }
    }

}

