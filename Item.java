public class Item {
    int itemId;
    String name;
    double startPrice;
    double currentBid;
    boolean isSold;
    String winner = null;   // <-- new field

    Item(int itemId, String name, double startPrice) {
        this.itemId = itemId;
        this.name = name;
        this.startPrice = startPrice;
        this.currentBid = startPrice;
        this.isSold = false;
    }

    void display() {
        if (isSold) {
            System.out.println("ID: " + itemId + " | Item: " + name +
                    " | Sold for Rs." + currentBid + " | Winner: " + winner);
        } else {
            System.out.println("ID: " + itemId + " | Item: " + name +
                    " | Start: Rs." + startPrice + " | Current Bid: Rs." + currentBid +
                    " | AVAILABLE");
        }
    }
}