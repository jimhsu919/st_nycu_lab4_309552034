import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Game game = new Game();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== welcome to Rock-Paper-Scissors game ===");
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        String p1 = reader.readLine();
        try {
            game.inputChecker(p1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return;
        }
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        String p2 = reader.readLine();
        try {
            game.inputChecker(p2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return;
        }

        System.out.println(game.getWinner(p1, p2));
    }

}
