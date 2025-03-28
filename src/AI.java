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
        int x = 0;
        int y = 0;
        boolean hit = false;
        int turns = 1;
        boolean AITURN = false;
        if (AITURN) {
            turns++;
        } else {
            turns = 0;
        }
//plan : if the hit hits battleship, set to true and give another turn, to make ai smart either + 1 the column or -1 or +1 row
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                x = (int) Math.floor(Math.random() * 11);
                y = (int) Math.floor(Math.random() * 11);
            }
            // fix later please chase!!!
            if (board[x][y] == 1) {
                hit = true;
                System.out.println("The AI has hit your ship. He gets an extra turn!");
                AITURN = true;
            } else {
                AITURN = false;
                System.out.println("The AI has missed!");
            }
        }
        return turns;
    }
}
