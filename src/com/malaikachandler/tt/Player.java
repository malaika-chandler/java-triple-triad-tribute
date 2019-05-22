package com.malaikachandler.tt;


import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameConstants;
import com.malaikachandler.tt.graphics.TerminalGraphics;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private String color;
    private int score;

    private List<Card> hand;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.hand = new ArrayList<>();
        this.score = GameConstants.INITIAL_SCORE;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void decremementScore() {
        this.score--;
    }

    public List<Card> getHand() {
        return hand;
    }

    public Card popCard(int index) {
        return this.hand.remove(index);
    }

    public void setHand(List<Card> dealtHand) {
        this.hand = dealtHand;
    }

    public void printHand() {
        TerminalGraphics.printPlayerHand(this);
    }
}
