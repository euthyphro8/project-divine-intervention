package com.somethingspecific.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterSheet {

    Texture sheet;
    TextureRegion[] idle, forward, backward, attack;

    public CharacterSheet(Texture sheet, TextureRegion[] idle, TextureRegion[] forward, TextureRegion[] backward, TextureRegion[] attack) {
        this.idle = idle;
        this.forward = forward;
        this.backward = backward;
        this.attack = attack;
    }
}
