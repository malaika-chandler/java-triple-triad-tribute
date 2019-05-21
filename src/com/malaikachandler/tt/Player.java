package com.malaikachandler.tt;


import java.util.ArrayList;

public class Player {

    private String name;
    private String color;
    private int score;

    private ArrayList<Card> hand;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
