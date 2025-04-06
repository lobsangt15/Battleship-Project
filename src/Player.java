import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private int score;
    private int moves;
    private int numBombs = 0;
    private int numScoutPlanes = 0;
    private int numRecallPanels = 0;
    Scanner scan = new Scanner(System.in);

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

    public void PlayerTurn(Space[][] AIBoard) {
        boolean turnOngoing = true;
        while (turnOngoing) {
            System.out.println("Row: ");
            int x = scan.nextInt();
            System.out.println("Col: ");
            int y = scan.nextInt();
            Space target = AIBoard[x][y];

            if (!target.isHit()) {
                if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Frigate || target instanceof Submarine) {
                    System.out.println("You hit a ship at (" + x + ", " + y + ")!");
                    target.markAsHit();
                    score++;
                    printAIBoard(AIBoard);
                } else {
                    System.out.println("You missed at (" + x + ", " + y + ").");
                    target.markAsMiss();
                    turnOngoing = false;
                }
            } else {
                System.out.println("You have already hit this coordinate!");
            }
        }
    }

    public void printAIBoard(Space[][] board) {
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }
}
