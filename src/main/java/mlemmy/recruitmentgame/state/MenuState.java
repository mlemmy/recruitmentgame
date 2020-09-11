package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.save.GameSaveSystem;
import mlemmy.recruitmentgame.save.SaveDoesNotExist;

import java.awt.event.KeyEvent;

public class MenuState implements GameState {

    private final GameSaveSystem saveSystem;

    public MenuState(GameSaveSystem saveSystem) {
        this.saveSystem = saveSystem;
    }

    @Override
    public GameState handleInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new CreateCharacterState(saveSystem);
            case KeyEvent.VK_L:
                return loadGame();
        }

        return this;
    }

    @Override
    public void displayOutput(Display display) {
        String message = "Press enter to start" + "\n" + "Press L to load saved game";
        display.write(message);
    }

    private GameState loadGame() {
        try {
            return saveSystem.loadGame();
        } catch (SaveDoesNotExist saveDoesNotExist) {
            return this;
        }
    }
}
