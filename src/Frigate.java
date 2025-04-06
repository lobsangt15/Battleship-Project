public class Frigate extends Space {
    private int shipPartsNum;

    public Frigate(String symbol, int shipPartsNum) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
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
