package mlemmy.recruitmentgame.save;

import mlemmy.recruitmentgame.state.PlayState;

import java.io.*;

public class FileSaveSystem implements GameSaveSystem {

    private final String saveFileName;

    public FileSaveSystem(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    @Override
    public void saveGame(PlayState game) {
        try {
            FileOutputStream fileOut = new FileOutputStream(saveFileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(game);
            objectOut.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public Boolean saveExists() {
        return new File(saveFileName).exists();
    }

    @Override
    public PlayState loadGame() throws SaveDoesNotExist {
        try {
            FileInputStream fileIn = new FileInputStream(saveFileName);
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
