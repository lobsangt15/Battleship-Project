import java.util.Scanner;

public class Shop {
    private int priceOfItem;
    private int amountOfStock;
    private int numBombs;
    private int numScoutPlanes;
    private int numRecallPanels;
    private boolean purchasedExperimentalMode;
    Scanner scan = new Scanner(System.in);

    public void purchaseMenu() {
        System.out.println("What would you like to purchase?");
        System.out.println("(1) Bomb (consumable): 1 points");
        System.out.println("(2) Scout Planes (consumable):  ");
        System.out.println("(3) Recall Panel (consumable)");
        System.out.println("(4) Experimental Mode (toggable): ");
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
        double cost = amount * 40000;
        if (Player.getBalance() >= cost) {
            numBombs += amount;

            System.out.println("You purchased " + amount + " Bomb(s). Total cars: " + numCars);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseScoutPlanes(int amount) {
        double cost = amount * 600000;
        if (Player.getBalance() >= cost) {
            numScoutPlanes += amount;
            System.out.println("You purchased " + amount + " Scout Plane(s). Total Scout Planes: " + numScoutPlanes);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseRecallPanel(int amount) {
        double cost = amount * 2000000;
        if (Player.getBalance() >= cost) {
            numRecallPanels += amount;
            System.out.println("You purchased " + amount + " Recall Panel(s). Total Recall Panels: " + numRecallPanels);
        } else {
            System.out.println("You do not have enough money!");
        }
    }

    private void purchaseExperimentalMode(int amount) {
        double cost = amount * 1500000;
        if (Player.getBalance() >= cost) {
            purchasedExperimentalMode = true;
            System.out.println("You purchased Experimental Mode! Have fun!");
        } else {
            System.out.println("You do not have enough money!");
        }
    }
}
