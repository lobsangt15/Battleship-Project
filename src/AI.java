import java.util.Random;
public class AI {

    private int[][] board;
    private int[][] Random;
    public AI() {
    this.board = board;
    this.Random = Random;
    }

    public int[][] getBoard() {
        return board;
    }

    public int[][] getRandom() {
        return Random;
    }

    public int makeMoves() {
        int turns = 0;
        boolean AITURN = true;

        while (AITURN) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if (board[x][y] == 1) {
                System.out.println("The AI has hit your ship at coordinates X: " + x + ", Y: " + y + ".");
                board[x][y] = -1;
                turns++;

            } else if (board[x][y] == -1){
                System.out.println("The AI missed your ship! Turn over.");
                board[x][y] = 0;
                AITURN = false;
            }
        }
        return turns;
    }
}

