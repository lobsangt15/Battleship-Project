import java.util.Random;
public class AI {

    private int[][] board;
    private int[][] Random;
    public AI() {
        this.board = board;
        this.Random = Random;
    }
    public int makeMoves() {
        int x = 0;
        int y = 0;
        boolean hit = false;
        int turns = 1;
        boolean AITURN = false;
//plan : if the hit hits battleship, set to true and give another turn, to make ai smart either + 1 the column or -1 or +1 row
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                x = (int) Math.floor(Math.random() * 11);
                y = (int) Math.floor(Math.random() * 11);
            }
            if (board[x][y] = hit) {
                turns++;

            }
        }
        return x;
    }

}
