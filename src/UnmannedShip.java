public class UnmannedShip extends Battleship{
    public boolean hasRecallPanel;

    public UnmannedShip (String symbol, int shipPartsNum, boolean hasRecallPanel) {
        super(symbol, shipPartsNum);
        hasRecallPanel = true;
    }

    public boolean isHasRecallPanel () {
        return hasRecallPanel;
    }
}
