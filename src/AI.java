public class AI {
    private Space[][] board;

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
                if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Frigate || target instanceof Submarine) {
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
