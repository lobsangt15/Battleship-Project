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

    public void takeTurns(Space[][] board) {}
}
