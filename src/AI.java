import java.util.Random;
public class AI {

    private int[][] board;
    private int[][] Random;
    public AI() {
        this.board = board;
        this.Random = Random;
    }
    public int makeMoves() {
        int x;
        int y;
        boolean hit = false;

//plan : if the hit hits battleship, set to true and give another turn, to make ai smart either + 1 the column or -1 or +1 row
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (hit) {
                    System.out.println("The enemy's battleship has been hit.");
                    board[r][c] = /
                }
            }
        }
    }

}
