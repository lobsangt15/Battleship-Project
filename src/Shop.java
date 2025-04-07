import java.util.Scanner;

public class Shop {
    private int priceOfItem;
    private int amountOfStock;
    private int numTorpedo;
    private int numScoutPlanes;
    private int numRecallPanels;
    private boolean purchasedExperimentalMode;
    private final Player player;
    Scanner scan = new Scanner(System.in);



    public Shop(Player player) {
        this.player = player;
    }

    public void purchaseMenu() {
        System.out.println("What would you like to purchase?");
        System.out.println("(1) Bomb (consumable): 3 points.");
        System.out.println("(2) Scout Planes (consumable): 6 points.");
        System.out.println("(3) Experimental Mode (toggable): 0 points.");
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
                purchaseExperimentalMode(amount);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void purchaseBomb(int amount) {
        System.out.println("Your submarine must still be alive to use this item!, is your submarine alive?(Y/N): ");
        scan.nextLine();
        String answer = scan.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            int cost = amount * 3;
            amountOfStock = 5;
            System.out.println("There are " + amountOfStock + " Bombs(s) available for purchase, for 3 points.");
            if (player.getPoints() >= cost) {
                numTorpedo += amount;
                System.out.println("You purchased " + amount + " Bomb(s). Total Bomb(s): " + numTorpedo);
                amountOfStock--;
                player.usePoints(cost);
                System.out.println(player.getName() + " now has " + player.getPoints() + " points.");
                for (int i = 0; i < amount; i++) {
                    player.addToInventory("Bomb");
                }
            } else if (amount > amountOfStock) {
                System.out.println("We don't have that much in stock!");
            } else {
                System.out.println("You do not have enough money!");
            }
            if (amountOfStock < 1) {
                System.out.println("Restocking immediately!");
                amountOfStock++;
            }
        }
    }

    private void purchaseScoutPlanes(int amount) {
        System.out.println("Your Aircraft Carrier must be still alive to use this!, is your Aircraft carrier still alive?(Y/N): ");
        scan.nextLine();
        String answer = scan.nextLine().toUpperCase();
        if (answer.equals("Y")) {
            int cost = amount * 6;
            amountOfStock = 3;
            System.out.println("There are " + amountOfStock + " Scout Plane(s) available for purchase, for 5 points.");
            if (player.getPoints() >= cost) {
                numScoutPlanes += amount;
                System.out.println("You purchased " + amount + " Scout Plane(s). Total Scout Planes: " + numScoutPlanes);
                amountOfStock--;
                player.usePoints(cost);
                System.out.println(player.getName() + " now has " + player.getPoints() + " points.");
                for (int i = 0; i < amount; i++) {
                    player.addToInventory("Scout Plane");
                }
            } else if (amount > amountOfStock) {
                System.out.println("We don't have that much in stock!");
            } else {
                System.out.println("You do not have enough money!");
            }
            if (amountOfStock < 1) {
                System.out.println("Restocking immediately!");
                amountOfStock++;
            }
        }
    }

    private void purchaseExperimentalMode(int amount) {
        int cost = 0;
        amountOfStock = 1;
        System.out.println("You can buy Experimental Mode here. It's a free game mode in which you can toy around with the game and cheat your way to victory.");
            if (amount > 1) {
                System.out.println("You have already bought Experimental Mode.");
            } else {
                if (player.getPoints() >= cost) {
                    System.out.println("You've purchased Experimental Mode.");
                    amountOfStock--;
                    player.usePoints(cost);
                    System.out.println(player.getName() + " now has " + player.getPoints() + " points.");
                    player.addToInventory("Experimental Mode");
                }
            }
        }
    }
