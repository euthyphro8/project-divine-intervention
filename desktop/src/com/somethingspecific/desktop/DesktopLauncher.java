package com.somethingspecific.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.somethingspecific.Master;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Master(), config);
		config.width = 1920;
		config.height = 1080;

		config.fullscreen = true;
		config.title = "Divine Intervention";
	}
}
