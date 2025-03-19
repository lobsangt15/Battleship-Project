public class AircraftCarrier extends Battleship {
    private boolean hasScoutPlanes;
    public AircraftCarrier (int shipPartsNum, String size, boolean hasScoutPlanes) {
        super(shipPartsNum, size);
        hasScoutPlanes = true;
    }

    public boolean isHasScoutPlanes () {
        return hasScoutPlanes;
    }
}
