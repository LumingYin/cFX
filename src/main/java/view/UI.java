package view;

import java.util.Scanner;
import java.util.Random;
import controller.GameController;

public class UI {
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void start() throws Exception {
        System.out.println("Welcome to Civilization! Which civilization would"
            + " you like to build?\n"
            + "1. Ancient Egypt\n"
            + "2. Qin Dynasty\n"
            + "3. Roman Empire\n");

        int civChoice = 0;
        while (!GameController.chooseCivilization(civChoice)) {
            civChoice = scan.nextInt();
            scan.nextLine();
        }

        play();
    }

    public static void play() {
        System.out.println("\nWhat would you like to name your first town?\n");
        String name = scan.nextLine();
        GameController.addFirstSettlement(name);

        while (GameController.playing()) {
            System.out.println(GameController.gameScreen());
            System.out.println("What would you like to do?\n"
                + "1. Manage Units\n"
                + "2. Explore\n"
                + "3. Quit\n");
            int response = scan.nextInt();
            scan.nextLine();
            GameController.turnOption(response);
            GameController.tick();
            if (GameController.checkWin()) {
                System.out.println("Congratulations! You won!!! :D");
                GameController.end();
            }
        }
    }

    public static void manage() {
        boolean turnOver = false;
        while (!turnOver) {
            System.out.println("Enter the number of the hex you would like to "
                + "select, or press [ENTER] to end your turn:\n");
            String input = scan.nextLine();
            if (input.length() < 2) {
                turnOver = true;
            }
            if (!turnOver) {
                GameController.selectTile(input.charAt(0) - 48,
                    input.charAt(1) - 48);
                String path = GameController.selectedOptions();
                switch (path) {
                case "BUILDING":
                    buildingOptions();
                    break;
                case "MILITARY_UNIT":
                    unitOptions(true);
                    break;
                case "WORKER_UNIT":
                    unitOptions(false);
                    break;
                case "RECRUIT_SPACE":
                    recruitOptions();
                    break;
                default:
                    System.out.println(path);
                }
                System.out.println(GameController.gameScreen());
            }
        }
    }

    public static void buildingOptions() {
        System.out.println("You selected "
            + GameController.selectedMapObjectString()
            + "\nWhat you would like to do?\n"
            + "1. Invest\n"
            + "2. Demolish\n"
            + "3. Quit\n");
        int response = scan.nextInt();
        scan.nextLine();
        switch (response) {
        case 1:
            if (GameController.investSelected()) {
                System.out.println("Building upgraded!");
            } else {
                System.out.println("Your funds are insufficient to invest!");
            }
            break;
        case 2:
            if (GameController.demolishSelected()) {
                System.out.println("Building demolished for resources!");
            } else {
                System.out.println("You cannot demolish your last settlement!");
            }
            break;
        default:
            break;
        }
    }

    public static void unitOptions(boolean military) {
        System.out.println("You selected "
            + GameController.selectedMapObjectString()
            + "\nWhat would you like to do?\n"
            + "1. Move\n"
            + "2. " + (military ? "Attack" : "Convert") + "\n"
            + "3. Quit");
        int response = scan.nextInt();
        scan.nextLine();
        String tile;
        switch (response) {
        case 1:
            System.out.println("Enter in the number of the adjacent tile"
                + " you'd like to move your unit to:\n");
            tile = scan.nextLine();
            if (GameController.moveSelected(tile.charAt(0) - 48,
                tile.charAt(1) - 48)) {
                System.out.println("Moved unit!");
            } else {
                System.out.println("Could not move unit!");
            }
            break;
        case 2:
            if (military) {
                System.out.println("Enter in the number of the adjacent tile"
                    + " containing your target:\n");
                tile = scan.nextLine();
                if (GameController.attackSelected(tile.charAt(0) - 48,
                    tile.charAt(1) - 48)) {
                    System.out.println("Enemy attacked!");
                } else {
                    System.out.println("Could not attack!");
                }
            } else {
                if (GameController.convertSelected()) {
                    System.out.println("Building created!");
                } else {
                    System.out.println("The unit can't build there.");
                }
            }
            break;
        default:
            break;
        }
    }

    public static void recruitOptions() {
        System.out.println("You selected a tile adjacent to a Settlement"
            + "\nWhat would you like to do?\n"
            + "1. Recruit\n"
            + "2. Quit\n");
        int response = scan.nextInt();
        scan.nextLine();
        if (response == 1) {
            System.out.println("What kind of unit would you like to recruit?\n"
                + "1. Melee Unit\n"
                + "2. Ranged Unit\n"
                + "3. Hybrid Unit\n"
                + "4. Siege Unit\n"
                + "5. Settlers\n"
                + "6. Farmers\n"
                + "7. Coal Miners\n"
                + "8. Anglers\n"
                + "9. Master Builders\n");
            response = scan.nextInt();
            scan.nextLine();
            String name = "";
            if (response == 5) {
                System.out.println("Name the town your travelers will settle!");
                name = scan.nextLine();
            }
            if (GameController.recruitSelected(response, name)) {
                System.out.println("Unit recruited!");
            } else {
                System.out.println("Recruitment failed!");
            }
        }
    }

    public static void explore() {
        System.out.println(GameController.explore());
    }
}
