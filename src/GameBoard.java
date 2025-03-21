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

    private void addBattleship(int row, int col) {
        if (!(board[row][col] instanceof Battleship)) {
            board[row][col] == Battleship
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
