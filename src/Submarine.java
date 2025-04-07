public class Submarine extends Space{
    private int shipPartsNum;
    private boolean hasBomb;

    public Submarine (String symbol, int shipPartsNum, boolean hasBomb) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
        this.hasBomb = hasBomb;
    }
}
