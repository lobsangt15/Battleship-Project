public class Player {
    private String name;
    private int points;
    private int score;
    private int moves;
    private int numBombs = 0;
    private int numScoutPlanes = 0;
    private int numRecallPanels = 0;

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

    public void addPoints(int amount) {
        points += amount;
    }

    public void addBombs(int amount) {
        numBombs += amount;
    }

    public boolean useBomb() {
        if (numBombs > 0) {
            numBombs--;
            return true;
        }
        return false;
    }

    public void addScoutPlanes(int amount) {
        numScoutPlanes += amount;
    }

    public boolean useScoutPlane() {
        if (numScoutPlanes > 0) {
            numScoutPlanes--;
            return true;
        }
        return false;
    }

    public void addRecallPanels(int amount) {
        numRecallPanels += amount;
    }

    public boolean useRecallPanel() {
        if (numRecallPanels > 0) {
            numRecallPanels--;
            return true;
        }
        return false;
    }

    public int getBombs() {
        return numBombs;
    }

    public int getScoutPlanes() {
        return numScoutPlanes;
    }

    public int getRecallPanels() {
        return numRecallPanels;
    }

}
