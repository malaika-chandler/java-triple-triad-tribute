package com.malaikachandler.tt;

import com.malaikachandler.tt.graphics.TerminalGraphics;

import java.util.*;

public class GameBoard {

    private GameBoardCardPosition[][] gameBoard;

    public GameBoard() {
        this.gameBoard = new GameBoardCardPosition[][] {
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() },
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() },
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() }
        };

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                GameBoardCardPosition g = this.gameBoard[row][col];
                if (row > 0) {
                    g.setAbove(gameBoard[row - 1][col]);
                }
                if (row < 2) {
                    g.setBottom(gameBoard[row + 1][col]);
                }
                if (col > 0) {
                    g.setLeft(gameBoard[row][col - 1]);
                }
                if (col < 2) {
                    g.setRight(gameBoard[row][col + 1]);
                }
            }
        }
    }

    public boolean placeCard(Player p, int row, int col, Card card) {
        if (true) { // TODO make official check for row/col
            if (gameBoard[row][col].getCard() == null) {
                gameBoard[row][col].setCard(p, card);
                return true;
            }
        }
        return false;
    }

    public List<GameBoardCardPosition> getRow(int row) {
        return Arrays.asList(gameBoard[row]);
    }

    public void printGameBoard() {
        TerminalGraphics.printCardRow(this.getRow(0));
        TerminalGraphics.printCardRow(this.getRow(1));
        TerminalGraphics.printCardRow(this.getRow(2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameBoardCardPosition g = this.gameBoard[i][j];
                sb.append(g.toString() + " - ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
