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

    private void setupBoard() {
        board = new Space[10][10];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    board[r][c] = new Space(" ");
                }
            }
        }
        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);

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
            board[row][col] = new Battleship("🚢",4);
            System.out.print("Horizontally or Vertically:(H/V) ");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Right or Left:(R/L) ");
                choice = scanner.nextLine().toUpperCase();
                if (choice.equals())
            };
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
        while ()
    }

}
