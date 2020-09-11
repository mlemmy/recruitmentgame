package mlemmy.recruitmentgame.entities;

import java.io.Serializable;

public class Creature implements Serializable {

    private static final char TROLL_SYMBOL = 't';
    public static final int TROLL_EXP = 1000;

    public int w;
    public int h;

    public Creature(int w, int h) {
        this.w = w;
        this.h = h;
    }

    public char symbol() {
        return TROLL_SYMBOL;
    }

    public int experience() {
        return TROLL_EXP;
    }
}
