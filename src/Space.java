public class Space {
    private String symbol;
    private boolean isHit;

    public Space(String symbol, int shipPartsNum) {
        this.symbol = symbol;
        this.isHit = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isHit() {
        return isHit;
    }

    public void markAsHit() {
        isHit = true;
        symbol = "💥";
    }

    public void markAsMiss() {
        isHit = true;
        symbol = "❌";
    }
}
