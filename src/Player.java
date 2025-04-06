public class Player {
    private String name;
    private int points;
    private int score;
    private int moves;

    public Player(String name, int points, int score, int moves) {
        this.name = name;
        this.points = points;
        this.score = score;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getScore() {
        return score;
    }

    public int getMoves() {
        return moves;
    }

    public void usePoints(int amount) {
        points -= amount;
    }
}
