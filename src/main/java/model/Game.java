package model;

/**
 * Represents some animal that can be hunted, killed, and eaten.
 *
 * @version 2.0
 * @author Angie Palm
 */
class Game {
    private int healthIncrease;

    /**
     * Public constructor.
     *
     * @param healthIncrease the amount of health this animal has.
     */
    public Game(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }

    /**
     * Public constructor. Default health is 20.
     */
    public Game() {
        this(20);
    }

    /**
     * @return an int representing the health of this animal.
     */
    public int getHealth() {
        return healthIncrease;
    }

}
