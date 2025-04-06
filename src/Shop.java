import java.util.Scanner;

public class Shop extends Player{
    private int priceOfItem;
    private int amountOfStock;
    private int numBombs;
    private int numScoutPlanes;
    private int numRecallPanels;
    private boolean purchasedExperimentalMode;
    Scanner scan = new Scanner(System.in);


    public Shop(String name, int points, int score, int moves) {
        super(name, points, score, moves);

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
        int cost = amount * 3;
        amountOfStock = 5;
        System.out.println("There are " + amountOfStock + " Bomb(s) available for purchase, for 3 points.");
        if (getPoints() >= cost) {
            numBombs += amount;
            System.out.println("You purchased " + amount + " Bomb(s). Total Bombs: " + numBombs);
            amountOfStock--;
            usePoints(cost);
            System.out.println(getName() + " now has " + getPoints() + " points.");
        } else {
            System.out.println("You do not have enough money!");
        }
        if (amountOfStock < 1) {
            System.out.println("Restocking immediately!");
            amountOfStock++;
        }
    }

    private void purchaseScoutPlanes(int amount) {
        int cost = amount * 5;
        amountOfStock = 3;
        System.out.println("There are " + amountOfStock + " Scout Plane(s) available for purchase, for 5 points.");
        if (getPoints() >= cost) {
            numScoutPlanes += amount;
            System.out.println("You purchased " + amount + " Scout Plane(s). Total Scout Planes: " + numScoutPlanes);
            amountOfStock--;
            usePoints(cost);
            System.out.println(getName() + " now has " + getPoints() + " points.");
        } else {
            System.out.println("You do not have enough money!");
        }
        if (amountOfStock < 1) {
            System.out.println("Restocking immediately!");
            amountOfStock++;
        }
    }

    private void purchaseRecallPanel(int amount) {
        int cost = amount * 10;
        amountOfStock = 2;
        System.out.println("There are " + amountOfStock + " Recall Panel(s) available for purchase, for 10 points.");
        if (getPoints() >= cost) {
            numRecallPanels += amount;
            System.out.println("You purchased " + amount + " Recall Panel(s). Total Recall Panels: " + numRecallPanels);
            amountOfStock--;
            usePoints(cost);
            System.out.println(getName() + " now has " + getPoints() + " points.");
        } else {
            System.out.println("You do not have enough money!");
        }
        if (amountOfStock < 1) {
            System.out.println("Restocking immediately!");
            amountOfStock++;
        }
    }

    private void purchaseExperimentalMode(int amount) {
        int cost = 0;
        amountOfStock = 1;
        System.out.println("You can buy Experimental Mode here. It's a free gamemode in which you can toy around with the game and cheat your way to victory.");
            if (amount > 1) {
                System.out.println("You have already bought Experimental Mode.");
            } else {
                if (getPoints() >= cost) {
                    System.out.println("You've purchased Experimental Mode.");
                    amountOfStock--;
                    usePoints(cost);
                    System.out.println(getName() + " now has " + getPoints() + " points.");
                } else {
                    System.out.println("You do not have enough money");
                }
            }
        }
    }
