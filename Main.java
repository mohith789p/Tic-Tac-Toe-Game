import tictactoe.ui.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter player 1 name: ");
        String player1 = sc.nextLine();
        System.out.print("Enter player 2 name: ");
        String player2 = sc.nextLine();
        TicTacToeCLI game = new TicTacToeCLI(player1, player2);
        game.startGame();
        sc.close();
    }
}
