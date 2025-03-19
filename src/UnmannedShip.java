public class UnmannedShip extends Battleship{
    public boolean hasRecallPanel;

    public UnmannedShip (int shipPartsNum, String size, boolean hasRecallPanel) {
        super(shipPartsNum, size);
        hasRecallPanel = true;
    }

    public boolean isHasRecallPanel () {
        return hasRecallPanel;
    }
}
