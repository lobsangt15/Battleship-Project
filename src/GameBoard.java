import java.util.Scanner;

public class GameBoard {
    private Space [][] AIboard;
    private Space [][] PlayerBoard;
    private Player player;
    private Scanner scan;
    private AI ai;
    private Player player1;
    private Shop shop;
    boolean experimentalModeUnlocked = false;
    boolean running = true;
    boolean experimentalModeActive = false;


    public GameBoard() {
        scan = new Scanner(System.in);
        ai = new AI(this);
        System.out.println("What is your name: ");
        String name = scan.nextLine();
        player1 = new Player(name, 6, 0, 0);
        shop = new Shop(player1);
        setupAIBoard();
        setUpPlayerBoard();
        System.out.println("Opponents Board: ");
        printAIBoard();
        System.out.println("Your Board: ");
        printPlayerBoard();
        menu();
    }

    public void play() {
        System.out.println(player1.getName() + "'s turn: ");
        player1.PlayerTurn(AIboard);
        printAIBoard();
        System.out.println("AI's turn: ");
        ai.AITurn(PlayerBoard);
        printPlayerBoard();
    }

    private boolean setupHorizontally(Space shipType, Space[][] board, int startRow, int startCol, int shipSize, String direction) {
        String symbol = "";
        if (board == AIboard) {
            symbol = "☐";
        } else {
            if (shipType instanceof Destroyer) {
                symbol = "⛴";
            } else if (shipType instanceof AircraftCarrier) {
                symbol = "🛳";
            } else if (shipType instanceof Frigate) {
                symbol = "⛵";
            } else {
                symbol = "🚢";
            }
        }
        if (direction.equals("R")) {
            if (startCol + shipSize > 10) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Destroyer destroyer -> board[startRow][startCol + i] = new Destroyer(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow][startCol + i] = new AircraftCarrier(symbol, 6, false);
                    case Frigate frigate -> board[startRow][startCol + i] = new Frigate(symbol, 2);
                    case null, default -> board[startRow][startCol + i] = new Submarine(symbol, 3, false);
                }
            }
        } else {
            if (startCol - shipSize < 0) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Destroyer destroyer -> board[startRow][startCol - i] = new Destroyer(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow][startCol - i] = new AircraftCarrier(symbol, 6, false);
                    case Frigate unmannedShip -> board[startRow][startCol - i] = new Frigate(symbol, 2);
                    case null, default -> board[startRow][startCol - i] = new Submarine(symbol, 3, false);
                }
            }
        }
        return true;
    }

    private boolean setupVertically(Space shipType, Space[][] board, int startRow, int startCol, int shipSize, String direction) {
        String symbol = "";
        if (board == AIboard) {
            symbol = "☐";
        } else {
            if (shipType instanceof Destroyer) {
                symbol = "⛴";
            } else if (shipType instanceof AircraftCarrier) {
                symbol = "🛳";
            } else if (shipType instanceof Frigate) {
                symbol = "⛵";
            } else {
                symbol = "🚢";
            }
        }
        if (direction.equals("D")) {
            if (startRow + shipSize > 10) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Destroyer destroyer -> board[startRow + i][startCol] = new Destroyer(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow + i][startCol] = new AircraftCarrier(symbol, 6, false);
                    case Frigate frigate -> board[startRow + i][startCol] = new Frigate(symbol, 2);
                    case null, default -> board[startRow + i][startCol] = new Submarine(symbol, 3, false);
                }
            }
        } else {
            if (startCol - shipSize < 0) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return false;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Destroyer destroyer -> board[startRow - i][startCol] = new Destroyer(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow - i][startCol] = new AircraftCarrier(symbol, 6, false);
                    case Frigate frigate -> board[startRow - i][startCol] = new Frigate(symbol, 2);
                    case null, default -> board[startRow - i][startCol] = new Submarine(symbol, 3, false);
                }
            }
        }
        return true;
    }

    public void setupAIBoard() {
        AIboard = new Space[10][10];
        for (int r = 0; r < AIboard.length; r++) {
            for (int c = 0; c < AIboard[r].length; c++) {
                if (AIboard[r][c] == null) {
                    AIboard[r][c] = new Space("☐", 0);
                }
            }
        }
        int randomPreset = (int) (Math.random() * 4) + 1;
        if (randomPreset == 1) {
            Space Destroyer = new Destroyer("⛴", 4);
            setupHorizontally(Destroyer, AIboard, 3, 1, 4, "R");
            Space aircraftCarrier = new AircraftCarrier("🛳", 6, false);
            setupVertically(aircraftCarrier, AIboard, 2, 9, 6, "D");
            Space frigate = new Frigate("⛵", 2);
            setupHorizontally(frigate, AIboard, 8, 1, 2, "R");
            Space submarine = new Submarine("🚢", 3, false);
            setupHorizontally(submarine, AIboard, 9, 4, 3, "R");
        } else if (randomPreset == 2) {
            Space Destroyer = new Destroyer("⛴", 4);
            setupHorizontally(Destroyer, AIboard, 3, 4, 4, "R");
            Space aircraftCarrier = new AircraftCarrier("🛳", 6, false);
            setupHorizontally(aircraftCarrier, AIboard, 1, 2, 6, "R");
            Space frigate = new Frigate("⛵", 2);
            setupHorizontally(frigate, AIboard, 7, 7, 2, "R");
            Space submarine = new Submarine("🚢", 3, false);
            setupVertically(submarine, AIboard, 6, 1, 3, "D");
        } else if (randomPreset == 3) {
            Space Destroyer = new Destroyer("⛴", 4);
            setupVertically(Destroyer, AIboard, 5, 9, 4, "D");
            Space aircraftCarrier = new AircraftCarrier("🛳", 6, false);
            setupVertically(aircraftCarrier, AIboard, 0, 4, 6, "D");
            Space frigate = new Frigate("⛵", 2);
            setupHorizontally(frigate, AIboard, 7, 7, 2, "R");
            Space submarine = new Submarine("🚢", 3, false);
            setupHorizontally(submarine, AIboard, 4, 0, 3, "R");
        } else {
            Space Destroyer = new Destroyer("⛴", 4);
            setupHorizontally(Destroyer, AIboard, 5, 3, 4, "R");
            Space aircraftCarrier = new AircraftCarrier("🛳", 6, false);
            setupHorizontally(aircraftCarrier, AIboard, 3, 0, 6, "R");
            Space frigate = new Frigate("⛵", 2);
            setupHorizontally(frigate, AIboard, 2, 2, 2, "R");
            Space submarine = new Submarine("🚢", 3, false);
            setupVertically(submarine, AIboard, 7, 6, 3, "D");
        }
    }

    private void setUpPlayerBoard() {
        PlayerBoard = new Space[10][10];
        for (int r = 0; r < PlayerBoard.length; r++) {
            for (int c = 0; c < PlayerBoard[r].length; c++) {
                if (PlayerBoard[r][c] == null) {
                    PlayerBoard[r][c] = new Space("☐", 0);
                }
            }
        }
        boolean destroyerPlaced = false;
        boolean aircraftCarrierPlaced = false;
        boolean frigatePlaced = false;
        boolean submarinePlaced = false;
        System.out.println("Lets first place down our Destroyer!");
        Destroyer destroyer = new Destroyer("⛴", 4);
        while (!destroyerPlaced) {
            System.out.println("Row: ");
            int row = scan.nextInt();
            System.out.println("Column: ");
            int col = scan.nextInt();
            System.out.println("Horizontally or Vertically (H/V): ");
            scan.nextLine();
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Which direction (R/L): ");
                String direction = scan.nextLine().toUpperCase();
                destroyerPlaced = setupHorizontally(destroyer, PlayerBoard, row, col, 4, direction);
            } else {
                System.out.println("Which direction (U/D): ");
                String direction = scan.nextLine().toUpperCase();
                destroyerPlaced = setupVertically(destroyer, PlayerBoard, row, col, 4, direction);
            }
        }
        printPlayerBoard();
        System.out.println("Lets place down our Aircraft Carrier!");
        Space aircraftCarrier = new AircraftCarrier("🛳", 6, false);
        while (!aircraftCarrierPlaced) {
            System.out.println("Row: ");
            int row = scan.nextInt();
            System.out.println("Column: ");
            int col = scan.nextInt();
            System.out.println("Horizontally or Vertically (H/V): ");
            scan.nextLine();
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Which direction (R/L): ");
                String direction = scan.nextLine().toUpperCase();
                aircraftCarrierPlaced = setupHorizontally(aircraftCarrier, PlayerBoard, row, col, 6, direction);
            } else {
                System.out.println("Which direction (U/D): ");
                String direction = scan.nextLine().toUpperCase();
                aircraftCarrierPlaced = setupVertically(aircraftCarrier, PlayerBoard, row, col, 6, direction);
            }
        }
        printPlayerBoard();
        System.out.println("Lets place down our Frigate!");
        Space frigate = new Frigate("⛵", 2);
        while (!frigatePlaced) {
            System.out.println("Row: ");
            int row = scan.nextInt();
            System.out.println("Column: ");
            int col = scan.nextInt();
            System.out.println("Horizontally or Vertically (H/V): ");
            scan.nextLine();
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Which direction (R/L): ");
                String direction = scan.nextLine().toUpperCase();
                frigatePlaced = setupHorizontally(frigate, PlayerBoard, row, col, 2, direction);
            } else {
                System.out.println("Which direction (U/D): ");
                String direction = scan.nextLine().toUpperCase();
                frigatePlaced = setupVertically(frigate, PlayerBoard, row, col, 2, direction);
            }
        }
        printPlayerBoard();
        System.out.println("Lets place down our Submarine!");
        Space submarine = new Submarine("🚢", 3, false);
        while (!submarinePlaced) {
            System.out.println("Row: ");
            int row = scan.nextInt();
            System.out.println("Column: ");
            int col = scan.nextInt();
            System.out.println("Horizontally or Vertically (H/V): ");
            scan.nextLine();
            String choice = scan.nextLine().toUpperCase();
            if (choice.equals("H")) {
                System.out.println("Which direction (R/L): ");
                String direction = scan.nextLine().toUpperCase();
                submarinePlaced = setupHorizontally(submarine, PlayerBoard, row, col, 3, direction);
            } else {
                System.out.println("Which direction (U/D): ");
                String direction = scan.nextLine().toUpperCase();
                submarinePlaced = setupVertically(submarine, PlayerBoard, row, col, 3, direction);
            }
        }
        printPlayerBoard();
        System.out.println("Let the game begin!!!");
    }

    public void printAIBoard() {
        for (Space[] spaces : AIboard) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }

    public void printPlayerBoard() {
        for (Space[] spaces : PlayerBoard) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }

    public void menu() {
        while (running) {
            System.out.println("\n Battleship Menu");
            System.out.println("[1] Attack");
            System.out.println("[2] Use Items");
            System.out.println("[3] Enter Shop");
            System.out.println("[4] Exit");
            System.out.print("Choose: ");
            String input = scan.nextLine();
            if (input.equals("1")) {
                play();
            } else if (input.equals("2")) {
                if (player1.getInventory() == null) {
                    System.out.println("You don't own any items!");
                } else {
                    player1.printInventory();
                    System.out.println("Which item would you like to use:(Input item idx:)");
                    int idx = scan.nextInt();
                    if (player1.getInventory().get(idx).equals("Torpedo")) {
                        player1.useBomb();
                        player1.removeFromInv(idx);
                    } else if (player1.getInventory().get(idx).equals("Scout Plane")) {
                        player1.useScoutPlane(PlayerBoard, AIboard);
                        player1.removeFromInv(idx);
                    } else if (player1.getInventory().get(idx).equals("Experimental Mode")) {
                        player1.useExperimentalMode(AIboard);
                        player1.removeFromInv(idx);
                    }
                    System.out.println("Opponents Board: ");
                    printAIBoard();
                }
            } else if (input.equals("3")) {
                shop.purchaseMenu();
                System.out.println("\n Shop");
                System.out.println("1. Keep shopping");
                System.out.println("2. Return to Main Menu");
                String shopInput = scan.nextLine();
                if (shopInput.equals("1")) {
                    shop.purchaseMenu();
                } else if (shopInput.equals("2")) {
                    System.out.println("Returning to main menu...");
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (input.equals("4")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
        if (gameOver()) {
            if (player1.getScore() == 15) {
                System.out.println(player1.getName() + " has defeated the AI!");
            } else {
                System.out.println("The AI has defeated " + player1.getName() + "!");
            }
            running = false;
        }
    }

    public boolean gameOver() {
        return player1.getScore() == 15 || ai.getScore() == 15;
    }
}

