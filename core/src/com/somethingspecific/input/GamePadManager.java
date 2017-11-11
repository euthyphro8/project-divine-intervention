package com.somethingspecific.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;


public class GamePadManager implements ControllerListener{

    private int count;
    private Controller[] pads;

    public GamePadManager() {
        Controllers.addListener(this);

        count = Controllers.getControllers().size;
        pads = new Controller[2];
        for(int i = 0; i < count; i++) {
            if(i > 1) break;
            pads[i] = Controllers.getControllers().get(i);
         }
    }




    @Override
    public boolean buttonDown(Controller controller, int buttonCode) {
        if(controller == pads[0]) {
            if(buttonCode == 0){
                InputManager.jump[0] = true;
            }

        }else if(controller == pads[1]) {
            if(buttonCode == 0){
                InputManager.jump[1] = true;
            }

        }
        return true;
    }
    @Override
    public boolean buttonUp(Controller controller, int buttonCode) {
        if(controller == pads[0]) {
            if(buttonCode == 0){
                InputManager.jump[0] = false;
            }

        }else if(controller == pads[1]) {
            if(buttonCode == 0){
                InputManager.jump[1] = false;
            }

        }
        return true;
    }
    @Override
    public boolean axisMoved(Controller controller, int axisCode, float value) {
        //Controller 1
        if(controller == pads[0]) {
            if(axisCode == 1) {
                if(Math.abs(value) < 0.3) InputManager.horizontal[0] = 0;
                else InputManager.horizontal[0] = value;
            }
            // Trigger
            if(axisCode ==4){
                if(Math.abs(value) < 0.3) InputManager.trigger[0] = 0;
                else InputManager.trigger[0] = value;
            }
        }
        //Controller 2
        else if(controller == pads[1]) {
            if(axisCode == 1) {
                if(Math.abs(value) < 0.3) InputManager.horizontal[1] = 0;
                else InputManager.horizontal[1] = value;
            }
            // Trigger
            if(axisCode ==4){
                if(Math.abs(value) < 0.3) InputManager.trigger[1] = 0;
                else InputManager.trigger[1] = value;
            }
        }
        return true;
    }
    @Override
    public boolean povMoved(Controller controller, int povCode, PovDirection value) {
        if(controller == pads[0]) {

        }else if(controller == pads[1]) {

        }
        return true;
    }










    @Override
    public void connected(Controller controller) {
    }
    @Override
    public void disconnected(Controller controller) {

    }
    @Override
    public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }
    @Override
    public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
        return false;
    }
    @Override
    public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
        return false;
    }
}
