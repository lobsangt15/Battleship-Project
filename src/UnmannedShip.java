public class UnmannedShip extends Space {
    private int shipPartsNum;
    private boolean hasRecallPanel;

    public UnmannedShip(String symbol, int shipPartsNum, boolean hasRecallPanel) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
        this.hasRecallPanel = hasRecallPanel;
    }

    public void hit() {
        if (shipPartsNum > 0) {
            shipPartsNum--;
        }
    }

    public boolean isSunk() {
        return shipPartsNum <= 0;
    }
}
