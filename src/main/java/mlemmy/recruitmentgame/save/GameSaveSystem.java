package mlemmy.recruitmentgame.save;

import mlemmy.recruitmentgame.state.PlayState;

import java.io.Serializable;

public interface GameSaveSystem extends Serializable {

    void saveGame(PlayState game);

    Boolean saveExists();

    PlayState loadGame() throws SaveDoesNotExist;

}
