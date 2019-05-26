package com.malaikachandler.tt.gamecomponents;


import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player>{

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

    @Override
    public int compareTo(Player player) {
        // Returns negative if player has larger score than comparison player
        return player.getScore() - this.getScore();
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

    public void decrementScore() {
        this.score--;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void popCard(Card card) {
        this.hand.remove(card);
    }

    public Card peekCard(int index) {
        return this.hand.get(index);
    }

    public void setHand(List<Card> dealtHand) {
        this.hand = dealtHand;
    }
}
