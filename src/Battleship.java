public class Battleship {
    private int shipPartsNum;
    private String size;


    public Battleship (int shipPartsNum, String size) {
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
