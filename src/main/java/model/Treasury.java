package model;

/**
 * Represents the treasury of a civilization.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris (sorta)
 */
public class Treasury {
    private int coins;

    /**
     * Public constructor.
     *
     * @param coins the amount of gold in this Treasury.
     */
    public Treasury(int coins) {
        this.coins = coins;
    }

    /**
     * Public constructor. Starts with 500 gold.
     */
    public Treasury() {
        this(500);
    }

    /**
     * @return an int representing how much gold is in this Treasury.
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Spends the provided amount of money. This may have been change for HW03
     * I think. Updating version to 2.0 in case.
     *
     * @param cost the amount of money to spend.
     * @return a boolean representing whether or not the money could be spent.
     */
    public boolean spend(int cost) {
        this.coins -= cost;
        return true;
    }

    /**
     * Adds some gold to the Treasury.
     *
     * @param pay the amount of money to earn.
     */
    public void earn(int pay) {
        this.coins += pay;
    }
}
