package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.World;
import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.entities.Player;

import java.awt.event.KeyEvent;

class PlayState implements GameState {

    private final int displayWidth;
    private final int displayHeight;

    private final World world;
    private final Player player;

    PlayState(int displayHeight, int displayWidth) {
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
        world = World.staticWorld();
        player = new Player(1, 1, world);
    }

    @Override
    public GameState handleInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                player.move(0, 1);
                break;
            case KeyEvent.VK_DOWN:
                player.move(0, -1);
                break;
            case KeyEvent.VK_RIGHT:
                player.move(-1, 0);
                break;
            case KeyEvent.VK_LEFT:
                player.move(1, 0);
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
                    sb.append(player.symbol());
                } else {
                    char symbol = world.tile(i + player.h - displayHeight/2, j + player.w - displayWidth/2).symbol();
                    sb.append(symbol);
                }
            }
            sb.append('\n');
        }
        display.write(sb.toString());
    }
}
