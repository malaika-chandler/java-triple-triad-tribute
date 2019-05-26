package com.malaikachandler.tt.graphics;

import com.malaikachandler.tt.gamecomponents.*;

import java.util.Arrays;
import java.util.List;

public class TerminalGraphics implements OutputSource {

    @Override
    public void notifyTurn(Player player) {
        System.out.println(player.getName() + "'s turn");
    }

    @Override
    public void handleGameBoard(GameBoard gameBoard) {
        for (int i = 0; i < GameConstants.BOARD_HEIGHT; i++) {
            printCardRow(gameBoard.getRow(i), i);
        }
    }

    @Override
    public void showPlayerHand(Player player) {
        printCardRowEx(player.getHand(), player.getColor());
    }

    @Override
    public void indicateCardOptions(Player player) {
        System.out.println("Choose card index: 0 - " + (player.getHand().size() - 1));
    }

    @Override
    public void handlePlayerScores(Player[] players) {
        System.out.println("Score:");
        for (Player player : players) {
            System.out.println(player.getName() + " has " + player.getScore() + " points");
        }
    }

    @Override
    public void handleGetInitialPlayerDataPrompt(int index) {
        System.out.println("Enter name for player " + (index + 1) + ":");
    }

    @Override
    public void displayEndGame(Player[] players) {
        if (players.length > 0) {
            Player maxScorePlayer = Arrays.stream(players).max(Player::compareTo).get();
            if (maxScorePlayer.getScore() == GameConstants.INITIAL_SCORE) {
                System.out.println();
                System.out.println("DRAW");
                System.out.println();
            } else {
                System.out.println();
                System.out.println(maxScorePlayer.getName() + " wins!");
                System.out.println();
            }
        }
    }

    private void printCardRow(List<GameBoardCardPosition> positions, int row) {
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

    private void printCardRowEx(List<Card> cards, String color) {
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

//    private static void printCardEx(Card card) {
//        StringBuilder sb = new StringBuilder();
//        int width = 5;
//        int height = 4;
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//
//                if (i == 0) {
//                    sb.append("_");
//                }
//                if (i == 1) {
//                    switch (j) {
//                        case 0:
//                        case 4: sb.append("|"); break;
//                        case 1:
//                        case 3: sb.append("_"); break;
//                        case 2: sb.append(card.getRank(Position.TOP) == 10 ? "A" : card.getRank(Position.TOP)); break;
//                    }
//                }
//                if (i == 2) {
//                    switch (j) {
//                        case 0:
//                        case 4: sb.append("|"); break;
//                        case 2: sb.append("_"); break;
//                        case 3: sb.append(card.getRank(Position.RIGHT) == 10 ? "A" : card.getRank(Position.RIGHT)); break;
//                        case 1: sb.append(card.getRank(Position.LEFT) == 10 ? "A" : card.getRank(Position.LEFT)); break;
//                    }
//                }
//                if (i == 3) {
//                    switch (j) {
//                        case 0:
//                        case 4: sb.append("|"); break;
//                        case 1:
//                        case 3: sb.append("_"); break;
//                        case 2: sb.append(card.getRank(Position.BOTTOM) == 10 ? "A" : card.getRank(Position.BOTTOM)); break;
//                    }
//                }
//            }
//            if (i != 3) {
//                sb.append("\n");
//            }
//        }
//        System.out.println(sb.toString());
//    }

}
