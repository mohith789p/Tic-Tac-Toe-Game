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
    System.out.println(AnsiColor.GREEN + "Tic Tac Toe Game Started!" + AnsiColor.RESET);
    
    while (!game.isGameOver()) {
        int row, col;
        displayBoard();
        char currentSymbol = game.getCurrentPlayer();
        String currentName = (currentSymbol == 'X') ? playerX : playerO;
        System.out.print(" " + currentName + "'s turn. Enter row and column: ");
        try{
            row = sc.nextInt();
            col = sc.nextInt();
        } catch(InputMismatchException e){
            System.out.println(AnsiColor.RED + "Please enter valid integers for row and column." + AnsiColor.RESET);
            sc.nextLine();
            continue;
        }

        if (!game.makeMove(row, col)) {
            System.out.println(AnsiColor.RED + "Invalid move. Try again." + AnsiColor.RESET);
        }
    }

    displayBoard();
    char winner = game.checkWinner();
    if (winner != ' ') {
        String player = (winner == 'X') ? playerX : playerO;
        System.out.println(AnsiColor.GREEN + "Congratulations " + player + "! You win!" + AnsiColor.RESET);
    } else {
        System.out.println("It's a draw!");
    }
}


    // Display the current board state
    private void displayBoard() {
        char[][] board = game.getBoard();
        System.out.println(AnsiColor.PURPLE + "Current Board:" + AnsiColor.RESET);
        System.out.print("    ");
        for (int col = 0; col < 3; col++) {
            System.out.print("  " + AnsiColor.YELLOW + col + AnsiColor.RESET + "  ");
        }
        System.out.println();

        for (int row = 0; row < 3; row++) {
            System.out.print("  " + AnsiColor.CYAN + "+" + AnsiColor.RESET);
            for (int col = 0; col < 3; col++) {
                System.out.print(AnsiColor.CYAN + "-----+" + AnsiColor.RESET);
            }
            System.out.println();

            System.out.print("" + AnsiColor.YELLOW + row + AnsiColor.RESET + " |");
            for (int col = 0; col < 3; col++) {
                String cell = (board[row][col] == 'X') ? AnsiColor.RED + "X" + AnsiColor.RESET : (board[row][col] == 'O') ? AnsiColor.GREEN + "O" + AnsiColor.RESET : " ";
                System.out.print("  " + cell + AnsiColor.CYAN + "  |" + AnsiColor.RESET);
            }
            System.out.println();
        }

        System.out.print("  " + AnsiColor.CYAN + "+" + AnsiColor.RESET);
        for (int col = 0; col < 3; col++) {
            System.out.print(AnsiColor.CYAN + "-----+" + AnsiColor.RESET);
        }
        System.out.println();
    }

}
