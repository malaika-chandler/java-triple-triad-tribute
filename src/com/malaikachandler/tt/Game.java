package com.malaikachandler.tt;

import com.malaikachandler.tt.carddata.CardData;
import com.malaikachandler.tt.gamecomponents.Card;
import com.malaikachandler.tt.gamecomponents.GameBoard;
import com.malaikachandler.tt.gamecomponents.GameConstants;
import com.malaikachandler.tt.gamecomponents.Player;
import com.malaikachandler.tt.graphics.OutputSource;
import com.malaikachandler.tt.graphics.TerminalColor;
import com.malaikachandler.tt.graphics.TerminalGraphics;
import com.malaikachandler.tt.userinput.InputSource;
import com.malaikachandler.tt.userinput.TerminalInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

    private Player[] players = new Player[GameConstants.NUMBER_OF_PLAYERS];

    private GameBoard gb;

    private OutputSource os = new TerminalGraphics();
    private InputSource is = new TerminalInput();

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

            // Show board
            displayGameState();

            // Player places card in open space
            playerTurn();

            // Next player
            currentPlayerIndex = (currentPlayerIndex + 1) % GameConstants.NUMBER_OF_PLAYERS;
        }

        // Show winner/loser or draw
        endGame();
    }

    private void endGame() {
        displayGameState();
        os.handlePlayerScores(players);

        os.displayEndGame(players);
    }

    private void displayGameState() {
        // Show score
        os.handlePlayerScores(players);

        os.showPlayerHand(players[0]);
        os.handleGameBoard(gb);
        os.showPlayerHand(players[1]);

        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void playerTurn() {
        // Indicate player turn
        os.notifyTurn(players[currentPlayerIndex]);

        // Indicate player card options
        os.indicateCardOptions(players[currentPlayerIndex]);

        // Blocking
        is.playerTurn(gb, players[currentPlayerIndex]);
    }

    private void setUpPlayers() {
        String[] colors = { TerminalColor.ANSI_BLUE, TerminalColor.ANSI_PURPLE };
        for (int i = 0; i < GameConstants.NUMBER_OF_PLAYERS; i++) {

            os.handleGetInitialPlayerDataPrompt(i);

            String name = is.getName();
            players[i] = new Player(name, colors[i]);

            // Set initial scores
            players[i].setScore(GameConstants.INITIAL_SCORE);

            // Set up cards
            // TODO: 2019-05-21 cards by level? Or totally random?
            ArrayList<Card> cards = new ArrayList<>(CardData.getInstance().getCardsAtLevel(6));
            Collections.shuffle(cards);
            players[i].setHand(cards.subList(0, GameConstants.INITIAL_CARDS_PER_HANDS));
        }
    }
}
