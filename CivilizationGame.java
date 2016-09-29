import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class CivilizationGame {
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] drive) throws Exception {
        System.out.println("Welcome to Civilization! Which civilization would"
            + " you like to build?\n\n"
            + "1. Ancient Egypt\n"
            + "2. Qin Dynasty\n"
            + "3. Roman Empire\n");

        int civChoice = scan.nextInt();
        scan.nextLine();
        switch (civChoice) {
        case 1:
            playEgypt();
            break;
        case 2:
            playQin();
            break;
        case 3:
            playRome();
            break;
        default:
            System.out.println("Not a valid civilization choice!");
        }
    }

    public static void playEgypt() throws Exception {
        Egypt egypt = new Egypt();
        while (!egypt.getStrategy().conqueredTheWorld()
            && !egypt.getTechnology().hasTechnologyWin()) {
            System.out.println("\n\nWelcome to Egypt - you have a"
                + " strategy level of "
                + egypt.getStrategy().getStrategyLevel()
                + ", an understanding of "
                + egypt.getTechnology().getUnderstanding()
                + ", and a build experience of "
                + egypt.getTechnology().getBuildExperience()
                + ".\n");
            System.out.println("You have " + egypt.getTreasury().getCoins()
                + " coins in your treasury, "
                + egypt.getPopulation().getWarriors() + " warriors, and "
                + egypt.getPopulation().getCivilians() + " civilians.\n");
            System.out.println("What would you like to do?\n"
                + "1. Build my empire\n"
                + "2. CONQUER\n"
                + "3. Educate my citizens\n"
                + "4. Explore my surroundings\n");

            int move = scan.nextInt();
            scan.nextLine();

            switch (move) {
            case 1:
                settle(egypt);
                break;
            case 2:
                conquer(egypt);
                break;
            case 3:
                educate(egypt);
                break;
            case 4:
                explore(egypt);
                break;
            default:
                no();
            }
        }
        System.out.println("Congratulations! You won!");
    }

    private static void no() {
        System.out.println("Sorry, that was not an option.");
    }

    private static void settle(Egypt egypt) {
        System.out.println("Would like to settle a new city?\n"
            + "1. Yes.\n"
            + "2. No, I would like to continue building one of my pre-existing"
            + " cities!\n");
        int move = scan.nextInt();
        scan.nextLine();
        if (move == 1) {
            System.out.println("What would you like to name your new "
                + "settlement?");
            String settlementName = scan.nextLine();
            Settlement settlement = new Settlement(settlementName);
            if (egypt.settle(settlement)) {
                System.out.println("You have settled the new land of "
                    + settlement.getName());
                build(egypt, settlement);
            } else {
                System.out.println("You have failed to settle. You have too"
                    + " many settlements already.");
            }
        } else if (move == 2) {
            Settlement[] settlements = egypt.getSettlements();
            if (egypt.getNumSettlements() > 0) {
                System.out.println("Choose one of these settlements to "
                    + "build upon!");
                for (int i = 0; i < egypt.getNumSettlements(); i++) {
                    System.out.println((i + 1) + ". "
                        + settlements[i].getName());
                }
                int settleNum = scan.nextInt();
                if (settleNum <= egypt.getNumSettlements() && settleNum > 0) {
                    build(egypt, settlements[settleNum - 1]);
                }

            } else {
                System.out.println("Sorry, you don't have any pre-existing"
                    + " settlements.");
            }
        } else {
            no();
        }
    }

    private static void build(Egypt egypt, Settlement settlement) {

        System.out.println("What would you like to build?\n"
            + "1. Pyramids! Glory! Pyramids require 500 gold and 100 workers.\n"
            + "2. Nothing. I'm good for now.\n");
        int buildMove = scan.nextInt();
        scan.nextLine();
        String print = "\n";
        if (buildMove == 1) {
            print += egypt.buildPyramid(settlement) ? "Wow, what a beautiful"
                + " pyramid." : "You need enough workers AND gold to build"
                + " this structure.";
        }
        System.out.println(print + "\n");

    }

    private static void conquer(Egypt egypt) {
        System.out.println("You have two options: \n"
            + "1. Battle. You must have 40 warriors to go to battle.\n"
            + "2. Siege. You must have 80 warriors to go to battle.\n");
        int move = scan.nextInt();
        int result = -1;
        if (move == 1) {
            if (egypt.getPopulation().getWarriors() > 40) {
                int warriorsLost = rand.nextInt(30);
                egypt.getPopulation().setWarriors(
                        egypt.getPopulation().getWarriors()
                    - warriorsLost);
                egypt.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen battle!!!");
        } else if (move == 2) {
            if (egypt.getPopulation().getWarriors() > 80) {
                int warriorsLost = rand.nextInt(60);
                egypt.getPopulation().setWarriors(
                        egypt.getPopulation().getWarriors()
                    - warriorsLost);
                egypt.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen siege!!!");
        } else {
            System.out.println("That was not an option...");
            return;
        }

        if (result == -1) {
            System.out.println("... but you didn't have enough warriors :-/");
        } else {
            System.out.println(" You lost " + result + " warriors.");
        }

    }

    private static void educate(Egypt egypt) {
        egypt.practiceHieroglyphics();
        System.out.println("\nYour Egyptians are improving their writing! Keep"
            + " practicin' those hieroglyphics.\n");
    }

    private static void explore(Egypt egypt) throws Exception {
        System.out.println("\nEgyptians have two terrains to explore: \n"
            + "1. Desert\n"
            + "2. The " + egypt.getRiver().getName() + " River\n");
        System.out.println("Make a choice!\n");

        int move = scan.nextInt();
        if (move == 1) {
            System.out.println("\nThe only point to exploring the Desert is to"
                + " find treasure, of course!");
            int treasure = egypt.getDesert().findTreasure();
            System.out.println("You explored the Desert and came back with "
                + treasure + " treasure!\n");
            egypt.getTreasury().earn(treasure);
        } else if (move == 2) {
            gameplayRiver(egypt.getRiver(), egypt.getPopulation(),
                egypt.getCoalMine());
        } else {
            System.out.println("That was not an option, sorry.");
            return;
        }

    }

    private static void gameplayHills(Hills hills, Population population,
        Treasury treasury, CoalMine coalMine) {
        System.out.println("The Hills have three resources: \n"
            + "1. Gold\n"
            + "2. Wild Game\n"
            + "3. Coal\n"
            + "\n Which would you like to search for?\n");

        int move = scan.nextInt();
        if (move == 1) {
            int goldFound = hills.excavate();
            treasury.earn(goldFound);
            String print = (goldFound > 0) ? "Congrats!" : "Sorry :'( .";
            System.out.println(print + " You found " + goldFound
                + " gold coins.");
        } else if (move == 2) {
            Game gameFound = population.hunt(hills);
            if (gameFound == null) {
                System.out.println("Unfortunately, it looks like all the Wild "
                    + "Game has left this terrain.\n No fear, though! The "
                    + "terrain will replenish itself soon enough.\n");
                String replenished = (hills.replenishGame()) ? "Success! We "
                    + "found more Wild Game!\n" : "You can only replenish Game"
                    + " once all other Game has been hunted.\n";
                System.out.println(replenished);
            } else {
                if (population.canCook(gameFound, coalMine)) {
                    System.out.println("You found some food and successfully"
                        + " fed your citizens!");
                } else {
                    System.out.println("You found some food, but you don't have"
                        + " enough coal to cook it.");
                }
            }
        } else if (move == 3) {
            int coalFound = hills.mineCoal();
            coalMine.increaseCoal(coalFound);
            System.out.println("Congrats! You found " + coalFound + " coals!");
        } else {
            no();
        }
    }

    private static void gameplayRiver(River river, Population population,
        CoalMine coalMine) throws Exception {
        System.out.println("\nWelcome to the " + river.getName() + " river.\n"
            + "There are fish here.\n");
        for (int i = 0; i < rand.nextInt(8); i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Fishing\n");
        }
        Fish fishFound = population.fish(river);
        if (fishFound == null) {
            System.out.println("Unfortunately, it looks like all the Fish have"
                + " left this terrain.\nNo fear, though! The terrain will "
                + "replenish itself soon enough.\n");
            String print = (river.replenishFish()) ? "Success! More fish have "
                + "arrived!\n" : "Something went wrong... Not sure where "
                + "the fish went.\n";
            System.out.println(print);
        } else {
            if (population.canCook(fishFound, coalMine)) {
                System.out.println("You found some food and successfully fed "
                    + "your citizens!");
            } else {
                System.out.println("You found some food, but you don't have "
                    + "enough coal to cook it.");
            }
        }
    }

    public static void playQin() throws Exception {
        QinDynasty qin = new QinDynasty();
        while (!qin.getStrategy().conqueredTheWorld()
            && !qin.getTechnology().hasTechnologyWin()) {
            System.out.println("\n\nWelcome to the Qin Dynasty -"
                + " you have a strategy level of "
                + qin.getStrategy().getStrategyLevel()
                + ", an understanding of "
                + qin.getTechnology().getUnderstanding()
                + ", and a build experience of "
                + qin.getTechnology().getBuildExperience()
                + ".\n");
            System.out.println("You have " + qin.getTreasury().getCoins()
                + " coins in your treasury, "
                + qin.getPopulation().getWarriors() + " warriors, and "
                + qin.getPopulation().getCivilians() + " civilians.\n");
            System.out.println("Welcome to the Qin Dynasty - what would you "
                + "like to do?\n"
                + "1. Build my empire\n"
                + "2. CONQUER\n"
                + "3. Educate my citizens\n"
                + "4. Explore my surroundings\n");

            int move = scan.nextInt();
            scan.nextLine();

            switch (move) {
            case 1:
                settle(qin);
                break;
            case 2:
                conquer(qin);
                break;
            case 3:
                educate(qin);
                break;
            case 4:
                explore(qin);
                break;
            default:
                no();
            }
        }
        System.out.println("Congratulations! You won!");
    }

    private static void settle(QinDynasty qin) {
        System.out.println("Would like to settle a new city?\n"
            + "1. Yes.\n"
            + "2. No, I would like to continue building one of my pre-existing"
            + " cities!\n");
        int move = scan.nextInt();
        scan.nextLine();
        if (move == 1) {
            System.out.println("What would you like to name your new "
                + "settlement?");
            String settlementName = scan.nextLine();
            Settlement settlement = new Settlement(settlementName);
            if (qin.settle(settlement)) {
                System.out.println("You have settled the new land of "
                    + settlement.getName());
                build(qin, settlement);
            } else {
                System.out.println("You have failed to settle. You have too "
                    + "many settlements already.");
            }
        } else if (move == 2) {
            Settlement[] settlements = qin.getSettlements();
            if (qin.getNumSettlements() > 0) {
                System.out.println("Choose one of these settlements to build"
                    + " upon!");
                for (int i = 0; i < qin.getNumSettlements(); i++) {
                    System.out.println((i + 1) + ". "
                        + settlements[i].getName());
                }
                int settleNum = scan.nextInt();
                if (settleNum <= qin.getNumSettlements() && settleNum > 0) {
                    build(qin, settlements[settleNum - 1]);
                }

            } else {
                System.out.println("Sorry, you don't have any pre-existing "
                    + "settlements.");
            }
        } else {
            no();
        }
    }

    private static void build(QinDynasty qin, Settlement settlement) {

        System.out.println("What would you like to build?\n"
            + "1. We need a wall! Walls require 1000 gold and 500 workers.\n"
            + "2. Houses. My people need homes! Houses require 30 gold and 8 "
            + "workers.\n3. Nothing. I'm good for now.\n");
        int buildMove = scan.nextInt();
        scan.nextLine();
        String print = "\n";
        if (buildMove == 1) {
            print += qin.buildWall(settlement) ? "Wow, what a beautiful wall."
                : "You need enough workers AND gold to build this structure.";
        } else if (buildMove == 2) {
            print += qin.buildHouse(settlement) ? "Congratulations on your new "
                + "home!" : "You need enough workers AND gold to build this "
                + "structure.";
        }
        System.out.println(print + "\n");

    }

    private static void conquer(QinDynasty qin) {
        System.out.println("You have two options: \n"
            + "1. Battle. You must have 40 warriors to go to battle.\n"
            + "2. Siege. You must have 80 warriors to go to battle.\n");
        int move = scan.nextInt();
        int result = -1;
        if (move == 1) {
            if (qin.getPopulation().getWarriors() > 40) {
                int warriorsLost = rand.nextInt(30);
                qin.getPopulation().setWarriors(
                        qin.getPopulation().getWarriors()
                    - warriorsLost);
                qin.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen battle!!!");
        } else if (move == 2) {
            if (qin.getPopulation().getWarriors() > 80) {
                int warriorsLost = rand.nextInt(60);
                qin.getPopulation().setWarriors(
                        qin.getPopulation().getWarriors()
                    - warriorsLost);
                qin.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen siege!!!");
        } else {
            System.out.println("That was not an option...");
            return;
        }

        if (result == -1) {
            System.out.println("... but you didn't have enough warriors :-/");
        } else {
            System.out.println(" You lost " + result + " warriors.");
        }

    }

    private static void explore(QinDynasty qin) throws Exception {
        System.out.println("\nYou have two terrains to explore: \n"
            + "1. Hills\n"
            + "2. The " + qin.getRiver().getName() + "\n");
        System.out.println("Make a choice!\n");

        int move = scan.nextInt();
        if (move == 1) {
            gameplayHills(qin.getHills(), qin.getPopulation(),
                qin.getTreasury(), qin.getCoalMine());
        } else if (move == 2) {
            gameplayRiver(qin.getRiver(), qin.getPopulation(),
                qin.getCoalMine());
        } else {
            System.out.println("That was not an option, sorry.");
            return;
        }

    }

    private static void educate(QinDynasty qin) {
        qin.establishLegalism();
        System.out.println("\nYour citizens are studying Legalism! Keep "
            + "producing governmental philosophy!\n");
    }

    public static void playRome() throws Exception {
        RomanEmpire rome = new RomanEmpire();
        while (!rome.getStrategy().conqueredTheWorld()
            && !rome.getTechnology().hasTechnologyWin()) {
            System.out.println("\n\nWelcome to Rome -"
                + " you have a strategy level of "
                + rome.getStrategy().getStrategyLevel()
                + ", an understanding of "
                + rome.getTechnology().getUnderstanding()
                + ", and a build experience of "
                + rome.getTechnology().getBuildExperience()
                + ".\n");
            System.out.println("You have " + rome.getTreasury().getCoins()
                + " coins in your treasury, "
                + rome.getPopulation().getWarriors() + " warriors, and "
                + rome.getPopulation().getCivilians() + " civilians.\n");
            System.out.println("Welcome to Rome - what would you like to do?\n"
                + "1. Build my empire\n"
                + "2. CONQUER\n"
                + "3. Educate my citizens\n"
                + "4. Explore my surroundings\n");

            int move = scan.nextInt();
            scan.nextLine();

            switch (move) {
            case 1:
                settle(rome);
                break;
            case 2:
                conquer(rome);
                break;
            case 3:
                educate(rome);
                break;
            case 4:
                explore(rome);
                break;
            default:
                no();
            }
        }
        System.out.println("Congratulations! You won!");
    }

    private static void settle(RomanEmpire rome) {
        System.out.println("Would like to settle a new city?\n"
            + "1. Yes.\n"
            + "2. No, I would like to continue building one of my pre-existing"
            + " cities!\n");
        int move = scan.nextInt();
        scan.nextLine();
        if (move == 1) {
            System.out.println("What would you like to name your new "
                + "settlement?");
            String settlementName = scan.nextLine();
            Settlement settlement = new Settlement(settlementName);
            if (rome.settle(settlement)) {
                System.out.println("You have settled the new land of "
                    + settlement.getName());
                build(rome, settlement);
            } else {
                System.out.println("You have failed to settle. You have too "
                    + "many settlements already.");
            }
        } else if (move == 2) {
            Settlement[] settlements = rome.getSettlements();
            if (rome.getNumSettlements() > 0) {
                System.out.println("Choose one of these settlements to "
                    + "build upon!");
                for (int i = 0; i < rome.getNumSettlements(); i++) {
                    System.out.println((i + 1) + ". "
                        + settlements[i].getName());
                }
                int settleNum = scan.nextInt();
                if (settleNum <= rome.getNumSettlements() && settleNum > 0) {
                    build(rome, settlements[settleNum - 1]);
                }

            } else {
                System.out.println("Sorry, you don't have any pre-existing "
                    + "settlements.");
            }
        } else {
            no();
        }
    }

    private static void build(RomanEmpire rome, Settlement settlement) {

        System.out.println("What would you like to build?\n"
            + "1. I'm ambitious, so I want an aqueduct! Aqueducts require 250 "
            + "gold and 30 workers.\n2. My people want a common space. We will "
            + "build a bath house. Baths require 110 gold and 20 workers.\n"
            + "3. Build a villa! Villas require 80 gold and 15 workers.\n"
            + "4. Nothing. I'm good for now.\n");
        int buildMove = scan.nextInt();
        scan.nextLine();
        String print = "\n";
        if (buildMove == 1) {
            print += rome.buildAqueduct(settlement)
                ? "What an efficient aqueduct!" : "You need enough workers AND "
                + "gold to build this structure.";
        } else if (buildMove == 2) {
            print += rome.buildBathHouse(settlement)
                ? "You've built a bath house!"
                : "You need enough workers AND gold to build this structure.";
        } else if (buildMove == 3) {
            print += rome.buildVilla(settlement) ? "I wish I lived in a villa "
                + "this nice." : "You need enough workers AND gold to build "
                + " this structure.";
        }
        System.out.println(print + "\n");

    }

    private static void conquer(RomanEmpire rome) {
        System.out.println("You have two options: \n"
            + "1. Battle. You must have 40 warriors to go to battle.\n"
            + "2. Siege. You must have 80 warriors to go to battle.\n");
        int move = scan.nextInt();
        int result = -1;
        if (move == 1) {
            if (rome.getPopulation().getWarriors() > 40) {
                int warriorsLost = rand.nextInt(30);
                rome.getPopulation().setWarriors(
                        rome.getPopulation().getWarriors()
                    - warriorsLost);
                rome.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen battle!!!");
        } else if (move == 2) {
            if (rome.getPopulation().getWarriors() > 80) {
                int warriorsLost = rand.nextInt(60);
                rome.getPopulation().setWarriors(
                        rome.getPopulation().getWarriors()
                    - warriorsLost);
                rome.getStrategy().battle();
                result = warriorsLost;
            }
            System.out.print("You've chosen siege!!!");
        } else {
            no();
            return;
        }

        if (result == -1) {
            System.out.println("... but you didn't have enough warriors :-/");
        } else {
            System.out.println(" You lost " + result + " warriors.");
        }

    }

    private static void explore(RomanEmpire rome) throws Exception {
        System.out.println("\nYou have two terrains to explore: \n"
            + "1. Hills\n"
            + "2. The " + rome.getRiver().getName() + " River\n");
        System.out.println("Make a choice!\n");

        int move = scan.nextInt();
        if (move == 1) {
            gameplayHills(rome.getHills(), rome.getPopulation(),
                rome.getTreasury(), rome.getCoalMine());
        } else if (move == 2) {
            gameplayRiver(rome.getRiver(), rome.getPopulation(),
                rome.getCoalMine());
        } else {
            no();
        }

    }

    private static void educate(RomanEmpire rome) {
        rome.studyPhilosophy();
        System.out.println("\nYour citizens are philosophizing! Keep "
            + "questioning.\n");
    }
}