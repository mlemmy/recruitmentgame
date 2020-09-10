package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

class PlayState implements State {

    char[][] state = new char[21][80];

    @Override
    public State handleInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        return this;
    }

    @Override
    public void displayOutput(Display display) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                state[i][j] = '.';
                sb.append(state[i][j]);
            }
            sb.append('\n');
        }
        display.write(sb.toString());
    }
}
