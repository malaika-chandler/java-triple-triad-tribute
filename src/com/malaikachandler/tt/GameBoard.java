package com.malaikachandler.tt;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    GameBoardCardPosition[] gameboard;

    public GameBoard() {
        this.gameboard = new GameBoardCardPosition[]{
                new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition(),
                new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition(),
                new GameBoardCardPosition(), new GameBoardCardPosition(), new GameBoardCardPosition()
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameBoardCardPosition g = this.gameboard[(3 * i) + j];
                if (i > 0) {
                    g.setAbove(gameboard[3  * (i - 1) + j]);
                }
                if (i < 2) {
                    g.setBottom(gameboard[3  * (i + 1) + j]);
                }
                if (j > 0) {
                    g.setLeft(gameboard[(3 * i) + j - 1]);
                }
                if (j < 2) {
                    g.setRight(gameboard[(3  * i) + j + 1]);
                }
            }
        }
    }

    public boolean placeCard(int x, int y, Card card) {
        int index = (x * 3) + y;
        if (gameboard.length > index) {
            if (gameboard[index].getCard() == null) {
                gameboard[index].setCard(card);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GameBoardCardPosition g = this.gameboard[(3 * i) + j];
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

        public GameBoardCardPosition() {
            this.setAbove(null);
            this.setLeft(null);
            this.setRight(null);
            this.setBottom(null);
            this.card = null;
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

        @Override
        public String toString() {
            return (this.card == null ? "EMPTY" : this.card.getName());
        }
    }
}
