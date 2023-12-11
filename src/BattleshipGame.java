import java.util.Scanner;

/**
 * the main class; that is, it contains a main method.
 * In this class, you will set up the game,
 * accept shots from the user as coordinates,
 * display the results,
 * print final scores,
 * and ask the user if they want to play again
 * @author Grace
 *
 */
public class BattleshipGame {
    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {
            Ocean ocean = new Ocean();
            ocean.placeAllShipsRandomly();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (ocean.ships[i][j].getShipType().equals("empty")) {
                        System.out.print(". ");
                    } else if (ocean.ships[i][j].getShipType().equals("Battleship")) {
                        System.out.print("B ");
                    } else if (ocean.ships[i][j].getShipType().equals("Cruiser")) {
                        System.out.print("C ");
                    } else if (ocean.ships[i][j].getShipType().equals("Destroyer")) {
                        System.out.print("D ");
                    } else if (ocean.ships[i][j].getShipType().equals("Submarine")) {
                        System.out.print("S ");
                    }
                }
                System.out.println();
            }

            Scanner scanner = new Scanner(System.in);
            int shootRow = -1;
            int shootColumn = -1;
            while (!ocean.isGameOver()) {
                ocean.print();
                boolean validInput = false;
                while (!validInput) {
                    // Get user input for row and column coordinates
                    System.out.print("Enter row number (0 to 9): ");
                    if (scanner.hasNextInt()) {
                        shootRow = scanner.nextInt();
                        if (shootRow <= -1 || shootRow >= 10) {
                            System.out.println("Please enter a row number between 0 and 9.");
                            continue;
                        }
                    } else {
                        String input = scanner.next();
                        System.out.println("Invalid input '" + input + "'. Please enter a row number between 0 and 9.");
                        continue;
                    }
                    System.out.print("Enter column number (0 to 9): ");
                    if (scanner.hasNextInt()) {
                        shootColumn = scanner.nextInt();
                        if (shootColumn <= -1 || shootColumn >= 10) {
                            System.out.println("Please enter a column number between 0 and 9.");
                            continue;
                        }
                    } else {
                        String input = scanner.next();
                        System.out.println("Invalid input '" + input + "'. Please enter a column number between 0 and 9.");
                        continue;
                    }
                    validInput = true;
                }
                Ship[][] shipsArray = ocean.getShipArray();
                boolean userShotShip = ocean.shootAt(shootRow, shootColumn);
                if (!userShotShip) {
                    System.out.println("miss!");
                } else {
                    System.out.println("hit!");
                    if (ocean.ships[shootRow][shootColumn].isSunk()) {
                        System.out.println("You just sunk a " + shipsArray[shootRow][shootColumn].getShipType());
                    }
                }
            }
            scanner.close();
            System.out.println("Game over! Congratulations, your total score is " + ocean.shotsFired + ", and total hit is " + ocean.getHitCount());
            boolean validPlayAgain = false;
            while (!validPlayAgain) {
                System.out.println("Do you want to play again? Please type 'Yes' or 'No'.");
                String userPlayAgain = scanner.next();
                if (userPlayAgain.equals("Yes")) {
                    validPlayAgain = true;
                } else if (userPlayAgain.equals("No")) {
                    validPlayAgain = true;
                    playAgain = false;
                }
            }
        }
    }
}
