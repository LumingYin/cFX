package model;

/**
 * Represents the strategy or Military prowess of a Civilization.
 *
 * @version 1.0
 * @author Angie Palm
 */
public class Strategy {
    private int strategyLevel;
    private boolean conqueredTheWorld;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;

    /**
     * Increases strategy level for participating in a battle.
     */
    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        setConqueredTheWorld();
    }

    /**
     * Increases strategy level for participating in a siege.
     */
    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        setConqueredTheWorld();
    }

    /**
     * @return a boolean representing whether or not the Civilization has
     * conqured the world.
     */
    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

    /**
     * @return an int representing strategy level.
     */
    public int getStrategyLevel() {
        return strategyLevel;
    }

    /**
     * Sets whether or not the world has been conquered!
     */
    private void setConqueredTheWorld() {
        conqueredTheWorld = (strategyLevel >= 500);
    }
}
