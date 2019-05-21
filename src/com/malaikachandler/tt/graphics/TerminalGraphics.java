package com.malaikachandler.tt.graphics;

import com.malaikachandler.tt.Card;
import com.malaikachandler.tt.GameBoardCardPosition;
import com.malaikachandler.tt.carddata.CardData;

import java.util.ArrayList;
import java.util.List;

public class TerminalGraphics {

    public static void main(String[] args) {
        // testing

        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(CardData.getInstance().getCardsAtLevel(10).get(0));
        cards1.add(CardData.getInstance().getCardsAtLevel(10).get(5));
        cards1.add(CardData.getInstance().getCardsAtLevel(10).get(6));

        ArrayList<Card> cards2 = new ArrayList<>();
        cards2.add(null);
        cards2.add(null);
        cards2.add(null);

        ArrayList<Card> cards3 = new ArrayList<>();
        cards3.add(CardData.getInstance().getCardsAtLevel(10).get(0));
        cards3.add(CardData.getInstance().getCardsAtLevel(10).get(5));
        cards3.add(CardData.getInstance().getCardsAtLevel(10).get(6));

        printCardRowEx(cards2);
        printCardRowEx(cards2);
        printCardRowEx(cards2);
    }

    public static void printCardRow(List<GameBoardCardPosition> positions) {
        StringBuilder sb = new StringBuilder();
        int width = 5;
        int height = 4;

        for (int i = 0; i < height; i++) {
            for (GameBoardCardPosition gp : positions) {
                Card c = gp.getCard();
                String color = gp.getOwnedBy() == null ? TerminalColor.ANSI_RESET : gp.getOwnedBy().getColor();
                sb.append(color);
                for (int j = 0; j < width; j++) {

                    if (i == 0) {
                        sb.append("_");
                    }
                    if (i == 1) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 1:
                            case 3:
                                sb.append(" ");
                                break;
                            case 2:
                                if (c != null) {
                                    sb.append(c.getTop() == 10 ? "A" : c.getTop());
                                } else {
                                    sb.append(" ");
                                }

                                break;
                        }
                    }
                    if (i == 2) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 2:
                                sb.append(" ");
                                break;
                            case 3:
                                if (c != null) {
                                    sb.append(c.getRight() == 10 ? "A" : c.getRight());
                                } else {
                                    sb.append(" ");
                                }
                                break;
                            case 1:
                                if (c != null) {
                                    sb.append(c.getLeft() == 10 ? "A" : c.getLeft());
                                } else {
                                    sb.append(" ");
                                }
                                break;
                        }
                    }
                    if (i == 3) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 1:
                            case 3:
                                sb.append("_");
                                break;
                            case 2:
                                if (c != null) {
                                    sb.append(c.getBottom() == 10 ? "A" : c.getBottom());
                                } else {
                                    sb.append("_");
                                }
                                break;
                        }
                    }
                }
            }
            if (i != 3) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void printCardRowEx(List<Card> cards) {
        StringBuilder sb = new StringBuilder();
        int width = 5;
        int height = 4;

        for (int i = 0; i < height; i++) {
            for (Card c : cards) {
                for (int j = 0; j < width; j++) {

                    if (i == 0) {
                        sb.append("_");
                    }
                    if (i == 1) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 1:
                            case 3:
                                sb.append(" ");
                                break;
                            case 2:
                                if (c != null) {
                                    sb.append(c.getTop() == 10 ? "A" : c.getTop());
                                } else {
                                    sb.append(" ");
                                }

                                break;
                        }
                    }
                    if (i == 2) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 2:
                                sb.append(" ");
                                break;
                            case 3:
                                if (c != null) {
                                    sb.append(c.getRight() == 10 ? "A" : c.getRight());
                                } else {
                                    sb.append(" ");
                                }
                                break;
                            case 1:
                                if (c != null) {
                                    sb.append(c.getLeft() == 10 ? "A" : c.getLeft());
                                } else {
                                    sb.append(" ");
                                }
                                break;
                        }
                    }
                    if (i == 3) {
                        switch (j) {
                            case 0:
                            case 4:
                                sb.append("|");
                                break;
                            case 1:
                            case 3:
                                sb.append("_");
                                break;
                            case 2:
                                if (c != null) {
                                    sb.append(c.getBottom() == 10 ? "A" : c.getBottom());
                                } else {
                                    sb.append("_");
                                }
                                break;
                        }
                    }
                }
            }
            if (i != 3) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void printCardEx(Card card) {
        StringBuilder sb = new StringBuilder();
        int width = 5;
        int height = 4;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i == 0) {
                    sb.append("_");
                }
                if (i == 1) {
                    switch (j) {
                        case 0:
                        case 4: sb.append("|"); break;
                        case 1:
                        case 3: sb.append("_"); break;
                        case 2: sb.append(card.getTop() == 10 ? "A" : card.getTop()); break;
                    }
                }
                if (i == 2) {
                    switch (j) {
                        case 0:
                        case 4: sb.append("|"); break;
                        case 2: sb.append("_"); break;
                        case 3: sb.append(card.getRight() == 10 ? "A" : card.getRight()); break;
                        case 1: sb.append(card.getLeft() == 10 ? "A" : card.getLeft()); break;
                    }
                }
                if (i == 3) {
                    switch (j) {
                        case 0:
                        case 4: sb.append("|"); break;
                        case 1:
                        case 3: sb.append("_"); break;
                        case 2: sb.append(card.getBottom() == 10 ? "A" : card.getBottom()); break;
                    }
                }
            }
            if (i != 3) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
