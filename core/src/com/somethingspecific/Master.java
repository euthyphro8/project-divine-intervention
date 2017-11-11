package com.somethingspecific;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.somethingspecific.framework.State;
import com.somethingspecific.framework.ScreenManager;
import com.somethingspecific.framework.GameManager;
import com.somethingspecific.framework.MenuManager;
import com.somethingspecific.graphics.SpriteSheet;
import com.somethingspecific.input.InputManager;

public class Master extends ApplicationAdapter {

	public static State state;

	public GameManager game;
	public ScreenManager screen;
	public MenuManager menu;

	@Override
	public void create () {
		state = State.MENU;
		SpriteSheet.init();
		InputManager.init();
		screen = new ScreenManager();
		game = new GameManager(screen);
		menu = new MenuManager();

	}


	public void update() {
		InputManager.update();
		if(Gdx.input.isButtonPressed(Input.Keys.ESCAPE)) {
			state = State.EXITING;
		}else if(state == State.MENU) {
			menu.update();
		}else if(state == State.GAME) {
			game.update();
		}else if(state == State.EXITING) {
			Gdx.app.exit(	);
		}
	}

	@Override
	public void render () {
		update();
		screen.start();
		if(state == State.MENU) {
			Gdx.gl20.glClearColor(0.4f, 0.13f, 0.14f, 1.0f);
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
