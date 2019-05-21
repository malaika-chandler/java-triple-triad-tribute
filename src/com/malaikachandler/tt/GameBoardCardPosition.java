package com.malaikachandler.tt;

import java.util.HashMap;
import java.util.Map;

public class GameBoardCardPosition {

    private Card card;
    private Elemental element = null;
    private Map<Position, GameBoardCardPosition> adjacentCards = new HashMap<>();
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

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }

    public void setCard(Player p, Card card) {
        this.ownedBy = p;
        this.card = card;
        this.flipAdjacent();
    }

    public void setAbove(GameBoardCardPosition g) {
        this.adjacentCards.put(Position.TOP, g);
    }

    public void setLeft(GameBoardCardPosition g) {
        this.adjacentCards.put(Position.LEFT, g);
    }

    public void setRight(GameBoardCardPosition g) {
        this.adjacentCards.put(Position.RIGHT, g);
    }

    public void setBottom(GameBoardCardPosition g) {
        this.adjacentCards.put(Position.BOTTOM, g);
    }

    public GameBoardCardPosition getNeighbor(Position position) {
        return adjacentCards.get(position);
    }

    public Elemental getElement() {
        return element;
    }

    public void setElement(Elemental element) {
        this.element = element;
    }

    public void flipAdjacent() {
        this.adjacentCards.forEach((Position neighborPosition, GameBoardCardPosition neighbor) -> {
            if (neighbor != null && neighbor.ownedBy != this.ownedBy && neighbor.getCard() != null) {
                Position selfPosition = neighborPosition;
                if (this.getCard().getRank(selfPosition) > neighbor.getCard().getRank(neighborPosition.getOpposite())) {
                    neighbor.setOwnedBy(this.ownedBy);
                }
            }
        });
    }
}
