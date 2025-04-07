public class Destroyer extends Space {
    private int shipPartsNum;

    public Destroyer(String symbol, int shipPartsNum) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
    }
}
