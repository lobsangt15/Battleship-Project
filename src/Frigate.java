public class Frigate extends Space {
    private int shipPartsNum;

    public Frigate(String symbol, int shipPartsNum) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
    }
}
