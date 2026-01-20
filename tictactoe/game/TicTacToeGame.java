package tictactoe.game;

public class TicTacToeGame {

    private final char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    // winning combinations
    private static final int[][][] WINS = {
        {{0,0},{0,1},{0,2}},
        {{1,0},{1,1},{1,2}},
        {{2,0},{2,1},{2,2}},
        {{0,0},{1,0},{2,0}},
        {{0,1},{1,1},{2,1}},
        {{0,2},{1,2},{2,2}},
        {{0,0},{1,1},{2,2}},
        {{0,2},{1,1},{2,0}}
    };

    // Constructor
    public TicTacToeGame() {
        board = new char[3][3];
        reset();
    }

    // Resets the game state
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }

    // Getters
    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    // validate a move
    public boolean isValidMove(int row, int col) {
        if (gameOver) 
            return false;

        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') 
            return false;

        return true;
    }

    // make a move
    public boolean makeMove(int row, int col) {
        if (!isValidMove(row, col)) {
            return false;
        }
        board[row][col] = currentPlayer;
        if (checkWinner() != ' ' || checkDraw()) {
            gameOver = true;
        } else {
            switchPlayer();
        }
        return true;
    }

    // switch current player
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // check for a winner
    public char checkWinner() {
        for (int[][] win : WINS) {
            char a = board[win[0][0]][win[0][1]];
            char b = board[win[1][0]][win[1][1]];
            char c = board[win[2][0]][win[2][1]];

            if (a != ' ' && (a == b && b == c)) {
                return a;
            }
        }
        return ' ';
    }

    // check for a draw
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }

        return true;
    }

    // check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }
}
