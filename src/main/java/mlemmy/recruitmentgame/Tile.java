package mlemmy.recruitmentgame;

public enum Tile {

    GROUND('.'),
    WALL('#'),
    OUT_OF_BOUNDS('x');

    private final char symbol;

    Tile(char symbol) {
        this.symbol = symbol;
    }

    public char symbol() {
        return symbol;
    }
}
