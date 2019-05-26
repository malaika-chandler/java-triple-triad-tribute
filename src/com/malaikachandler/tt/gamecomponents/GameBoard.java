package com.malaikachandler.tt.gamecomponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {

    private GameBoardCardPosition[][] gameBoard;
    private int occupiedSpaces = 0;

    public GameBoard() {

        this.gameBoard = new GameBoardCardPosition[GameConstants.BOARD_HEIGHT][GameConstants.BOARD_WIDTH];
        for (int i = 0; i < GameConstants.BOARD_HEIGHT; i++) {
            for (int j = 0; j < GameConstants.BOARD_WIDTH; j++) {
                this.gameBoard[i][j] = new GameBoardCardPosition();
            }
        }

        for (int row = 0; row < GameConstants.BOARD_HEIGHT; row++) {
            for (int col = 0; col < GameConstants.BOARD_WIDTH; col++) {
                GameBoardCardPosition g = this.gameBoard[row][col];
                if (row > 0) {
                    g.setNeighbor(Position.TOP, gameBoard[row - 1][col]);
                }
                if (row < GameConstants.BOARD_HEIGHT - 1) {
                    g.setNeighbor(Position.BOTTOM, gameBoard[row + 1][col]);
                }
                if (col > 0) {
                    g.setNeighbor(Position.LEFT, gameBoard[row][col - 1]);
                }
                if (col < GameConstants.BOARD_WIDTH - 1) {
                    g.setNeighbor(Position.RIGHT, gameBoard[row][col + 1]);
                }
            }
        }
    }

    public boolean placeCard(Player p, int row, int col, Card card) {
        if (this.isValidRowCol(row, col)) {
            if (gameBoard[row][col].getCard() == null) {
                gameBoard[row][col].setCard(p, card);

                flipAdjacentGamePositions(gameBoard[row][col]);
                occupiedSpaces++;
                return true;
            }
        }

        return false;
    }

    public List<Integer> availableColumnIndexesInRow(int row) {
        List<Integer> availableColIndexes = new ArrayList<>();
        for (int i = 0; i < this.gameBoard[row].length; i++) {
            if (this.gameBoard[row][i].getCard() == null) {
                availableColIndexes.add(i);
            }
        }
        return availableColIndexes;
    }

    // TODO: 2019-05-21 Add checks for other rules in the future
    private void flipAdjacentGamePositions(GameBoardCardPosition position) {
        position.getNeighbors().forEach((Position neighborPosition, GameBoardCardPosition neighbor) -> {
            if (neighbor != null && neighbor.getOwnedBy() != position.getOwnedBy() && neighbor.getCard() != null) {
                if (position.getCard().getRank(neighborPosition) > neighbor.getCard().getRank(neighborPosition.getOpposite())) {
                    neighbor.getOwnedBy().decrementScore();
                    neighbor.setOwnedBy(position.getOwnedBy());
                    position.getOwnedBy().incrementScore();

                    // TODO: 2019-05-26 Get this outta here
                    System.out.println(" flipping " + neighbor.getCard().getName());
                }
            }
        });
    }

    private boolean isValidRowCol(int row, int col) {
        return row < GameConstants.BOARD_HEIGHT && row >= 0
                && col < GameConstants.BOARD_WIDTH && col >= 0;
    }

    public List<GameBoardCardPosition> getRow(int row) {
        return Arrays.asList(gameBoard[row]);
    }

    public boolean hasEmptySpaces() {
        return occupiedSpaces != GameConstants.TOTAL_BOARD_SPACES;
    }

}
