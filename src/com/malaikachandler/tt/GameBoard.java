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

    public boolean placeCard(int row, int col, Card card) {
//        int index = (x * 3) + y;
        if (true) { // TODO make official check for row/col
            if (gameBoard[row][col].getCard() == null) {
                gameBoard[row][col].setCard(card);
                return true;
            }
        }
        return false;
    }

    public List<Card> getRow(int row) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int col = 0; col < gameBoard[row].length; col++) {
            cards.add(gameBoard[row][col].getCard());
        }
        return cards;
    }

    public void printGameBoard() {
        TerminalGraphics.printCardRowEx(this.getRow(0));
        TerminalGraphics.printCardRowEx(this.getRow(1));
        TerminalGraphics.printCardRowEx(this.getRow(2));
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

    private class GameBoardCardPosition {

        private Card card;
        private Elemental element = null;
        private Map<String, GameBoardCardPosition> adjacentCards = new HashMap<>();
        private Player ownedBy;

        public GameBoardCardPosition() {
            this.setAbove(null);
            this.setLeft(null);
            this.setRight(null);
            this.setBottom(null);
            this.card = null;
            this.ownedBy = null;
        }

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }

        public void setAbove(GameBoardCardPosition g) {
            this.adjacentCards.put("above", g);
        }

        public void setLeft(GameBoardCardPosition g) {
            this.adjacentCards.put("left", g);
        }

        public void setRight(GameBoardCardPosition g) {
            this.adjacentCards.put("right", g);
        }

        public void setBottom(GameBoardCardPosition g) {
            this.adjacentCards.put("bottom", g);
        }

        public GameBoardCardPosition getAbove() {
            return this.adjacentCards.get("above");
        }

        public GameBoardCardPosition getLeft() {
            return this.adjacentCards.get("left");
        }

        public GameBoardCardPosition getRight() {
            return this.adjacentCards.get("right");
        }

        public GameBoardCardPosition getBottom() {
            return this.adjacentCards.get("bottom");
        }

        public Elemental getElement() {
            return element;
        }

        public void setElement(Elemental element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return (this.card == null ? "EMPTY" : this.card.getName());
        }
    }
}
