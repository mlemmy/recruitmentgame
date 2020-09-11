package mlemmy.recruitmentgame;

import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.display.SwingDisplay;
import mlemmy.recruitmentgame.save.FileSaveSystem;
import mlemmy.recruitmentgame.save.GameSaveSystem;
import mlemmy.recruitmentgame.state.GameState;
import mlemmy.recruitmentgame.state.MenuState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private GameState state;
    private final Display display;

    public Game() {
        GameSaveSystem saveSystem = new FileSaveSystem("savegame");
        display = new SwingDisplay(this);
        state = new MenuState(saveSystem);
        state.displayOutput(display);
    }

    public static void main(String[] args) {
        new Game();
    }

    private void repaint() {
        display.clear();
        state.displayOutput(display);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        state = state.handleInput(e);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

