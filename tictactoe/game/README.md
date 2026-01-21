# TicTacToeGame — API Reference (tictactoe/game)

Class: `tictactoe.game.TicTacToeGame`

Description:

- Core game logic and state container for a 3x3 Tic-Tac-Toe game. Keeps the board, current player, and game-over state; performs move validation and detects wins/draws.

Fields (private):

- `char[][] board` — 3×3 board, cells contain `'X'`, `'O'`, or `' '` (space) for empty.
- `char currentPlayer` — `'X'` or `'O'` representing whose turn it is.
- `boolean gameOver` — true when a win or draw has been reached.
- `static final int[][][] WINS` — predefined winning index triplets used by `checkWinner()`.

Constructor:

- `public TicTacToeGame()`
  - Initializes internal board and calls `reset()`.

Public Methods (signatures, parameters, returns):

- `public void reset()`
  - Parameters: none
  - Returns: none
  - Behavior: Clears the board (sets each cell to `' '`), sets `currentPlayer = 'X'`, and `gameOver = false`.

- `public char getCurrentPlayer()`
  - Parameters: none
  - Returns: `char` — current player's symbol (`'X'` or `'O'`).

- `public char[][] getBoard()`
  - Parameters: none
  - Returns: `char[][]` — reference to the internal board array.
  - Note: This returns the internal array; callers should treat it as read-only to avoid corrupting state.

- `public boolean isValidMove(int row, int col)`
  - Parameters: `row` (int) — 0..2, `col` (int) — 0..2
  - Returns: `boolean` — `true` if `row/col` are in range, the cell is empty, and the game is not over.

- `public boolean makeMove(int row, int col)`
  - Parameters: `row` (int) — 0..2, `col` (int) — 0..2
  - Returns: `boolean` — `true` if the move was accepted and applied; `false` otherwise.
  - Behavior: If move valid, writes `currentPlayer` into `board[row][col]`, checks for winner/draw, sets `gameOver` if finished, otherwise switches player.

- `public char checkWinner()`
  - Parameters: none
  - Returns: `char` — `'X'` or `'O'` if a winner exists, otherwise `' '` (space).
  - Behavior: Scans predefined `WINS` triplets to determine if any have the same non-space symbol.

- `public boolean checkDraw()`
  - Parameters: none
  - Returns: `boolean` — `true` when all cells are filled (no spaces) — note a draw may also be reported after a winning move is applied in this implementation.

- `public boolean isGameOver()`
  - Parameters: none
  - Returns: `boolean` — value of internal `gameOver` flag.

Private/Internal Methods:

- `private void switchPlayer()`
  - Parameters: none
  - Returns: none
  - Behavior: Toggles `currentPlayer` between `'X'` and `'O'`.

Usage Notes & Conventions:

- Indexing: rows and columns are zero-based (0..2).
- Naming: camelCase for methods and `UPPER_SNAKE`-style for static finals (`WINS`).
- Mutability: `getBoard()` exposes the internal array; avoid mutating the returned array externally. Prefer adding read-only helpers if needed.
- Threading: Not thread-safe — intended for single-threaded CLI use.

Possible Extension Points:

- Add an immutable board snapshot getter if external read-only access is required.
- Extract a small enum for `Player` instead of using `char` to improve type-safety.

See source: [tictactoe/game/TicTacToeGame.java](tictactoe/game/TicTacToeGame.java)
