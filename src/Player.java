import java.util.Scanner;
public class Player extends Space {
    private int score;
    private int moves;
    private String name;
    private int points;
    Scanner scanner = new Scanner(System.in);

    public Player(String name, int points, int score, int moves) {
        super(name.substring(0, 1));
        score = 0;
        moves = 0;
        points = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getMoves() {
        return moves;
    }

    public int getPoints() {
        return points;
    }

    public void move() {
        moves++;
    }

    public void addPoints(int amt) {
        score += amt;
    }

    public boolean usePoints(int cost) {
        if (points > cost) {
            points -= cost;
            return true;
        }
        return false;
    }

    public void reset() {
        score = 0;
        points = 0;
    }

    public void PlayerMove(Space[] board) {
        System.out.println("It's now your turn, " + name + ".");
        int row = -1;
        int column = -1;
        while (true) {
            System.out.println("Enter which row (0-9");
            row = scanner.nextInt();
            System.out.println("Enter which column (0-9");
            column = scanner.nextInt();
            if (row < 1 || row > 10 || column < 1 || column > 10) {
                System.out.println("Invalid coordinates. Try Again");
            }
        }
    }
}


