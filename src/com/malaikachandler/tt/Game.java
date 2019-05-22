package com.malaikachandler.tt;

import com.malaikachandler.tt.carddata.CardData;
import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.GameConstants;
import com.malaikachandler.tt.graphics.TerminalColor;
import com.malaikachandler.tt.graphics.TerminalGraphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player[] players = new Player[GameConstants.NUMBER_OF_PLAYERS];

    private GameBoard gb;

    private Scanner scanner = new Scanner(System.in);
    private int currentPlayerIndex;

    public Game() {
        // Set up players
        setUpPlayers();

        // Set up game board
        gb = new GameBoard();

        // Choose starting player
        Random random = new Random();
        currentPlayerIndex = random.nextInt(GameConstants.NUMBER_OF_PLAYERS);

        // while (board is not full)
        while (gb.hasEmptySpaces()) {

            // Show score
            TerminalGraphics.displayPlayerScores(players[0], players[1]);

            // Show board
            displayBoard();

            // Player places card in open space
            playerTurn();

            // Next player
            currentPlayerIndex = (currentPlayerIndex + 1) % GameConstants.NUMBER_OF_PLAYERS;
        }

        // Print winner/loser or draw
        displayBoard();
        TerminalGraphics.displayPlayerScores(players[0], players[1]);
    }

    private void displayBoard() {
        players[0].printHand();
        gb.printGameBoard();
        players[1].printHand();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void playerTurn() {
        // Indicate player turn
        int cardIndex, row, col;
        System.out.println(players[currentPlayerIndex].getName() + "'s turn");
        do {
            // Choose card index from hand
            System.out.println("Choose card index: 0 - " + (players[currentPlayerIndex].getHand().size() - 1));
            cardIndex = - 1;
            while (cardIndex == -1) {
                cardIndex = scanner.nextInt();
            }

            System.out.println("Choose row and col: ");
            // Choose grid coordinates for placement on board
            // loop until valid location chosen
            row = scanner.nextInt();
            col = scanner.nextInt();

        } while (!this.gb.placeCard(players[currentPlayerIndex], row, col, players[currentPlayerIndex].popCard(cardIndex)));
    }

    private void setUpPlayers() {
        String[] colors = { TerminalColor.ANSI_BLUE, TerminalColor.ANSI_PURPLE };
        for (int i = 0; i < GameConstants.NUMBER_OF_PLAYERS; i++) {
            String name = "";
            while (name.equals("")) {
                System.out.println("Enter name for player " + (i + 1));
                name = scanner.nextLine();
            }
            players[i] = new Player(name, colors[i]);
            // Set initial scores (5,5)
            players[i].setScore(GameConstants.INITIAL_SCORE);

            // Set up cards
            // TODO: 2019-05-21 cards by level? Or totally random?
            ArrayList<Card> cards = new ArrayList<>(CardData.getInstance().getCardsAtLevel(6));
            Collections.shuffle(cards);
            players[i].setHand(cards.subList(0, GameConstants.INITIAL_CARDS_PER_HANDS));
        }
    }
}
