package com.malaikachandler.tt.graphics;

import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameBoardCardPosition;
import com.malaikachandler.tt.Player;
import com.malaikachandler.tt.carddata.CardData;
import com.malaikachandler.tt.gamecomponents.Position;

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

        printCardRowEx(cards2, TerminalColor.ANSI_RESET);
        printCardRowEx(cards2, TerminalColor.ANSI_RESET);
        printCardRowEx(cards2, TerminalColor.ANSI_RESET);
    }

    public static void printPlayerHand(Player player) {
        printCardRowEx(player.getHand(), player.getColor());
    }

    public static void printCardRow(List<GameBoardCardPosition> positions, int row) {
        StringBuilder sb = new StringBuilder();
        int width = 5;
        int height = 4;

        for (int i = 0; i < height; i++) {
            int col = 0;
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
                                    sb.append(c.getRank(Position.TOP) == 10 ? "A" : c.getRank(Position.TOP));
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
                                if (c != null) {
                                    sb.append(" ");
                                } else {
                                    sb.append(",");
                                }
                                break;
                            case 3:
                                if (c != null) {
                                    sb.append(c.getRank(Position.RIGHT) == 10 ? "A" : c.getRank(Position.RIGHT));
                                } else {
                                    sb.append(col);
                                }
                                break;
                            case 1:
                                if (c != null) {
                                    sb.append(c.getRank(Position.LEFT) == 10 ? "A" : c.getRank(Position.LEFT));
                                } else {
                                    sb.append(row);
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
                                    sb.append(c.getRank(Position.BOTTOM) == 10 ? "A" : c.getRank(Position.BOTTOM));
                                } else {
                                    sb.append("_");
                                }
                                break;
                        }
                    }
                }
                col++;
            }
            if (i != 3) {
                sb.append("\n");
            }
        }

        sb.append(TerminalColor.ANSI_RESET);
        System.out.println(sb.toString());
    }

    public static void printCardRowEx(List<Card> cards, String color) {
        StringBuilder sb = new StringBuilder();
        int width = 5;
        int height = 4;

        sb.append(color);

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
                                    sb.append(c.getRank(Position.TOP) == 10 ? "A" : c.getRank(Position.TOP));
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
                                    sb.append(c.getRank(Position.RIGHT) == 10 ? "A" : c.getRank(Position.RIGHT));
                                } else {
                                    sb.append(" ");
                                }
                                break;
                            case 1:
                                if (c != null) {
                                    sb.append(c.getRank(Position.LEFT) == 10 ? "A" : c.getRank(Position.LEFT));
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
                                    sb.append(c.getRank(Position.BOTTOM) == 10 ? "A" : c.getRank(Position.BOTTOM));
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
        sb.append(TerminalColor.ANSI_RESET);
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
                        case 2: sb.append(card.getRank(Position.TOP) == 10 ? "A" : card.getRank(Position.TOP)); break;
                    }
                }
                if (i == 2) {
                    switch (j) {
                        case 0:
                        case 4: sb.append("|"); break;
                        case 2: sb.append("_"); break;
                        case 3: sb.append(card.getRank(Position.RIGHT) == 10 ? "A" : card.getRank(Position.RIGHT)); break;
                        case 1: sb.append(card.getRank(Position.LEFT) == 10 ? "A" : card.getRank(Position.LEFT)); break;
                    }
                }
                if (i == 3) {
                    switch (j) {
                        case 0:
                        case 4: sb.append("|"); break;
                        case 1:
                        case 3: sb.append("_"); break;
                        case 2: sb.append(card.getRank(Position.BOTTOM) == 10 ? "A" : card.getRank(Position.BOTTOM)); break;
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
