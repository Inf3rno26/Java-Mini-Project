import java.util.ArrayList;

public class Auction {
    ArrayList<Item> items = new ArrayList<>();
    Bidder currentWinner = null;

    void addItem(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.name);
    }

    Item findItem(int id) {
        for (Item item : items) {
            if (item.itemId == id) 
                return item;
        }
        return null;
    }

    void placeBid(Item item, Bidder bidder, double amount) {
        if (item.isSold) {
            System.out.println("Item already sold!");
        } else if (amount <= item.currentBid) {
            System.out.println("Bid must be higher than Rs." + item.currentBid);
        } else if (amount > bidder.balance) {
            System.out.println("Not enough balance!");
        } else {
            item.currentBid = amount;
            currentWinner = bidder;
            System.out.println(bidder.name + " placed bid of Rs." + amount + " on " + item.name);
        }
    }

    void closeAuction(Item item) {
        if (currentWinner == null) {
            System.out.println("No bids placed for " + item.name);
        } else {
            item.isSold = true;
            item.winner = currentWinner.name;  
            currentWinner.balance -= item.currentBid;
            System.out.println("Winner: " + currentWinner.name + " for Rs." + item.currentBid);
            currentWinner = null;              
        }
    }

    void showItems() {
        if (items.isEmpty()) {
            System.out.println("No items yet!");
            return;
        }
        System.out.println("\n--- Items ---");
        for (Item item : items) 
            item.display();
    }
}