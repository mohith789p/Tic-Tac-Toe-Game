package tictactoe.ui;

import tictactoe.game.*;
import java.util.*;

public class TicTacToeCLI {

    private final TicTacToeGame game;
    private String playerX;
    private String playerO;

    // Constructor
    public TicTacToeCLI(String px, String po) {
        game = new TicTacToeGame();
        this.playerX = px;
        this.playerO = po;
    }

    // Start the game loop
  public void startGame() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Tic Tac Toe Game Started!");
    
    while (!game.isGameOver()) {
        displayBoard();
        char currentSymbol = game.getCurrentPlayer();
        String currentName = (currentSymbol == 'X') ? playerX : playerO;
        System.out.print(" " + currentName + "'s turn. Enter row and column: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        if (!game.makeMove(row, col)) {
            System.out.println("Invalid move. Try again.");
        }
    }

    displayBoard();
    char winner = game.checkWinner();
    if (winner != ' ') {
        String player = (winner == 'X') ? playerX : playerO;
        System.out.println("Congratulations " + player + "! You win!");
    } else {
        System.out.println("It's a draw!");
    }
}


    // Display the current board state
    private void displayBoard() {
        char[][] board = game.getBoard();
        System.out.println("Current Board:");
        System.out.print("    ");
        for (int col = 0; col < 3; col++) {
            System.out.print("  " + col + "  ");
        }
        System.out.println();

        for (int row = 0; row < 3; row++) {
            System.out.print("  +");
            for (int col = 0; col < 3; col++) {
                System.out.print("-----+");
            }
            System.out.println();

            System.out.print(row + " |");
            for (int col = 0; col < 3; col++) {
                System.out.print("  " + board[row][col] + "  |");
            }
            System.out.println();
        }

        System.out.print("  +");
        for (int col = 0; col < 3; col++) {
            System.out.print("-----+");
        }
        System.out.println();
    }

}
