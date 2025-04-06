public class Submarine extends Space{
    private int shipPartsNum;
    private boolean hasTorpedo;

    public Submarine (String symbol, int shipPartsNum, boolean hasTorpedo) {
        super(symbol, shipPartsNum);
        this.shipPartsNum = shipPartsNum;
        this.hasTorpedo = hasTorpedo;
    }
}
