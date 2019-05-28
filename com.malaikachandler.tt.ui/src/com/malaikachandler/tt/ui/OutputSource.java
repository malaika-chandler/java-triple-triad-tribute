package com.malaikachandler.tt.ui;

import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.Player;

public interface OutputSource {
    void notifyTurn(Player player);
    void handleGameBoard(GameBoard gameBoard);
    void showPlayerHand(Player player);
    void indicateCardOptions(Player player);
    void handlePlayerScores(Player[] players);
    void handleGetInitialPlayerDataPrompt(int index);
    void displayEndGame(Player[] players);
}
