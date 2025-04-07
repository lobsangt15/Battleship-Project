public class Submarine extends Space{
    private int shipPartsNum;

    public Submarine (String symbol, int shipPartsNum) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
    }
}
