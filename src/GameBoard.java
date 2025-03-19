import java.util.Scanner;

public class GameBoard {
    private Space [][] board;
    private Player player;
    private Scanner scanner;

    private void setupBoard() {
        board = new Space[8][8];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == null) {
                    board[r][c] = new Space("O");
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

}
