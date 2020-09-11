package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

public class CreateCharacterState implements GameState {

    private StringBuilder characterName = new StringBuilder();

    @Override
    public GameState handleInput(KeyEvent key) {
        if (key.getKeyCode() >= KeyEvent.VK_A && key.getKeyCode() <= KeyEvent.VK_Z) {
            characterName.append(key.getKeyChar());
        }
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            return new PlayState(characterName.toString(), 20, 60);
        }
        return this;
    }

    @Override
    public void displayOutput(Display display) {
        display.write("Enter your character name and press ENTER: " + characterName.toString());
    }
}
