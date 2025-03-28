public class Battleship extends Space {
    private int shipPartsNum;
    public Battleship (String symbol, int shipPartsNum) {
        super(symbol);
        this.shipPartsNum = shipPartsNum;
    }

    public int getShipPartsNum () {
        return shipPartsNum;
    }

    public void hit () {
        if (shipPartsNum > 0) {
            shipPartsNum--;
        }
    }

    public boolean isSunk () {
        return shipPartsNum <= 0;
    }

}
