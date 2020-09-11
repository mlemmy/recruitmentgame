package mlemmy.recruitmentgame.state;

import mlemmy.recruitmentgame.display.Display;
import mlemmy.recruitmentgame.entities.Player;
import mlemmy.recruitmentgame.save.GameSaveSystem;
import mlemmy.recruitmentgame.world.World;

import java.awt.event.KeyEvent;
import java.io.Serializable;

public class PlayState implements GameState, Serializable {

    private final int displayWidth;
    private final int displayHeight;

    private final GameSaveSystem saveSystem;
    private final World world;
    private final Player player;

    PlayState(String playerName, int displayHeight, int displayWidth, GameSaveSystem saveSystem) {
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
        this.saveSystem = saveSystem;
        world = World.staticWorld();
        player = new Player(playerName, 1, 1, world);
    }

    @Override
    public GameState handleInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                player.move(0, 1);
                break;
            case KeyEvent.VK_UP:
                player.move(0, -1);
                break;
            case KeyEvent.VK_LEFT:
                player.move(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                player.move(1, 0);
                break;
            case KeyEvent.VK_S:
                saveGame();
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
                if (i == displayHeight / 2 && j == displayWidth / 2) {
                    sb.append(player.symbol());
                } else if (world.creatureAt(i + player.h - displayHeight / 2, j + player.w - displayWidth / 2) != null) {
                    char symbol = world.creatureAt(i + player.h - displayHeight / 2, j + player.w - displayWidth / 2).symbol();
                    sb.append(symbol);
                } else {
                    char symbol = world.tile(i + player.h - displayHeight / 2, j + player.w - displayWidth / 2).symbol();
                    sb.append(symbol);
                }
            }
            sb.append('\n');
        }
        sb.append("Character: ").append(player.name()).append("\n");
        sb.append("Experience: ").append(player.experience()).append("\n");
        sb.append("Press S to save game, ESC to exit");
        display.write(sb.toString());
    }

    private void saveGame() {
        saveSystem.saveGame(this);
    }
}
