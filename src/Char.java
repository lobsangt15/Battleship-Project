public class Char {
    private String name;
    private int score;

    public Char (String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int num) {
        score += 1;
    }

    public void takeTurns(Space[][] board) {}

    public boolean gameOver() {
        return getScore() >= 15;
    }
}
