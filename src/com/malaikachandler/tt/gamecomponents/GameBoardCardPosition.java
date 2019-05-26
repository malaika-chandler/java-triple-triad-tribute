package com.malaikachandler.tt.gamecomponents;

import java.util.HashMap;
import java.util.Map;

public class GameBoardCardPosition {

    private Card card;
    private Elemental element = null;
    private Map<Position, GameBoardCardPosition> adjacentCards = new HashMap<>();
    private Player ownedBy;

    public GameBoardCardPosition() {
        this.setNeighbor(Position.TOP, null);
        this.setNeighbor(Position.LEFT, null);
        this.setNeighbor(Position.RIGHT, null);
        this.setNeighbor(Position.BOTTOM, null);
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
    }

    public void setNeighbor(Position position, GameBoardCardPosition gp) {
        this.adjacentCards.put(position, gp);
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

    // TODO: 2019-05-21 Add checks for other rules in the future
    public void flipAdjacent() {
        this.adjacentCards.forEach((Position neighborPosition, GameBoardCardPosition neighbor) -> {
            if (neighbor != null && neighbor.ownedBy != this.ownedBy && neighbor.getCard() != null) {
                if (this.getCard().getRank(neighborPosition) > neighbor.getCard().getRank(neighborPosition.getOpposite())) {
                    neighbor.getOwnedBy().decrementScore();
                    neighbor.setOwnedBy(this.ownedBy);
                    this.ownedBy.incrementScore();

                    // TODO: 2019-05-26 Get this outta here
                    System.out.println(" flipping " + neighbor.getCard().getName());
                }
            }
        });
    }
}
