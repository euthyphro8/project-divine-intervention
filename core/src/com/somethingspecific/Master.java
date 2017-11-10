package com.somethingspecific;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.State;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.framework.GameManager;
import com.somethingspecific.framework.LoadManager;
import com.somethingspecific.framework.MenuManager;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.InputManager;

public class Master extends ApplicationAdapter {





	public static State state;

	public GameManager game;
	public ScreenManager screen;
	public LoadManager load;
	public MenuManager menu;



	@Override
	public void create () {
		state = State.GAME;
		SpriteSheet.init();
		InputManager.init();
		screen = new ScreenManager();
		game = new GameManager(load);
		load = new LoadManager();
		menu = new MenuManager();

	}



	public void update() {
		InputManager.update();

		if(state == State.LOADING) {
			load.update();
		}else if(state == State.MENU) {
			menu.update();
		}else if(state == State.GAME) {
			game.update();
		}else if(state == State.EXITING) {
			Gdx.app.exit();
		}
	}

	@Override
	public void render () {
		update();



		screen.start();

		if(state == State.LOADING) {
			load.render(screen);
		}else if(state == State.MENU) {
			menu.render(screen);
		}else if(state == State.GAME) {
			game.render(screen);
		}
		screen.stop();

	}
	
	@Override
	public void dispose () {
	}
}
