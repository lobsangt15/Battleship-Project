public class Player extends Space {
    private int score;
    private int moves;
    private String name;
    private int points;

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

    public int getPoints () {
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
}


