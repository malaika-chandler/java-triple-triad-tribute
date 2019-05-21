package com.malaikachandler.tt;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final String name;
    private final int top;
    private final int left;
    private final int right;
    private final int bottom;

    Map<Position, Integer> ranks;

    private final Elemental element;
    private final int level;

    public Card(String name, int top, int left, int right, int bottom, Elemental element, int level) {
        this.name = name;
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.element = element;
        this.level = level;

        this.ranks = new HashMap<>();
        this.ranks.put(Position.TOP, top);
        this.ranks.put(Position.LEFT, left);
        this.ranks.put(Position.RIGHT, right);
        this.ranks.put(Position.BOTTOM, bottom);
    }

    public String getName() {
        return name;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getRank(Position position) {
        return ranks.get(position);
    }

    public Elemental getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }
}
