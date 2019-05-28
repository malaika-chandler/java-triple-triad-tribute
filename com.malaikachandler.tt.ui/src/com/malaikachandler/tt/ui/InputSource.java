package com.malaikachandler.tt.ui;

import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.Player;

public interface InputSource {

    // TODO: 2019-05-26 Implement way to quit the program
//    void quitGame();
    String getName();
    void playerTurn(GameBoard gameBoard, Player player);
}
