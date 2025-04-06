public class AI {
    private GameBoard game;
    private Space[][] playerBoard;

    public AI(GameBoard game) {
        this.game = game;
    }

    public void AITurn(Space[][] playerBoard) {
        boolean turnOngoing = true;
        while (turnOngoing) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            Space target = playerBoard[x][y];

            if (!target.isHit()) {
                if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Frigate || target instanceof Submarine) {
                    System.out.println("AI hit your ship at (" + x + ", " + y + ")!");
                    target.markAsHit();
                    printPlayerBoard(playerBoard);
                } else {
                    System.out.println("AI missed at (" + x + ", " + y + ").");
                    target.markAsMiss();
                    turnOngoing = false;
                }
            } else {
                System.out.println("You have already hit this coordinate!");
            }
        }
    }

    public void printPlayerBoard(Space[][] board) {
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }
}