package mlemmy.recruitmentgame.world;

import mlemmy.recruitmentgame.entities.Creature;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class World implements Serializable {

    private final int height;
    private final int width;
    private final Tile[][] tiles;
    private final List<Creature> creatures = new ArrayList<>();

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.height = tiles.length;
        this.width = tiles[0].length;
    }

    public Tile tile(int h, int w) {
        if (h >= 0 && h < height && w >= 0 && w < width) {
            return tiles[h][w];
        } else {
            return Tile.OUT_OF_BOUNDS;
        }
    }

    public Creature creatureAt(int h, int w) {
        for (Creature creature : creatures) {
            if (creature.w == w && creature.h == h) {
                return creature;
            }
        }
        return null;
    }

    public void addCreature(Creature creature) {
        creatures.add(creature);
    }

    public void remove(Creature creatureToRemove) {
        creatures.remove(creatureToRemove);
    }

    public static World staticWorld() {
        Tile[][] tiles = new Tile[10][20];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (i == 0 || i == tiles.length - 1 || j == 0 || j == tiles[i].length - 1) {
                    tiles[i][j] = Tile.WALL;
                } else {
                    tiles[i][j] = Tile.GROUND;
                }
            }
        }
        World world = new World(tiles);
        world.addCreature(new Creature(2, 2));
        world.addCreature(new Creature(6, 6));
        world.addCreature(new Creature(4, 8));
        return world;
    }
}
