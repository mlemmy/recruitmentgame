package mlemmy.recruitmentgame.entities;

import mlemmy.recruitmentgame.Tile;
import mlemmy.recruitmentgame.World;

public class Player {

    public static final char PLAYER_SYMBOL = '@';

    public int w;
    public int h;

    private final World world;

    public Player(int startingWidth, int startingHeight, World world) {
        this.w = startingWidth;
        this.h = startingHeight;
        this.world = world;
    }

    public char symbol() {
        return PLAYER_SYMBOL;
    }

    public void move(int w, int h) {
        if (world.tile(this.h + h, this.w + w) == Tile.GROUND) {
            this.w += w;
            this.h += h;
        }
    }

}
