public class UnmannedShip extends Space{
    public boolean hasRecallPanel;

    public UnmannedShip (String symbol, int shipPartsNum, boolean hasRecallPanel) {
        super(symbol, shipPartsNum);
        hasRecallPanel = true;
    }

    public boolean isHasRecallPanel () {
        return hasRecallPanel;
    }
}
