package mlemmy.recruitmentgame;

import java.io.Serializable;

public class World implements Serializable {

    private final int height;
    private final int width;
    private final Tile[][] tiles;

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

    public int height() {
        return height;
    }

    public int width() {
        return width;
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
        return new World(tiles);
    }

}
