import java.util.Scanner;
import java.util.Random;

public class Desert {
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    public int findTreasure() {
        boolean getLost = false;
        int coinsFound = rand.nextInt(500) + 1;
        int getLostRandomNumber = rand.nextInt(100) + 1;
        if (getLostRandomNumber <= 10) {
            while (lost()) {
                coinsFound = coinsFound;
            }
        }
        return coinsFound;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}