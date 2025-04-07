import java.util.Scanner;
import java.util.ArrayList;

public class Player extends Char{
    private String name;
    private int points;
    private int score;
    private int numBomb = 0;
    private int numScoutPlanes = 0;
    Scanner scan = new Scanner(System.in);
    private ArrayList<String> inventory = new ArrayList<>();

    public Player(String name, int score, int points) {
        super(name, score);
        this.points = points;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInv(int idx) {
        inventory.remove(idx);
    }

    public int getPoints() {
        return points;
    }

    public void usePoints(int amount) {
        points -= amount;
    }

    public void addPoints(int amount) {
        points += amount;
    }

    public void addBomb(int amount) {
        numBomb += amount;
    }

    public int getBomb() {
        return numBomb;
    }

    public void addScoutPlanes(int amount) {
        numScoutPlanes += amount;
    }

    public void printInventory() {
        System.out.println(inventory);
    }

    public int getBombs() {
        return numBomb;
    }

    public int getScoutPlanes() {
        return numScoutPlanes;
    }

    @Override
    public void takeTurns(Space[][] AIBoard) {
        boolean turnOngoing = true;
        while (turnOngoing) {
            System.out.println("Row: ");
            int x = scan.nextInt();
            System.out.println("Col: ");
            int y = scan.nextInt();
            Space target = AIBoard[x][y];

            if (!target.isHit()) {
                if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Frigate || target instanceof Submarine) {
                    System.out.println("You hit a ship at (" + x + ", " + y + ")!");
                    target.markAsHit();
                    points ++;
                    addScore(1);
                    printAIBoard(AIBoard);
                    if (gameOver()) {
                        return;
                    }
                } else {
                    System.out.println("You missed at (" + x + ", " + y + ").");
                    target.markAsMiss();
                    turnOngoing = false;
                }
            } else {
                System.out.println("You have already hit this coordinate!");
            }
        }
    }

    public void printAIBoard(Space[][] board) {
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                System.out.print(space.getSymbol());
            }
            System.out.println();
        }
        System.out.println("___________________________________________________________________");
    }

    public boolean checkForAircraftCarrier(Space[][] board) {
        boolean containsAC = false;
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                if (space instanceof AircraftCarrier) {
                    return true;
                }
            }
        }
        return containsAC;
    }

    public boolean checkForSubmarine(Space[][] board) {
        boolean containsSub = false;
        for (Space[] spaces : board) {
            for (Space space : spaces) {
                if (space instanceof Submarine) {
                    return true;
                }
            }
        }
        return containsSub;
    }

    public void useBomb(Space[][] yourBoard, Space[][] opponentBoard) {
        if (!inventory.contains("Bomb")) {
            System.out.println("You don't own any Bombs!");
        } else if (!checkForSubmarine(yourBoard)) {
            System.out.println("You can't use the Bomb without an Submarine!");
        } else {
            boolean outOfBounds = true;
            int row = 0;
            int col = 0;
            System.out.println("The Bomb can hit 3 consecutive spaces horizontally, choose your middle coordinate!");
            while (outOfBounds) {
                System.out.println("Row:");
                row = scan.nextInt();
                System.out.println("Col:");
                col = scan.nextInt();
                if (!(col - 1 < 0 || col + 1 > 9)) {
                    outOfBounds = false;
                    System.out.println("You are going out of bounds choose coordinates again!");
                }
            }
            for (int c = col - 1; c <= col + 1; c++) {
                Space target = opponentBoard[row][c];
                if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Submarine || target instanceof Frigate) {
                   opponentBoard[row][c].markAsHit();
                   addScore(1);
                } else {
                    opponentBoard[row][c].markAsMiss();
                }
            }
        }
    }

    public void useScoutPlane(Space[][] yourBoard, Space[][] opponentBoard) {
        if (!inventory.contains("Scout Plane")) {
            System.out.println("You don't own a scout plane!");
        } else if (!checkForAircraftCarrier(yourBoard)) {
            System.out.println("You can't use the plane without an Aircraft Carrier!");
        } else {
            System.out.println("Would you like the plane to search a row or a column:(R/C) ");
            String choice = scan.nextLine().toUpperCase();
            System.out.println("Which row or column number do you want to search: ");
            int num = scan.nextInt();
            scan.nextLine();
            if (choice.equals("R")) {
                int col = 0;
                while (col <= 9) {
                    Space target = opponentBoard[num][col];
                    if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Submarine || target instanceof Frigate) {
                        opponentBoard[num][col].markAsHit();
                        addScore(1);
                        System.out.println("Your scout plane hit an opponent ship at (" + num + ", " + col + ")");
                        return;
                    } else {
                        opponentBoard[num][col].markAsMiss();
                        col++;
                    }
                }
            } else if (choice.equals("C")){
                int row = 0;
                while (row <= 9) {
                    Space target = opponentBoard[row][num];
                    if (target instanceof Destroyer || target instanceof AircraftCarrier || target instanceof Submarine || target instanceof Frigate) {
                        opponentBoard[row][num].markAsHit();
                        addScore(1);
                        System.out.println("Your scout plane hit an opponent ship at (" + row + ", " + num + ")");
                        return;
                    } else {
                        opponentBoard[row][num].markAsMiss();
                        row++;
                        target = opponentBoard[row][num];
                    }
                }
            }
        }
    }

    public void useExperimentalMode(Space[][] opponentsBoard) {
        points = 999999999;
        for (int r = 0; r < opponentsBoard.length; r++) {
            for (int c = 0; c < opponentsBoard[r].length; c++) {
                Space target = opponentsBoard[r][c];
                if (target instanceof Destroyer) {
                    opponentsBoard[r][c] = new Destroyer("⛴", 4);
                } else if (target instanceof AircraftCarrier) {
                    opponentsBoard[r][c] = new AircraftCarrier("🛳", 6);
                } else if (target instanceof Submarine) {
                    opponentsBoard[r][c] = new Submarine("🚢", 3);
                } else if (target instanceof Frigate) {
                    opponentsBoard[r][c] = new Frigate("⛵", 2);
                }
            }
        }
    }
}
