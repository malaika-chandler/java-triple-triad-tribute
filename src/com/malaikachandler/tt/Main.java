package com.malaikachandler.tt;

import com.malaikachandler.tt.carddata.CardData;
import com.malaikachandler.tt.graphics.TerminalColor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Testing

        GameBoard gb = new GameBoard();
        Player p1 = new Player("Player1", TerminalColor.ANSI_BLUE);
        Player p2 = new Player("Player2", TerminalColor.ANSI_RED);
        System.out.println(gb.toString());

        ArrayList<Card> cards = CardData.getInstance().getCardsAtLevel(1);

        for (Card card : cards) {
            System.out.println(card.getName());
        }

        gb.printGameBoard();
        System.out.println();
        gb.placeCard(p1, 0, 0, cards.get(4));
        gb.printGameBoard();
        System.out.println();
        gb.placeCard(p2, 1, 1, cards.get(5));
        gb.printGameBoard();
        System.out.println();
        gb.placeCard(p1, 2, 2, cards.get(2));
        gb.printGameBoard();
        System.out.println();
        gb.placeCard(p2, 1, 2, cards.get(7));
        gb.printGameBoard();
        System.out.println();

//        System.out.println(gb.toString());
    }
}
