package com.malaikachandler.tt.userinput;

import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.Player;

public interface InputSource {

    void quitGame();

    String getName();

    void playerTurn(GameBoard gameBoard, Player player);


}
