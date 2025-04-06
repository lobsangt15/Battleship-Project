public class Destroyer extends Space {
    private int shipPartsNum;

    public Destroyer(String symbol, int shipPartsNum) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
    }

    public int getShipPartsNum() {
        return shipPartsNum;
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
