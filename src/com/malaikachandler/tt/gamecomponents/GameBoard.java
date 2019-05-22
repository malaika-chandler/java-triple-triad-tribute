package com.malaikachandler.tt.gamecomponents;

import com.malaikachandler.tt.Player;
import com.malaikachandler.tt.graphics.TerminalGraphics;

import java.util.Arrays;
import java.util.List;

public class GameBoard {

    private GameBoardCardPosition[][] gameBoard;
    private int occupiedSpaces = 0;

    public GameBoard() {

        this.gameBoard = new GameBoardCardPosition[][] {
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() },
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() },
                { new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition() }
        };

        for (int row = 0; row < GameConstants.BOARD_WIDTH; row++) {
            for (int col = 0; col < GameConstants.BOARD_HEIGHT; col++) {
                GameBoardCardPosition g = this.gameBoard[row][col];
                if (row > 0) {
                    g.setRank(Position.TOP, gameBoard[row - 1][col]);
                }
                if (row < GameConstants.BOARD_HEIGHT - 1) {
                    g.setRank(Position.BOTTOM, gameBoard[row + 1][col]);
                }
                if (col > 0) {
                    g.setRank(Position.LEFT, gameBoard[row][col - 1]);
                }
                if (col < GameConstants.BOARD_WIDTH - 1) {
                    g.setRank(Position.RIGHT, gameBoard[row][col + 1]);
                }
            }
        }
    }

    public boolean placeCard(Player p, int row, int col, Card card) {
        if (this.isValidRowCol(row, col)) {
            if (gameBoard[row][col].getCard() == null) {
                System.out.println("Player " + p.getName() + " places " + card.getName() + " at row " + row + " and col " + col);
                gameBoard[row][col].setCard(p, card);
                occupiedSpaces++;
                return true;
            }
        }
        return false;
    }

    private boolean isValidRowCol(int row, int col) {
        return row < GameConstants.BOARD_HEIGHT && row >= 0
                && col < GameConstants.BOARD_WIDTH && col >= 0;
    }

    public List<GameBoardCardPosition> getRow(int row) {
        return Arrays.asList(gameBoard[row]);
    }

    public void printGameBoard() {
        TerminalGraphics.printCardRow(this.getRow(0), 0);
        TerminalGraphics.printCardRow(this.getRow(1), 1);
        TerminalGraphics.printCardRow(this.getRow(2), 2);
    }

    public boolean hasEmptySpaces() {
        return occupiedSpaces != GameConstants.TOTAL_BOARD_SPACES;
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
