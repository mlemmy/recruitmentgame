package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MenuState implements GameState {

    @Override
    public GameState handleInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new PlayState(20, 60);
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
        if (!new File("savegame").exists()) {
            return this;
        }
        try {
            FileInputStream fileIn = new FileInputStream("savegame");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            PlayState obj = (PlayState) objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (Exception e) {
            System.err.println(e);
        }
        throw new RuntimeException("No game save");
    }
}
