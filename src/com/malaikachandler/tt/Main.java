package com.malaikachandler.tt;

import com.malaikachandler.tt.carddata.CardData;
import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.graphics.TerminalColor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Testing

        GameBoard gb = new GameBoard();
        Player p1 = new Player("Player1", TerminalColor.ANSI_BLUE);
        Player p2 = new Player("Player2", TerminalColor.ANSI_RED);
        System.out.println(gb.toString());

        ArrayList<Card> cards = CardData.getInstance().getCardsAtLevel(6);

        ArrayList<Card> hand1 = new ArrayList<>();
        ArrayList<Card> hand2 = new ArrayList<>();
        for (int i = 0; i < cards.size() - 1; i++) {
            if (i % 2 == 0) {
                hand1.add(cards.get(i));
            } else {
                hand2.add(cards.get(i));
            }
        }

        p1.setHand(hand1);
        p2.setHand(hand2);

//        for (Card card : cards) {
//            System.out.println(card.getName());
//        }

        p1.printHand();
        gb.printGameBoard();
        p2.printHand();
        System.out.println();
        System.out.println();
        System.out.println();

//        gb.placeCard(p1, 0, 0, cards.get(4));
        gb.placeCard(p1, 0, 0, p1.popCard(0));
        p1.printHand();
        gb.printGameBoard();
        p2.printHand();
        System.out.println();
        System.out.println();
        System.out.println();

//        gb.placeCard(p2, 1, 1, cards.get(5));
        gb.placeCard(p2, 1, 1, p2.popCard(0));
        p1.printHand();
        gb.printGameBoard();
        p2.printHand();
        System.out.println();
        System.out.println();
        System.out.println();

//        gb.placeCard(p1, 2, 2, cards.get(2));
        gb.placeCard(p1, 2, 2, p1.popCard(0));
        p1.printHand();
        gb.printGameBoard();
        p2.printHand();
        System.out.println();
        System.out.println();
        System.out.println();

//        gb.placeCard(p2, 1, 2, cards.get(7));
        gb.placeCard(p2, 1, 2, p2.popCard(0));
        p1.printHand();
        gb.printGameBoard();
        p2.printHand();
        System.out.println();
        System.out.println();
        System.out.println();

//        System.out.println(gb.toString());
    }
}
