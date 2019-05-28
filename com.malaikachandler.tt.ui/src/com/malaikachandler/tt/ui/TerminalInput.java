package com.malaikachandler.tt.ui;

import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.GameConstants;
import com.malaikachandler.tt.gamecomponents.Player;

import java.util.List;
import java.util.Scanner;

public class TerminalInput implements InputSource {

    private Scanner scanner = new Scanner(System.in);

//    @Override
//    public void quitGame()  {
//        System.out.println("Buhbyyye");
//        System.exit(0);
//    }

    @Override
    public String getName() {
        String name;
        do {
            name = scanner.nextLine();
        } while (name.equals(""));

        return name;
    }

    public void playerTurn(GameBoard gameBoard, Player player) {
        int row, col;
        Card card;
        do {
            // Choose card index from hand
            card = chooseCard(player);

            // Choose row index on board
            row = chooseRowIndex(gameBoard);

            // Choose col index on board
            col = chooseColIndex(gameBoard, row);

        } while (!gameBoard.placeCard(player, row, col, card));

        System.out.println("Player " + player.getName() + " places " + card.getName() + " at row " + row + " and col " + col);

        // Remove card from player's hand
        player.popCard(card);
    }

    private Card chooseCard(Player player) {
        int cardIndex = -1;
        do {
            if (scanner.hasNextInt()) {
                cardIndex = scanner.nextInt();
            }
        }
        while (!(cardIndex >= 0 && cardIndex < player.getHand().size()));

        return player.peekCard(cardIndex);
    }

    private int chooseRowIndex(GameBoard gb) {
        int row = -1;
        do {
            System.out.println("Choose row index: ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
            }
        }
        while (!(row >= 0 && row < GameConstants.BOARD_HEIGHT && gb.availableColumnIndexesInRow(row).size() > 0));

        return row;
    }

    private int chooseColIndex(GameBoard gb, int row) {
        int col = -1;
        List<Integer> colIndexes = gb.availableColumnIndexesInRow(row);
        do {
            System.out.println("Choose col index: ");
            if (scanner.hasNextInt()) {
                col = scanner.nextInt();
            }
        }
        while (!(col >= 0 && col < GameConstants.BOARD_WIDTH && colIndexes.contains(col)));

        return col;
    }
}
