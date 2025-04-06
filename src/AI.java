import java.util.Scanner;

public class AI {
    private Space[][] AIboard;
    private Player player;
    private Scanner scanner;

    public AI () {
        scanner = new Scanner(System.in);
        setupAIBoard();
        play();
    }

    public void setupAIBoard() {
        AIboard = new Space[10][10];
        for (int r = 0; r < AIboard.length; r++) {
            for (int c = 0; c < AIboard[r].length; c++) {
                if (AIboard[r][c] == null) {
                    AIboard[r][c] = new Space("☐", 0);
                }
            }
        }
    }

    public void printBoard() {
        for (Space[] row : AIboard) {
            for (Space element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }

    private void play() {
        boolean gamePlaying = true;
        player = new Player("Player", 0, 0, 0);

        System.out.println("Get ready, " + player.getName() + ". The game is starting!");
        printBoard();

        while (gamePlaying) {
            System.out.println("Enter which row you'd like to attack (0-9): ");
            int row = scanner.nextInt();
            System.out.println("Enter which column you'd like to attack (0-9): ");
            int column = scanner.nextInt();

            if (row < 0 || row > 9  || column < 0  || column > 9) {
                System.out.println("Invalid coordinates.");
                continue;
            }

            Space target = AIboard[row][column];

            if (target instanceof Battleship || target instanceof AircraftCarrier || target instanceof UnmannedShip) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }

            printBoard();

            gamePlaying = false;
        }

        System.out.println("Game Over!");
    }
}