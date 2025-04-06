import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Player", 0, 0, 0);
        boolean experimentalModeUnlocked = false;
        boolean running = true;
        boolean experimentalModeActive = false;

        while (running) {
            System.out.println("\n Battleship Menu");
            System.out.println("[1] Play Game");
            System.out.println("[2] Enter Shop");
            System.out.println("[3] Options");
            System.out.println("[4] Exit");
            System.out.print("Choose: ");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                GameBoard game = new GameBoard();
            }
            else if (input.equals("2")) {
                System.out.println("\n Shop");
                System.out.println("1. Unlock Experimental Mode (free)");
                System.out.println("2. Return to Main Menu");
                String shopInput = scanner.nextLine();
                if (shopInput.equals("1")) {
                    if (!experimentalModeUnlocked) {
                        experimentalModeUnlocked = true;
                        System.out.println("Experimental Mode unlocked!");
                    } else {
                        System.out.println("You've already unlocked it.");
                    }
                }
                else if (shopInput.equals("2")) {
                    System.out.println("Returning to main menu...");
                }
                else {
                    System.out.println("Invalid choice.");
                }
            }
            else if (input.equals("3")) {
                System.out.println("\n Options");
                if (experimentalModeUnlocked) {
                    System.out.println("Experimental Mode: Unlocked (have fun ig)");
                    System.out.println("Status: " + (experimentalModeActive ? "ON" : "OFF"));
                    System.out.println("Turn on Experimental Mode? (yes/no)");
                    String toggle = scanner.nextLine();
                    if (toggle.equalsIgnoreCase("yes")) {
                        experimentalModeActive = !experimentalModeActive;
                        System.out.println("Experimental Mode is now " + (experimentalModeActive ? "ON" : "OFF"));
                    }
                } else {
                    System.out.println("Experimental Mode: Locked");
                }
            }
            else if (input.equals("4")) {
                System.out.println("Goodbye!");
                running = false;
            }
            else {
                System.out.println("Invalid option.");
            }
        }
    }
}
