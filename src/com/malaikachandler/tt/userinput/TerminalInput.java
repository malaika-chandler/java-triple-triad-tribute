package com.malaikachandler.tt.userinput;

import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.GameConstants;
import com.malaikachandler.tt.gamecomponents.Player;

import java.util.Scanner;

public class TerminalInput implements InputSource {

    private TerminalInput instance;
    private Scanner scanner = new Scanner(System.in);

    public void playerTurn(GameBoard gameBoard, Player player) {
        int cardIndex = -1, row = -1, col = -1;
        do {
            // Choose card index from hand
            do {
                if (scanner.hasNextInt()) {
                    cardIndex = scanner.nextInt();
                }
            }
            while (!(cardIndex >= 0 && cardIndex < player.getHand().size()));


            // Choose row index on board
            do {
                System.out.println("Choose row index: ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                }
            }
            while (!(row >= 0 && row < GameConstants.BOARD_HEIGHT));


            // Choose col index on board
            do {
                System.out.println("Choose col index: ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                }
            }
            while (!(col >= 0 && col < GameConstants.BOARD_WIDTH));

        } while (!gameBoard.placeCard(player, row, col, player.popCard(cardIndex)));
    }

    @Override
    public void quitGame()  {
        System.out.println("Buhbyyye");
        System.exit(0);
    }

    @Override
    public String getName() {
        String name;
        do {
            name = scanner.nextLine();
        } while (name.equals(""));

        return name;
    }
}
