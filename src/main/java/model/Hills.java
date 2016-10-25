package model;

import java.util.Random;

/**
 * Represents some Hills that can be explored by a Civilization.
 *
 * @version 1.0
 * @author Angie Palm
 */
class Hills {
    private static Random rand = new Random();

    private Game[] game;
    private int numGame;

    private int[][] goldLocation = new int[25][25];
    private int[][] coalLocation = new int[15][15];

    /**
     * Public constructor. Will populate the arrays for gold location and
     * coal location as well as for Game.
     */
    public Hills() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                goldLocation[i][j] = rand.nextInt(300);
                j += rand.nextInt(4);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                coalLocation[i][j] = rand.nextInt(10) + 1;
            }
        }
        game = new Game[10];
        numGame = 0;
        replenishGame();
    }

    /**
     * @return an int representing the amount of gold that was excavated.
     */
    public int excavate() {
        int i = rand.nextInt(25);
        int j = rand.nextInt(25);

        return goldLocation[i][j];
    }

    /**
     * @return an int representing the amount of coal that was mined.
     */
    public int mineCoal() {
        int i = rand.nextInt(15);
        int j = rand.nextInt(15);

        return coalLocation[i][j];
    }

    /**
     * Hunts an animal, removing it from the game array.
     *
     * @return a Game object representing the animal that was hunted.
     */
    public Game hunt() {
        Game hunted;
        if (numGame > 0) {
            hunted = game[--numGame];
        } else {
            hunted = null;
        }
        return hunted;
    }

    /**
     * Replenishes the game array so that it will not run out of Game objects
     * after successive calls to hunt.
     *
     * @return a boolean representing if game was successfully replenished.
     */
    public boolean replenishGame() {
        if (numGame == 0) {
            for (int i = 0; i < game.length; i++) {
                game[i] = new Game(rand.nextInt(20));
            }
            numGame = game.length;
            return true;
        }
        return false;
    }
}
