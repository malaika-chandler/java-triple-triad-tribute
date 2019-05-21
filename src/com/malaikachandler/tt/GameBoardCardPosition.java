package com.malaikachandler.tt;

import java.util.HashMap;
import java.util.Map;

public class GameBoardCardPosition {

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

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setCard(Player p, Card card) {
        this.ownedBy = p;
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
