package mlemmy.recruitmentgame;

import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.display.SwingDisplay;
import mlemmy.recruitmentgame.state.MenuState;
import mlemmy.recruitmentgame.state.State;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private State state;
    private final Display display;

    public Game() {
        display = new SwingDisplay(this);
        state = new MenuState();
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

