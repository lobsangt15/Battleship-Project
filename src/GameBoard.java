import java.util.Scanner;

public class GameBoard {
    private Space [][] board;
    private Player player;
    private Scanner scanner;

    public GameBoard() {
        scanner = new Scanner(System.in);
        setupBoard();
        play();
    }

    public void setupBoard() {
        board = new Space[10][10];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    board[r][c] = new Space("☐");
                }
                board[2][3] = new Battleship("⛴", 4);
            }
        }

    }

    private void addHorizontal(Space shipType, int row, int col, int size, String direction) {
        if (direction.equals("R")) {
            if (col - size <= 0) {
                System.out.println("You are going out of bounds!!!");
            } else {
                for (int i = 1; i < size; i++) {
                    board[row][col - 1] = shipType;
                }
            }
        }
    }

    private void addBattleship(int row, int col) {
        if (!(board[row][col] instanceof Battleship)) {
            board[row][col] = new Battleship("🚢", 4);
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
        for (Space[] row : board) {
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
        System.out.println("Get ready, Player 1! The game is starting!");
        printBoard();
        while (gamePlaying) {
            System.out.println("Enter which row you'd like to attack (0-9)");
            int row = scanner.nextInt();
            System.out.println("Enter which column you'd like to attack (0-9)");
            int column = scanner.nextInt();

            if (row < 1 || row > 9 || column < 1 || column > 9) {
                System.out.println("Invalid coordinates. Try Again");
                // add way to make it repeat and go back to asking coordinates for row and column
            }
            Space locationChosen = board[row][column];
            Battleship battleship = (Battleship) locationChosen;
            if (locationChosen instanceof Battleship) {
                battleship.hit();
                System.out.println("You've hit something. Let's see if it was a good hit.");
                board[row][column] = new Space("X");
                printBoard();
            } else {
                System.out.println("You've missed, unfortunately...");
                board[row][column] = new Space("O");
                printBoard();
            }
            if (battleship.isSunk()) {
                System.out.println("You've sunk all the opponent's battleships");
                printBoard();
                gamePlaying = false;
            }
        }
    }
}
