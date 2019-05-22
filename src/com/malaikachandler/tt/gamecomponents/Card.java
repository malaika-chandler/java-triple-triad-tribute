package com.malaikachandler.tt.gamecomponents;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private final String name;
    private final Elemental element;
    private final int level;

    private Map<Position, Integer> ranks;


    public Card(String name, int top, int left, int right, int bottom, Elemental element, int level) {
        this.name = name;
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
