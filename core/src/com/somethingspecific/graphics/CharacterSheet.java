package com.somethingspecific.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterSheet {

    public TextureRegion[] idle, forward, backward, attack;

    public CharacterSheet(TextureRegion[] idle, TextureRegion[] forward, TextureRegion[] backward, TextureRegion[] attack) {
        this.idle = idle;
        this.forward = forward;
        this.backward = backward;
        this.attack = attack;
    }
}
