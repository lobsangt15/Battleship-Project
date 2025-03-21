import java.util.Scanner;

public class Shop extends Player{
    private int priceOfItem;
    private int amountOfStock;
    private int numBombs;
    private int numScoutPlanes;
    private int numRecallPanels;
    private boolean purchasedExperimentalMode;
    Scanner scan = new Scanner(System.in);

    public Shop(String name) {
        super(name);
    }

    public void purchaseMenu() {
        System.out.println("What would you like to purchase?");
        System.out.println("(1) Bomb (consumable): 1 points.");
        System.out.println("(2) Scout Planes (consumable): 5 points.");
        System.out.println("(3) Recall Panel (consumable): 10 points.");
        System.out.println("(4) Experimental Mode (toggable): 0 points.");
        System.out.println();
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();

        System.out.println("How many would you like to buy?");
        int amount = scan.nextInt();

        switch (choice) {
            case 1:
                purchaseBomb(amount);
                break;
            case 2:
                purchaseScoutPlanes(amount);
                break;
            case 3:
                purchaseRecallPanel(amount);
                break;
            case 4:
                purchaseExperimentalMode(amount);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void purchaseBomb(int amount) {
        double cost = amount * 3;
        if (getPoints() >= cost) {
            numBombs += amount;

            System.out.println("You purchased " + amount + " Bomb(s). Total Bombs: " + numBombs);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseScoutPlanes(int amount) {
        double cost = amount * 5;
        if (getPoints() >= cost) {
            numScoutPlanes += amount;
            System.out.println("You purchased " + amount + " Scout Plane(s). Total Scout Planes: " + numScoutPlanes);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseRecallPanel(int amount) {
        double cost = amount * 10;
        if (getPoints() >= cost) {
            numRecallPanels += amount;
            System.out.println("You purchased " + amount + " Recall Panel(s). Total Recall Panels: " + numRecallPanels);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseExperimentalMode(int amount) {
        double cost = amount * 0;
        if (getPoints() >= cost) {
            numBombs += amount;
            if (amount > 1) {
                System.out.println("You have already bought Experimental Mode.");
            } else {
                if (getPoints() >= cost) {
                    System.out.println("You've purchased Experimental Mode.");
                } else {
                    System.out.println("You do not have enough money");
                }
            }
        }
    }
}