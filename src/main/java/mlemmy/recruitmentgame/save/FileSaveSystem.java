package mlemmy.recruitmentgame.save;

import mlemmy.recruitmentgame.state.PlayState;

import java.io.*;

public class FileSaveSystem implements GameSaveSystem {

    public static final String SAVE_FILE = "savegame";

    @Override
    public void saveGame(PlayState game) {
        try {
            FileOutputStream fileOut = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(game);
            objectOut.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public Boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }

    @Override
    public PlayState loadGame() throws SaveDoesNotExist {
        try {
            FileInputStream fileIn = new FileInputStream(SAVE_FILE);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            PlayState obj = (PlayState) objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (Exception e) {
            System.err.println(e);
        }
        throw new SaveDoesNotExist();
    }
}
