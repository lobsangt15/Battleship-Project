public class Battleship extends Space{
    private int shipPartsNum;
    private String size;

    public Battleship (String symbol, int shipPartsNum, String size) {
        super(symbol);
        this.shipPartsNum = shipPartsNum;
        this.size = size;
    }

    public int getShipPartsNum () {
        return shipPartsNum;
    }

    public String getSize () {
        return size;
    }
}
