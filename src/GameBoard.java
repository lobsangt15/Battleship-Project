import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class GameBoard {
    private Space [][] AIboard;
    private Space [][] PlayerBoard;
    private Player player;
    private Scanner scanner;
    ArrayList<int[]> presetCoord = new ArrayList<>();

    public GameBoard() {
        scanner = new Scanner(System.in);
        setupBoard();
        play();
    }

    private void setPresetCoord() {
        presetCoord.add(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

    }
    public void setupBoard() {
        AIboard = new Space[10][10];
        for (int r = 0; r < AIboard.length; r++) {
            for (int c = 0; c < AIboard[r].length; c++) {
                if (AIboard[r][c] == null) {
                    AIboard[r][c] = new Space("☐");
                }
                AIboard[2][3] = new Battleship("⛴", 4);

            }
        }

    }

    private void addHorizontal(Space shipType, int row, int col, int size, String direction) {
        if (direction.equals("R")) {
            if (col - size <= 0) {
                System.out.println("You are going out of bounds!!!");
            } else {
                for (int i = 1; i < size; i++) {
                    AIboard[row][col - 1] = shipType;
                }
            }
        }
    }

    private void addBattleship(int row, int col) {
        if (!(AIboard[row][col] instanceof Battleship)) {
            AIboard[row][col] = new Battleship("🚢", 4);
            System.out.print("Horizontally or Vertically:(H/V) ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Right or Left: (R/L) ");
                choice = scanner.nextLine().toUpperCase();
                if (choice.equals("V")) {
                    System.out.println("Up or Down: (U/D");
                    choice = scanner.nextLine().toUpperCase();
                }
            }
        }
    }

    private void printBoard() {
        for (Space[] row : AIboard) {
            for (Space element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }

    private void play() {
        boolean gamePlaying = true;
        if (!gamePlaying) {
            System.out.println("Game Over..."); // temporary until we make a way to restart the game. If added, replace the message with "Game Over... try again?"
            System.exit(0);
        }
        System.out.println("Get ready, " + player.getName() + ". The game is starting!");
        printBoard();
        while (gamePlaying) {
            System.out.println("Enter which row you'd like to attack (0-9)");
            int row = scanner.nextInt();
            System.out.println("Enter which column you'd like to attack (0-9)");
            int column = scanner.nextInt();

            if (row < 0 || row > 9 || column < 0 || column > 9) {
                System.out.println("Invalid coordinates. Try Again");
                // add way to make it repeat and go back to asking coordinates for row and column
            }
            Space locationChosen = AIboard[row][column];
            Battleship battleship = (Battleship) locationChosen;
            if (locationChosen instanceof Battleship) {
                battleship.hit();
                System.out.println("You've hit something. Let's see if it was a good hit.");
                AIboard[row][column] = new Space("X");
                printBoard();
            } else {
                System.out.println("You've missed, unfortunately...");
                AIboard[row][column] = new Space("O");
                printBoard();
            }
            if (battleship.isSunk()) {
                System.out.println("You've sunk all the opponent's battleships!");
                printBoard();
                gamePlaying = false;
            }
        }
    }
}
