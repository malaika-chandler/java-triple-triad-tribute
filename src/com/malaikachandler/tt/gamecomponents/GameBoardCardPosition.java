package com.malaikachandler.tt.gamecomponents;

import java.util.HashMap;
import java.util.Map;

public class GameBoardCardPosition {

    private Card card;
    private Elemental element = null;
    private Map<Position, GameBoardCardPosition> adjacentCards = new HashMap<>();
    private Player ownedBy;

    GameBoardCardPosition() {
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

    public Map<Position, GameBoardCardPosition> getNeighbors() {
        return this.adjacentCards;
    }

    public void setNeighbor(Position position, GameBoardCardPosition gp) {
        this.adjacentCards.put(position, gp);
    }

    public Elemental getElement() {
        return element;
    }

    public void setElement(Elemental element) {
        this.element = element;
    }
}
