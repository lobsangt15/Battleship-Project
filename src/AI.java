public class AI {
    private Space[][] board;

    public AI() {
        board = new Space[10][10];
        setupBoard();
    }

    public void setupBoard() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                board[r][c] = new Space("☐", 0);
            }
        }

        board[2][2] = new Battleship("⛴", 4);
        board[5][5] = new AircraftCarrier("🛳", 6, true);
        board[7][7] = new UnmannedShip("⛵", 2, true);
    }

    public Space[][] getBoard() {
        return board;
    }

    public void takeTurn(Space[][] playerBoard) {
        boolean turnOngoing = true;
        while (turnOngoing) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            Space target = playerBoard[x][y];

            if (!target.isHit()) {
                if (target instanceof Battleship || target instanceof AircraftCarrier || target instanceof UnmannedShip) {
                    System.out.println("AI hit your ship at (" + x + ", " + y + ")!");
                    target.markAsHit();
                } else {
                    System.out.println("AI missed at (" + x + ", " + y + ").");
                    target.markAsMiss();
                    turnOngoing = false;
                }
            }
        }
    }
}
