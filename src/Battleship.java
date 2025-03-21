public class Battleship extends Space {
    private final int shipPartsNum;
    private String size;

    public Battleship (String symbol, int shipPartsNum) {
        super(symbol);
        this.shipPartsNum = shipPartsNum;
    }

    public int getShipPartsNum () {
        return shipPartsNum;
    }

    public String getSize () {
        return size;
    }
}
