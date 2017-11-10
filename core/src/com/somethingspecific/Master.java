package com.somethingspecific;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.somethingspecific.framework.State;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.framework.GameManager;
import com.somethingspecific.framework.LoadManager;
import com.somethingspecific.framework.MenuManager;
import com.somethingspecific.graphics.SpriteSheet;

public class Master extends ApplicationAdapter {





	public static State state;

	public GameManager game;
	public ScreenManager screen;
	public LoadManager load;
	public MenuManager menu;



	@Override
	public void create () {
		state = State.GAME;
		screen = new ScreenManager();
		game = new GameManager(load);
		load = new LoadManager();
		menu = new MenuManager();

		SpriteSheet.init();
	}



	public void update() {
		if(state == State.LOADING) {
			load.update();
		}else if(state == State.MENU) {
			menu.update();
		}else if(state == State.GAME) {
			game.update();
		}else if(state == State.EXITING) {

		}
	}

	@Override
	public void render () {
		update();



		screen.start();
		screen.render(SpriteSheet.bigHead, 150, 150);

		if(state == State.LOADING) {

		}else if(state == State.MENU) {

		}else if(state == State.GAME) {

		}else if(state == State.EXITING) {

		}
		screen.stop();

	}
	
	@Override
	public void dispose () {
	}
}
