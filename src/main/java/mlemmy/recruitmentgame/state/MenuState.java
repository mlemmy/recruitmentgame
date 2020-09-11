package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

public class MenuState implements GameState {

    @Override
    public GameState handleInput(KeyEvent key) {
        return new PlayState(20, 60);
    }

    @Override
    public void displayOutput(Display display) {
        display.write("Press enter to start");
    }
}
