package com.malaikachandler.tt;


import com.malaikachandler.tt.graphics.TerminalGraphics;

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

    public Card popCard(int index) {
        return this.hand.remove(index);
    }

    public void setHand(ArrayList<Card> dealtHand) {
        this.hand = dealtHand;
    }

    public void printHand() {
        TerminalGraphics.printPlayerHand(this);
    }
}
