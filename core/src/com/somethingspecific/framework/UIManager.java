package com.somethingspecific.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.somethingspecific.graphics.SpriteSheet;

public class UIManager {

    Pixmap healthBar;
    Texture fenrirHealth, jormundandrHealth;
    float fFill, jFill;


    Texture fTitle, jTitle;
    Texture fWin, jWin;
    Texture mHealth;

    public UIManager() {
        healthBar = new Pixmap(1, 1, Pixmap.Format.RGB888);
        healthBar.setColor(1f, 0, 0, 1f);
        healthBar.fillRectangle(0, 0, 1, 1);
        fenrirHealth = new Texture(healthBar);
        jormundandrHealth = new Texture(healthBar);

        fTitle = SpriteSheet.fTitle;
        jTitle = SpriteSheet.jTitle;
        fWin = SpriteSheet.fWins;
        jWin = SpriteSheet.jWins;
        mHealth = SpriteSheet.mHealth;


        fFill = 1f;
        jFill = 1f;
    }

    public void render(ScreenManager screen) {
        float w = screen.oc.viewportWidth;
        float h = screen.oc.viewportHeight;
        float x0 = 64;
        float x1 = w - (w * 0.3f) - x0 + ((w * 0.3f) * (1f - jFill));
        float x2 = (w * 0.5f) - (jWin.getWidth() / 2f);
        float x3 = (w * 0.5f) - (fWin.getWidth() / 2f);
        float y = h - 128;
        screen.renderFixed(fenrirHealth, x0, y,(w * 0.3f) * fFill, 32);
        screen.renderFixed(jormundandrHealth, x1, y , (w * 0.3f) * jFill, 32);
        screen.renderFixed(mHealth, x0, y, mHealth.getWidth(), mHealth.getHeight());
        screen.renderFixed(mHealth, w - x0 - mHealth.getWidth(), y, mHealth.getWidth(), mHealth.getHeight());

        if(jFill == 0) {
            screen.renderFixed(jWin, x2, y - 100f, jWin.getWidth(), jWin.getHeight());
        }else if(fFill == 0) {
            screen.renderFixed(fWin, x3, y - 100f, fWin.getWidth(), fWin.getHeight());

        }
    }

    public void setHealth(int playerID, float percent) {
        if(playerID == 0) {
            jFill = Math.max(0, percent);
        }else if(playerID == 1) {
            fFill = Math.max(0, percent);
        }
    }

}

