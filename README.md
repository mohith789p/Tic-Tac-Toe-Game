# Tic-Tac-Toe (CLI)

## How to Play

- Players: Two players take turns. One is X, the other is O.
- Board: A 3×3 grid shown in the command-line interface. Each turn, place your symbol in an empty square.
- Goal: Get three of your symbols in a row — horizontally, vertically, or diagonally.
- Turn order: X usually goes first. Players alternate until someone wins or the board is full.

## Winning and Draws

- Win: If you place three of your symbols in a straight line, you win immediately.
- Draw: If all squares are filled and neither player has three in a row, the game is a tie.

## Simple Strategy Tips

- Start in the center when you can — it gives the most chances to make three-in-a-row.
- Block your opponent: if they have two in a row, place your symbol to stop them.
- Think one move ahead: consider how a move creates opportunities for both players.

## Variations

- Play best-of-three or best-of-five matches to reduce luck and reward strategy.
- Try switching who goes first each game for fairness.

## About the Game

This version is a simple command-line (text-based) game of Tic-Tac-Toe. It keeps the classic rules and quick play of the paper-and-pencil original while running in a terminal window. It's easy to learn, fast to play, and great for practicing strategic thinking. Games are usually short and perfect for casual play or deciding small decisions.

Have fun and enjoy the game!

## Demo

- Animated demo (inline):

  ![Demo GIF](assets/demo.gif)

- Click the thumbnail to open the demo image/GIF:

  [![Demo Thumbnail](assets/demo_thumbnail.png)](assets/demo.gif)

- If you want a full-resolution `mp4`, add `assets/demo.mp4` to the repository (or upload it to YouTube and link here). To recreate the thumbnail and GIF locally using `ffmpeg` run:

```powershell
ffmpeg -ss 00:00:02 -i "E:\path\to\source.mp4" -frames:v 1 -q:v 2 -update 1 assets/demo_thumbnail.png
ffmpeg -i "E:\path\to\source.mp4" -vf "fps=12,scale=640:-1:flags=lanczos" -loop 0 assets/demo.gif
```
