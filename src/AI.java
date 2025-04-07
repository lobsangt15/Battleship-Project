import java.util.ArrayList;
import java.util.List;

public class AI extends Char {
    private GameBoard game;
    private int score = 0;
    String name;
    private List<int[]> targets = new ArrayList<>(); // list of next tiles to try

    public AI(String name, int score, GameBoard game) {
        super(name, score);
        this.game = game;
    }

    @Override
    public void takeTurns(Space[][] playerBoard) {
        boolean turnOngoing = true;

        while (turnOngoing) {
            int x, y;

            if (!targets.isEmpty()) {
                int[] nextTarget = targets.removeFirst();
                x = nextTarget[0];
                y = nextTarget[1];
            } else {
                x = (int)(Math.random() * 9);
                y = (int)(Math.random() * 9);
            }

            // Skip already-hit spots
            Space target = playerBoard[x][y];
            if (target.isHit()) {
                continue;
            }

            if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Frigate || target instanceof Submarine) {
                System.out.println("AI hit your ship at (" + x + ", " + y + ")!");
                target.markAsHit();
                addScore(1);
                addAdjacentTargets(x, y, playerBoard);
                printPlayerBoard(playerBoard);
                if (gameOver()) {
                    return;
                }
            } else {
                System.out.println("AI missed at (" + x + ", " + y + ").");
                target.markAsMiss();
                turnOngoing = false;
            }
        }
    }

    private void addAdjacentTargets(int x, int y, Space[][] board) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (inBounds(newX, newY) && !board[newX][newY].isHit()) {
                targets.add(new int[] { newX, newY });
            }
        }
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    public void printPlayerBoard(Space[][] board) {
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }
}