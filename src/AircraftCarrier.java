public class AircraftCarrier extends Space {
    private int shipPartsNum;
    private boolean hasScoutPlanes;

    public AircraftCarrier(String symbol, int shipPartsNum, boolean hasScoutPlanes) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
        this.hasScoutPlanes = hasScoutPlanes;
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
