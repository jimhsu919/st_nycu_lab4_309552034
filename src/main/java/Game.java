public class Game {
    public void inputChecker(String p) {
        if(!p.equals("rock")  && !p.equals("paper" ) && !p.equals("scissors")) {
            throw new IllegalArgumentException("Bad Choice!");
        }
    }

    public String getWinner(String p1, String p2) {
        if(p1.equals(p2)) {
            return "Draw!";
        }
        else if((p1.equals("rock") && p2.equals("scissors")) ||
                (p1.equals("paper") && p2.equals("rock")) ||
                (p1.equals("scissors")) && p2.equals("paper")) {
            return  "Player 1 win!";
        }
        else {
            return  "Player 2 win!";
        }
    }
}
