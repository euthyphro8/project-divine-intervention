package com.somethingspecific;

import com.badlogic.gdx.ApplicationAdapter;
import com.somethingspecific.framework.State;

public class Master extends ApplicationAdapter {


	public static State state;

	@Override
	public void create () {
		state = State.LOADING;
	}



	public void update() {
		if(state == State.LOADING) {

		}else if(state == State.MENU) {

		}else if(state == State.GAME) {

		}else if(state == State.EXITING) {

		}
	}

	@Override
	public void render () {
		update();


		if(state == State.LOADING) {

		}else if(state == State.MENU) {

		}else if(state == State.GAME) {

		}else if(state == State.EXITING) {

		}



	}
	
	@Override
	public void dispose () {
	}
}
