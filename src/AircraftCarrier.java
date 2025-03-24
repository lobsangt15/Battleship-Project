public class AircraftCarrier extends Battleship {
    private boolean hasScoutPlanes;
    public AircraftCarrier (String symbol, int shipPartsNum, boolean hasScoutPlanes) {
        super(symbol, shipPartsNum);
        hasScoutPlanes = true;
    }

    public boolean isHasScoutPlanes () {
        return hasScoutPlanes;
    }
}
