public class Item {
    int itemId;
    String name;
    double startPrice;
    double currentBid;
    boolean isSold;

    Item(int itemId, String name, double startPrice) {
        this.itemId = itemId;
        this.name = name;
        this.startPrice = startPrice;
        this.currentBid = startPrice;
        this.isSold = false;
    }

    void display() {
        System.out.println("ID: " + itemId + " -- Item: " + name +
                " -- Start: Rs." + startPrice + " -- Current Bid: Rs." + currentBid);
    }
}