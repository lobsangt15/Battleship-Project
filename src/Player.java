public class Player extends Space {
    private int score;
    private int moves;
    private String name;
    private int points;

    public Player(String name) {
        super(name.substring(0, 1));
        score = 0;
        moves = 0;
        points = 0;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getMoves() {
        return moves;
    }

    public int getPoints () {
        return points;
    }

    public void move() {
        moves++;
    }

    public void addPoints(int amt) {
        score += amt;
    }
}
