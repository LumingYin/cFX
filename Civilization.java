import java.util.Scanner;

public class Civilization {
static String userName = new String();
static boolean playing = true;

//User's properties
static String cities[] = new String[5];
static int cachedNumberOfCities = 0;
static int numberOfAttacks = 0;
static double gold = 20.5;
static double resources = 30;
static int happiness = 10;
static int millitaryUnits = 0;
static int technology = 0;
static boolean isFirstRun = true;


    public static void main(String[] args) {
        while(playing) {
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
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {
        }
    }


    public static void endGameReset() {
        System.out.printf("Press ENTER key to play again: ");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {
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
        System.out.println("1.     American (George Washionton)");
        System.out.println("2.         Zulu (Shaka)");
        System.out.println("3.      English (Queen Elizabeth I)");
        System.out.println("4.      Chinese (Wu Ze Tian)");
        System.out.println("===========================================");
        System.out.print("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int selectedCivillization = sc.nextInt();
        if (selectedCivillization == 1) {
            userName = "George Washionton";
        } if (selectedCivillization == 2) {
            userName = "Shaka";
        } if (selectedCivillization == 3) {
            userName = "Queen Elizabeth I";
        } if (selectedCivillization == 4) {
            userName = "Wu Ze Tian";
        }
        System.out.println();
        System.out.printf("Good choice, %s!\n", userName);
        System.out.printf("Now, it's time to settle your first city!\n");
        settleCity();
}

    public static void preNewRoundScript() {
        if (happiness > 20) {
            resources = resources + 5 * cachedNumberOfCities;
        } else {
            resources = resources + 1;
        }

        gold = gold + 3 * cachedNumberOfCities;
        
        if (resources % 2 == 0) {
            happiness = happiness + 1;
        } else {
            happiness = happiness - 3;
        }

        if (technology >= 20 || numberOfAttacks >= 10) {
            playing = false;
        } else {
        selectPerformableAction();
        System.out.println();
        System.out.println("A new turn has begun!");
    }
    }

    public static void selectPerformableAction() {
        arrayPurifier();
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
        arrayPurifier();
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
        System.out.println("1. Settle a city.");
        System.out.println("2. Demolish a City.");
        System.out.println("3. Build Militia.");
        System.out.println("4. Research Technology.");
        System.out.println("5. Attack Enemy City.");
        System.out.println("6. Skip Turn");
        System.out.println("===========================================");
        System.out.print("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int selectedAction = sc.nextInt();
        if (selectedAction == 1) {
            settleCity();
        } if (selectedAction == 2) {
            demolishCity();
        } if (selectedAction == 3) {
            buildMilitia();
        } if (selectedAction == 4) {
            reserchTechnology();
        } if (selectedAction == 5) {
            attackEnemyCity();
        } if (selectedAction == 6) {
            skipTurn();
        }

}

    public static void settleCity(){
        arrayPurifier();
        if (gold >= 15.5) {
                    if (numberOfCities() < 5) {
                    System.out.println();
                    System.out.printf("What would you like to call your city, %s?\n", userName);
                    System.out.print("Your City's Name: ");
                    Scanner sc = new Scanner(System.in);
                    String cityName = sc.nextLine();
                    cities[numberOfCities()] = cityName;
                    if (isFirstRun == true) {
                        isFirstRun = false;
                    } else {
                    gold = gold - 15.5;
                }
                    arrayPurifier();
                    System.out.println();
                } else {
                    System.out.println("You already have 5 cities. As a result, you can no longer create any more new cities. \nPlease select another action.");
                    newActions();
                }
            } else {
                    System.out.println("You don't have enough gold. Therefore, you can not create new cities. \nPlease select another action.");
                    newActions();
            }
    }

    public static void demolishCity(){
        arrayPurifier();
        System.out.println(cachedNumberOfCities);
        if (cachedNumberOfCities > 1) {
        System.out.println("===========================================");
        System.out.printf("%s, you own the following cities: \n", userName);
        System.out.printf("0: Do not demolish any city.\n");
        for (int i = 0; i <= 4; i ++) {
            String cityName = cities[i];
            if (cityName != null) {
                System.out.printf("%d: %s\n", i+1, cityName);
            }
        }
        System.out.printf("Which one of these cities would you like to demolish?\n");
        System.out.printf("Your choice: ");
        Scanner sc = new Scanner(System.in);
        int cityIndex = sc.nextInt();
        if (cityIndex != 0) {
            System.out.printf("You have demolished %s city. As a result, you gained 1.5 resources, adding up to a total of %.2f resources", cities[cityIndex - 1], resources + 1.5);
            cities[cityIndex - 1] = null;
            resources = resources + 1.5;
            arrayPurifier();
        System.out.println("===========================================");
        }
            numberOfCities();
        } else {
            numberOfCities();
            System.out.println("You only have one city and at least one city is required for this game to proceed. Please select another action.");
            newActions();
        }
    }

    public static void buildMilitia(){
    if (gold >= 5 && resources >= 3) {
        gold = gold - 5; 
        resources = resources- 3; 
        millitaryUnits = millitaryUnits + 1;
        System.out.println();
    System.out.printf("Successfully built a Militia! After spending 5 gold and 3 resources, you now have 1 more resources, which adds up to %.2f resources!\n", resources);
        System.out.println();
} else {
            System.out.println("You don't have enough gold or resources. Please select another action.");
            newActions();
        }
}

    public static void reserchTechnology() {
        if (gold >= 50 && resources >=2) {
        gold = gold - 50;
        resources = resources - 2;
        technology = technology + 1;
        System.out.println();
        System.out.printf("Successfully developed research technology! After spending 50 gold and 2 resources, you now have 1 more technology, which adds up to %d technologies!\n", technology);
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
        numberOfAttacks ++;
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

    public static void arrayPurifier() {
        for (int i = 0; i < 4; i ++) {
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
        for (int i=0; i <= 4; i++) {
            String cityName = cities[i];
            if (cityName != null) {
                numberOfCities++;
            }
        }
        cachedNumberOfCities = numberOfCities;
        return numberOfCities;
    }


}