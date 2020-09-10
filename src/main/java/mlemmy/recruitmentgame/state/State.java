package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

public interface State {

    State handleInput(KeyEvent key);

    void displayOutput(Display display);

}
