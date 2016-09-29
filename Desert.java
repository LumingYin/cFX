import java.util.Scanner;

public class Desert {
    private Scanner scan = new Scanner(System.in);

    public int findTreasure() {
        boolean getLost = false;
        int coinsFound = scan.nextInt(500) + 1;
        int getLostRandomNumber = scan.nextInt(10);
        getLost = getLostRandomNumber == 0 ? true : false;

        while (getLost == true) {
            getLost = lost();
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