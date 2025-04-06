import java.util.Scanner;

public class GameBoard {
    private Space [][] AIboard;
    private Space [][] PlayerBoard;
    private Player player;
    private Scanner scanner;


    public GameBoard() {
        scanner = new Scanner(System.in);
        setupAIBoard();
        play();
    }

    public void setupHorizontly(Space shipType, Space[][] board, int startRow, int startCol, int shipSize, String direction) {
        String symbol = "";
        if (board == AIboard) {
            symbol = "☐";
        } else {
            if (shipType instanceof Battleship) {
                symbol = "⛴";
            } else if (shipType instanceof AircraftCarrier) {
                symbol = "🛳";
            } else if (shipType instanceof UnmannedShip) {
                symbol = "⛵";
            } else {
                symbol =
            }
        }
        if (direction.equals("R")) {
            if (startCol + shipSize > 10) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Battleship battleship -> board[startRow][startCol + i] = new Battleship(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow][startCol + i] = new AircraftCarrier(symbol, 6, true);
                    case UnmannedShip unmannedShip -> board[startRow][startCol + i] = new UnmannedShip(symbol, 2, false);
                    case null, default -> board[startRow][startCol + i] = new Battleship(symbol, 3);
                }
            }
        } else {
            if (startCol - shipSize < 0) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Battleship battleship -> board[startRow][startCol - i] = new Battleship(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow][startCol - i] = new AircraftCarrier(symbol, 6, true);
                    case UnmannedShip unmannedShip -> board[startRow][startCol - i] = new UnmannedShip(symbol, 2, false);
                    //change to sub//
                    case null, default -> board[startRow][startCol - i] = new Battleship(symbol, 3);
                }
            }
        }
    }

    public void setupVertically(Space shipType, Space[][] board, int startRow, int startCol, int shipSize, String direction) {
        String symbol = "";
        if (board == AIboard) {
            symbol = "☐";
        } else {
            if (shipType instanceof Battleship) {
                symbol = "⛴";
            } else if (shipType instanceof AircraftCarrier) {
                symbol = "🛳";
            } else if (shipType instanceof UnmannedShip) {
                symbol = "⛵";
            } else {
                symbol =
            }
        }
        if (direction.equals("U")) {
            if (startRow + shipSize > 10) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Battleship battleship -> board[startRow + i][startCol] = new Battleship(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow + i][startCol] = new AircraftCarrier(symbol, 6, true);
                    case UnmannedShip unmannedShip -> board[startRow + i][startCol] = new UnmannedShip(symbol, 2, false);
                    case null, default -> board[startRow + i][startCol] = new Battleship(symbol, 3);
                }
            }
        } else {
            if (startCol - shipSize < 0) {
                System.out.println("Your ship is going out of bounds, choose another coordinate!");
                return;
            }
            for (int i = 0; i < shipSize; i++) {
                switch (shipType) {
                    case Battleship battleship -> board[startRow - i][startCol] = new Battleship(symbol, 4);
                    case AircraftCarrier aircraftCarrier -> board[startRow - i][startCol] = new AircraftCarrier(symbol, 6, true);
                    case UnmannedShip unmannedShip -> board[startRow - i][startCol] = new UnmannedShip(symbol, 2, false);
                    case null, default -> board[startRow - i][startCol] = new Battleship(symbol, 3);
                }
            }
        }
    }

