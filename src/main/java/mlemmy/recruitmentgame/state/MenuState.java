package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

public class MenuState implements State {

    @Override
    public State handleInput(KeyEvent key) {
        return new PlayState();
    }

    @Override
    public void displayOutput(Display display) {
        display.write("Press enter to start");
    }
}
