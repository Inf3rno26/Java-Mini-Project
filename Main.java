import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Auction auction = new Auction();

        Bidder b1 = new Bidder("Alice", 50000);
        Bidder b2 = new Bidder("Bob", 40000);

        int itemCounter = 1;
        int choice;

        do {
            System.out.println("\n=== AUCTION SYSTEM ===");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Place Bid");
            System.out.println("4. Close Auction");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Starting Price: ");
                    double price = sc.nextDouble();
                    auction.addItem(new Item(itemCounter++, name, price));
                }

                case 2 -> auction.showItems();

                case 3 -> {
                    auction.showItems();
                    System.out.print("Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("Bidder (1=Alice, 2=Bob): ");
                    int b = sc.nextInt();
                    System.out.print("Bid Amount: ");
                    double amt = sc.nextDouble();

                    Item item = auction.findItem(id);
                    Bidder bidder = (b == 1) ? b1 : b2;

                    if (item == null) System.out.println("Item not found!");
                    else auction.placeBid(item, bidder, amt);
                }

                case 4 -> {
                    auction.showItems();
                    System.out.print("Close auction for Item ID: ");
                    int id = sc.nextInt();
                    Item item = auction.findItem(id);
                    if (item == null) System.out.println("Item not found!");
                    else auction.closeAuction(item);
                }

                case 5 -> System.out.println("Goodbye!");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}