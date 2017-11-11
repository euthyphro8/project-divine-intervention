package com.somethingspecific.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CharacterSheet {

    public TextureRegion[] idle, forward, backward, attack, in, out;

    public CharacterSheet(TextureRegion[] idle, TextureRegion[] forward, TextureRegion[] backward, TextureRegion[] attack, TextureRegion[] in, TextureRegion[] out) {
        this.idle = idle;
        this.forward = forward;
        this.backward = backward;
        this.attack = attack;
        this.in = in;
        this.out = out;
    }
}
