package model;

import java.util.Scanner;
import java.util.Random;

/**
 * Represents a Desert that can be explored by a Civilization.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris
 */
class Desert {
    private Scanner scan = new Scanner(System.in);
    private Random rand = new Random();

    public int findTreasure() {
        if (rand.nextInt(10) < 1 && lost()) {
            findTreasure();
        }
        return rand.nextInt(50) + 1;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}
