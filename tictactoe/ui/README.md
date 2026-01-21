# UI Package — API Reference (tictactoe/ui)

This document lists the public classes, methods, parameters, and naming conventions for the `tictactoe.ui` package.

Files and Responsibilities:

- `tictactoe.ui.TicTacToeCLI` — CLI frontend: reads input, renders board, displays prompts and results.
- `tictactoe.ui.AnsiColor` — Enum of ANSI color escape codes used by the CLI for colored output.

Class: `tictactoe.ui.TicTacToeCLI`

Fields (private):

- `TicTacToeGame game` — internal game instance used for state and rules.
- `String playerX` — display name for X player.
- `String playerO` — display name for O player.

Constructor:

- `public TicTacToeCLI(String px, String po)`
  - Parameters: `px` — player name for X; `po` — player name for O.
  - Behavior: Initializes `game` (`new TicTacToeGame()`), and stores player names.

Public Methods:

- `public void startGame()`
  - Parameters: none
  - Returns: none
  - Behavior: Runs the main input loop:
    - Uses `Scanner` to read two integers per turn: row then column.
    - Calls `displayBoard()` each turn before prompting.
    - Uses `game.getCurrentPlayer()` to determine current symbol and maps to `playerX`/`playerO` for display.
    - Calls `game.makeMove(row, col)` to apply a move; prints error message and re-prompts on invalid moves.
    - When `game.isGameOver()` becomes true, prints final board and either a win message (using `game.checkWinner()`) or a draw message.
  - Input expectations: two space-separated integers, both in the range `0..2`. Non-integer input is caught and re-prompted.

Private Methods:

- `private void displayBoard()`
  - Parameters: none
  - Returns: none
  - Behavior: Reads `char[][]` from `game.getBoard()` and prints a formatted board with row/column indices and color-coded cell values using `AnsiColor`.

Class: `tictactoe.ui.AnsiColor`

- Enum constants: `RESET`, `BLACK`, `RED`, `GREEN`, `YELLOW`, `BLUE`, `PURPLE`, `CYAN`, `WHITE`.
- Constructor: `AnsiColor(String code)` — stores the ANSI escape code.
- Methods: `public String toString()` — returns the stored escape sequence.

Naming & Style Notes:

- Classes use PascalCase; methods and fields use camelCase.
- CLI prints use `AnsiColor` constants concatenated with strings (e.g., `AnsiColor.RED + "text" + AnsiColor.RESET`).

Integration Notes:

- `TicTacToeCLI` depends on `TicTacToeGame` for all game rules. UI should not modify game internals directly.
- `AnsiColor` output may not display as intended on terminals that don't support ANSI sequences (Windows `cmd.exe` may need configuration).

See source:

- [tictactoe/ui/TicTacToeCLI.java](tictactoe/ui/TicTacToeCLI.java)
- [tictactoe/ui/AnsiColor.java](tictactoe/ui/AnsiColor.java)
