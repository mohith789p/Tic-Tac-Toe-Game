import tictactoe.ui.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.print(AnsiColor.BLUE + "Enter player 1 name: " + AnsiColor.YELLOW);
            String player1 = sc.nextLine();
            System.out.print(AnsiColor.RESET);

            System.out.print(AnsiColor.BLUE + "Enter player 2 name: " + AnsiColor.YELLOW);
            String player2 = sc.nextLine();
            System.out.print(AnsiColor.RESET);

            TicTacToeCLI game = new TicTacToeCLI(player1, player2);
            game.startGame();

            System.out.print(AnsiColor.CYAN + "\nPlay again? (y/n): " + AnsiColor.YELLOW);
            String choice = sc.nextLine().trim().toLowerCase();
            System.out.print(AnsiColor.RESET);

            playAgain = choice.equals("y");
        }

        System.out.println(AnsiColor.GREEN + "\nThanks for playing!" + AnsiColor.RESET);
        sc.close();
    }
}
