package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.save.GameSaveSystem;

import java.awt.event.KeyEvent;

public class CreateCharacterState implements GameState {

    private final StringBuilder characterName = new StringBuilder();
    private final GameSaveSystem saveSystem;

    public CreateCharacterState(GameSaveSystem saveSystem) {
        this.saveSystem = saveSystem;
    }

    @Override
    public GameState handleInput(KeyEvent key) {
        if (key.getKeyCode() >= KeyEvent.VK_A && key.getKeyCode() <= KeyEvent.VK_Z) {
            characterName.append(key.getKeyChar());
        }
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            return new PlayState(characterName.toString(), 20, 60, saveSystem);
        }
        return this;
    }

    @Override
    public void displayOutput(Display display) {
        display.write("Enter your character name and press ENTER: " + characterName.toString());
    }
}
