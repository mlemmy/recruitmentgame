package mlemmy.recruitmentgame.entities;

import mlemmy.recruitmentgame.world.Tile;
import mlemmy.recruitmentgame.world.World;

import java.io.Serializable;

public class Player implements Serializable {

    public static final char PLAYER_SYMBOL = '@';

    public int w;
    public int h;

    private String name;
    private final World world;
    private int experience;

    public Player(String name, int startingWidth, int startingHeight, World world) {
        this.name = name;
        this.w = startingWidth;
        this.h = startingHeight;
        this.world = world;
    }

    public String name() {
        return name;
    }

    public int experience() {
        return experience;
    }

    public char symbol() {
        return PLAYER_SYMBOL;
    }

    public void move(int w, int h) {
        if (world.creatureAt(this.h + h, this.w + w) != null) {
            attack(w, h);
        } else if (world.tile(this.h + h, this.w + w) == Tile.GROUND) {
            this.w += w;
            this.h += h;
        }
    }

    private void attack(int w, int h) {
        Creature creatureToKill = world.creatureAt(this.h + h, this.w + w);
        this.experience += creatureToKill.experience();
        world.remove(creatureToKill);
    }

}
