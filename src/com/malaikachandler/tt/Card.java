package com.malaikachandler.tt;

public class Card {

    private final String name;
    private final int top;
    private final int left;
    private final int right;
    private final int bottom;

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

    public Elemental getElement() {
        return element;
    }
}
