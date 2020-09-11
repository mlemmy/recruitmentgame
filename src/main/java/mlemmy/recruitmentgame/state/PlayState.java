package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.World;
import mlemmy.recruitmentgame.display.Display;

import java.awt.event.KeyEvent;

class PlayState implements GameState {

    private final int displayWidth;
    private final int displayHeight;

    private int centerH = 1;
    private int centerW = 1;

    private final World world;

    PlayState(int displayHeight, int displayWidth) {
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
        world = World.staticWorld();
    }

    @Override
    public GameState handleInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                scrollBy(0, 1);
                break;
            case KeyEvent.VK_DOWN:
                scrollBy(0, -1);
                break;
            case KeyEvent.VK_RIGHT:
                scrollBy(-1, 0);
                break;
            case KeyEvent.VK_LEFT:
                scrollBy(1, 0);
                break;
            default:
                break;
        }

        if (key.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        return this;
    }

    @Override
    public void displayOutput(Display display) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < displayHeight; i++) {
            for (int j = 0; j < displayWidth; j++) {
                if (i == displayHeight/2 && j == displayWidth/2) {
                    sb.append("@");
                } else {
                    char symbol = world.tile(i + centerH - displayHeight/2, j + centerW - displayWidth/2).symbol();
                    sb.append(symbol);
                }
            }
            sb.append('\n');
        }
        display.write(sb.toString());
    }

    private void scrollBy(int width, int height) {
        centerW = Math.max(0, Math.min(centerW + width, world.width() - 1));
        centerH = Math.max(0, Math.min(centerH + height, world.height() - 1));
    }
}
