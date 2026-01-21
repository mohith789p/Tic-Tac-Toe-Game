# Tic-Tac-Toe — Technical Documentation (tictactoe)

## Overview

This document describes the implementation and structure of the `tictactoe` package. It covers the main components, responsibilities, and simple instructions to compile and run the CLI-based game.

## Repository Layout

- [tictactoe/game/TicTacToeGame.java](tictactoe/game/TicTacToeGame.java) — Core game logic and state management.
- [tictactoe/ui/TicTacToeCLI.java](tictactoe/ui/TicTacToeCLI.java) — Command-line interface that handles user interaction and renders the board.
- [tictactoe/ui/AnsiColor.java](tictactoe/ui/AnsiColor.java) — Small helper providing ANSI color constants used by the CLI.

There is also a project entry point at the repository root: [Main.java](Main.java).

## Components

- `tictactoe.game.TicTacToeGame`
  - Responsibility: maintain board state, validate and apply moves, detect wins/draws, and manage turn order.
  - Key behaviors: create/reset game, apply a move, check for a win or draw, and expose the current player and board state.

- `tictactoe.ui.TicTacToeCLI`
  - Responsibility: interact with players via the terminal, render the board, read player input, and call game logic methods.
  - Key behaviors: display the board and prompts, handle input parsing and validation, show results (win/draw), and loop through turns.

- `tictactoe.ui.AnsiColor`
  - Responsibility: provide named color/text style constants for terminal output. Used only by the CLI to improve readability.

## Public API Notes

The package is organized for direct use by the CLI. If you want to reuse the core logic in another interface (GUI, web, or AI), interact with `TicTacToeGame` for all game-state operations and leave rendering/input to the caller.

Suggested minimal interface surface on `TicTacToeGame` (conceptual):

- `boolean makeMove(int row, int col)` — apply a move for the current player; returns whether the move was accepted.
- `Player getCurrentPlayer()` — returns which player's turn it is.
- `GameState checkGameState()` — returns ongoing, win (and who), or draw.
- `void reset()` — reset the board to start a new game.

Actual method names may vary; consult [tictactoe/game/TicTacToeGame.java](tictactoe/game/TicTacToeGame.java) for exact signatures.

## Build & Run (Windows / PowerShell)

From the project root, compile Java sources and run the `Main` entry point. Example commands for PowerShell:

```powershell
javac -d out Main.java tictactoe\game\*.java tictactoe\ui\*.java
java -cp out Main
```

If compilation succeeds, the CLI will start in the terminal and prompt players for moves.

## Running Notes

- The game runs entirely in the terminal and expects simple text input (typically row/column or a single square index). The CLI handles basic validation and will re-prompt on invalid input.
- Colors (if any) come from `AnsiColor` and may not render correctly on all terminals.

## Extending the Codebase

- To add AI: implement an engine that queries `TicTacToeGame` for valid moves and applies chosen moves via the same `makeMove` API.
- To add tests: create unit tests around `TicTacToeGame` for move validation, win/draw detection, and reset behavior.
- To add a GUI: keep `TicTacToeGame` unchanged and build a new frontend that renders state and sends player actions into the game API.

## Contributing Notes

- Keep UI and game logic separated: `TicTacToeGame` should not perform I/O.
- Keep methods small and focused; prefer clear, descriptive method names.

For exact code, public method signatures, and comments, see the source files linked above.
