package mlemmy.recruitmentgame;

public class World {

    private final int height;
    private final int width;
    private final Tile[][] tiles;

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.height = tiles.length;
        this.width = tiles[0].length;
    }

    public Tile tile(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            return tiles[x][y];
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
        Tile[][] tiles = new Tile[50][100];
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
