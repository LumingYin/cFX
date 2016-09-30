// This is the HW0 file. 
// Checkstyle should not be required per CS1331.gatech.edu

import java.util.Scanner;

public class Civilization {
    private static String userName = new String();
    private static boolean playing = true;

    // User's properties
    private static String[] cities = new String[5];
    private static int cachedNumberOfCities = 0;
    private static int numberOfAttacks = 0;
    private static double gold = 20.5;
    private static double resources = 30;
    private static int happiness = 10;
    private static int millitaryUnits = 0;
    private static int technology = 0;
    private static boolean isFirstRun = true;

    public static void main(String[] args) {
        while (playing) {
            if (isFirstRun) {
                selectCivilization();
            }
            preNewRoundScript();
        }
        System.out.println("CONGRATULATIONS!");
        System.out.printf("You have successfully won the game, %s!", userName);
        endGameReset();
    }

    public static void pressEnterToContinue() {
        System.out.printf("Press ENTER key to Continue: ");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Try again?");
        }
    }

    public static void endGameReset() {
        System.out.printf("Press ENTER key to play again: ");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println("Try again?");
        }
        selectPerformableAction();
        userName = null;
        cities[0] = null;
        cities[1] = null;
        cities[2] = null;
        cities[3] = null;
        cities[4] = null;
        cachedNumberOfCities = 0;
        numberOfAttacks = 0;
        gold = 20.5;
        resources = 30;
        happiness = 10;
        millitaryUnits = 0;
        technology = 0;
        playing = true;
        isFirstRun = true;
    }

    public static void selectCivilization() {
        System.out.println();
        System.out.println();
        System.out.println("Hi! Welcome to Civilization!");
        System.out.println("Before starting, you need to lead a civilization.");
        System.out.println("Which civilization would you like to lead?");
        System.out.println();
        System.out.println("CHOICES");
        System.out.println("===========================================");
        System.out.println("[1]     American (George Washionton)");
        System.out.println("[2]         Zulu (Shaka)");
        System.out.println("[3]      English (Queen Elizabeth I)");
        System.out.println("[4]      Chinese (Wu Ze Tian)");
        System.out.println("===========================================");
        System.out.print("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter one of the given options - which is number 1, 2, 3 or 4.");
            System.out.print("Your Choice: ");
            sc.next();
        }
        int selectedCivillization = sc.nextInt();
        if (selectedCivillization == 1) {
            userName = "George Washionton";
        } else if (selectedCivillization == 2) {
            userName = "Shaka";
        } else if (selectedCivillization == 3) {
            userName = "Queen Elizabeth I";
        } else if (selectedCivillization == 4) {
            userName = "Wu Ze Tian";
        } else {
            System.out.println("You need to choose between number 1 to 4. Let's give it another shot.");
            selectCivilization();
        }
        System.out.println();
        System.out.printf("Good choice, %s!\n", userName);
        System.out.printf("To help you get started, you are provided with 20.5 Gold, 30 Resources and 10 Happiness.");
        reviewCurrentAssets();
        System.out.printf("Now, it's time to settle your first city!\n");
        System.out.printf("The first city you settle will be free. After you successfully settle your first city, you will recieve 3 gold for the city.\n");
        settleCity();
    }

    public static void preNewRoundScript() {
        if (happiness > 20) {
            resources = resources + 5 * cachedNumberOfCities;
        } else {
            resources = resources + 1;
        }
        gold = gold + 3 * cachedNumberOfCities;
        int roundedResources = (int) Math.round(resources);
        if (roundedResources % 2 == 0) {
            happiness = happiness + 1;
        } else {
            happiness = happiness - 3;
        }

        if (technology >= 20 || numberOfAttacks >= 10) {
            playing = false;
        } else {
            selectPerformableAction();
            System.out.println();
            System.out.println("A new round has begun!");
        }
    }

    public static void selectPerformableAction() {
        sortCitiesArray();
        reviewCurrentAssets();
        pressEnterToContinue();
        newActions();
    }

    public static void reviewCurrentAssets() {
        System.out.println("Let's review what you already own.");
        System.out.println("============== OWNERSHIP ==================");
        if (cachedNumberOfCities > 1) {
            System.out.printf("       %d Cities | ", cachedNumberOfCities);
            for (int i = 0; i <= 4; i++) {
                if (cities[i] != null) {
                    if (i > 0 && i < 5) {
                        System.out.printf(", ");
                    }
                    System.out.printf("%s", cities[i]);
                }
            }
            System.out.printf("\n");
        } else if (cachedNumberOfCities > 0) {
            sortCitiesArray();
            System.out.printf("         %d City | %s\n", cachedNumberOfCities, cities[0]);
        } else {
            System.out.printf("    No City Yet |\n");
        }
        System.out.printf(" Num of Attacks | %d\n", numberOfAttacks);
        System.out.printf("           Gold | %.2f\n", gold);
        System.out.printf("      Resources | %.2f\n", resources);
        System.out.printf("      Happiness | %d\n", happiness);
        System.out.printf("Millitary Units | %d\n", millitaryUnits);
        System.out.printf("Technology Pts. | %d\n", technology);
        System.out.println("===========================================");
    }

    public static void newActions() {
        System.out.println();
        System.out.println("Let's now take a look at all of your options.");
        System.out.println("================ CHOICES ==================");
        System.out.println("[1] Settle a city.");
        System.out.println("[2] Demolish a City.");
        System.out.println("[3] Build Militia.");
        System.out.println("[4] Research Technology.");
        System.out.println("[5] Attack Enemy City.");
        System.out.println("[6] Skip Turn.");
        System.out.println("===========================================");
        System.out.print("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter one of the given options - which is number 1, 2, 3, 4, 5 or 6.");
            sc.next();
        }
        int selectedAction = sc.nextInt();
        if (selectedAction == 1) {
            settleCity();
        } else if (selectedAction == 2) {
            demolishCity();
        } else if (selectedAction == 3) {
            buildMilitia();
        } else if (selectedAction == 4) {
            reserchTechnology();
        } else if (selectedAction == 5) {
            attackEnemyCity();
        } else if (selectedAction == 6) {
            skipTurn();
        } else {
            System.out.println("Invalid choice. Please choose again.");
            newActions();
        }
    }

    public static void settleCity() {
        sortCitiesArray();
        if (gold >= 15.5) {
            if (numberOfCities() < 5) {
                System.out.println();
                System.out.printf("What would you like to call your city, %s?\n", userName);
                System.out.print("Your City's Name: ");
                Scanner sc = new Scanner(System.in);
                String cityName = sc.nextLine();
                cities[numberOfCities()] = cityName;
                if (isFirstRun) {
                    isFirstRun = false;
                } else {
                    gold = gold - 15.5;
                }
                sortCitiesArray();
                System.out.println();
            } else {
                System.out.println(
                        "You already have 5 cities. As a result, you can no longer create any more new cities. \nPlease select another action.");
                newActions();
            }
        } else {
            System.out.println(
                    "You don't have enough gold. Therefore, you can not create new cities. \nPlease select another action.");
            newActions();
        }
    }

    public static void demolishCity() {
        int forErrorHandlingOptionInt = 0;
        sortCitiesArray();
        if (cachedNumberOfCities > 1) {
            System.out.println("===========================================");
            System.out.printf("%s, you own the following cities: \n", userName);
            System.out.printf("0: Do not demolish any city.\n");
            for (int i = 0; i <= 4; i++) {
                String cityName = cities[i];
                if (cityName != null) {
                    System.out.printf("[%d] %s\n", i + 1, cityName);
                    forErrorHandlingOptionInt = i + 1;
                }
            }
            System.out.printf("Which one of these cities would you like to demolish?\n");
            System.out.printf("Your choice: ");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {
                System.out.println("Please enter one of the given numerical options.");
                sc.next();
            }
            int cityIndex = sc.nextInt();
            if (cityIndex <= forErrorHandlingOptionInt) {
                if (cityIndex != 0) {
                    System.out.printf(
                            "You have demolished %s city. As a result, you gained 1.5 resources, adding up to a total of %.2f resources",
                            cities[cityIndex - 1], resources + 1.5);
                    cities[cityIndex - 1] = null;
                    resources = resources + 1.5;
                    sortCitiesArray();
                    System.out.println();
                }
            } else {
                System.out.println("You can only demolish a city that you own. Please try again.");
                forErrorHandlingOptionInt = 0;
                cityIndex = 0;
                demolishCity();
            }
        } else {

            System.out.println(
                    "You only have one city and at least one city is required for this game to proceed. Please select another action.");
            newActions();
        }
    }

    public static void buildMilitia() {
        if (gold >= 5 && resources >= 3) {
            gold = gold - 5;
            resources = resources - 3;
            millitaryUnits = millitaryUnits + 1;
            System.out.println();
            System.out.printf(
                    "Successfully built a Militia! After spending 5 gold and 3 resources, you now have 1 more resources, which adds up to %.2f resources!\n",
                    resources);
            System.out.println();
        } else {
            System.out.println("You don't have enough gold or resources. Please select another action.");
            newActions();
        }
    }

    public static void reserchTechnology() {
        if (gold >= 50 && resources >= 2) {
            gold = gold - 50;
            resources = resources - 2;
            technology = technology + 1;
            System.out.println();
            System.out.printf(
                    "Successfully developed research technology! After spending 50 gold and 2 resources, you now have 1 more technology, which adds up to %d technologies!\n",
                    technology);
            System.out.println();
        } else {
            System.out.println("You don't have enough gold or resources. Please select another action.");
            newActions();
        }
    }

    public static void attackEnemyCity() {
        if (millitaryUnits >= 6) {
            millitaryUnits = millitaryUnits - 6;
            happiness = happiness - 3;
            gold = gold + 10;
            numberOfAttacks++;
            System.out.println();
            System.out.printf("Successfully attacked enemy city. You now have %d millitary units!\n", millitaryUnits);
            System.out.println();
        } else {
            System.out.println("Not enough millitary units are at your command. Please select another action.");
            newActions();
        }
    }

    public static void skipTurn() {
        System.out.println("You have choosen to skip this turn.");
    }

    public static void sortCitiesArray() {
        for (int i = 0; i < 4; i++) {
            String cityName = cities[i];
            if (cityName == null) {
                int firstNullCityIndex = i;
                for (int j = firstNullCityIndex; j < 4; j++) {
                    cities[j] = cities[j + 1];
                    cities[j + 1] = null;
                }
            }
        }
        numberOfCities();
    }

    public static int numberOfCities() {
        int numberOfCities = 0;
        for (int i = 0; i <= 4; i++) {
            String cityName = cities[i];
            if (cityName != null) {
                numberOfCities++;
            }
        }
        cachedNumberOfCities = numberOfCities;
        return numberOfCities;
    }

}