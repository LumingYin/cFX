package model;

import java.util.Random;

/**
 * Represents a Civilization in the game.
 *
 * @version 3.0
 * @author Taylor Hartman, Ryan Voor, Jim Harris
 */
public class Civilization {
    private static Random rand = new Random();

    private String name;

    private Technology technology = new Technology();
    private Strategy strategy = new Strategy();

    private int numSettlements;

    private Treasury treasury = new Treasury(50);
    private int food = 50;
    private int resources = 50;
    private int happiness = 50;

    /**
     * Public constructor.
     *
     * @param name the name of the Civilization.
     */
    public Civilization(String name) {
        this.name = name;
    }

    /**
     * Explores the surroundings of the Civilization and gives a nifty bonus!
     *
     * @return a String containing the message that should get printed out to
     * indicate the results of your GRAND ADVENTURE.
     */
    public String explore() {
        resources += 20;
        return "You explore your surroundings and acquire 20 resources!";
    }


    /**
     * @return a String containing the name of the Civilization.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return an int representing the number of Settlements this civ has.
     */
    public int getNumSettlements() {
        return numSettlements;
    }

    /**
     * Increments the number of settlements this civ has.
     */
    public void incrementNumSettlements() {
        numSettlements++;
    }

    /**
     * Decrements the number of settlements this civ has.
     */
    public void decrementNumSettlements() {
        numSettlements--;
    }

    /**
     *@return this civ's Treasury.
     */
    public Treasury getTreasury() {
        return treasury;
    }

    /**
     * @return this civ's Strategy.
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * @return this civ's Technology.
     */
    public Technology getTechnology() {
        return technology;
    }

    /**
     * @return an int representing this civ's happiness.
     */
    public int getHappiness() {
        return this.happiness;
    }

    /**
     * @return an int representing this civ's food supply.
     */
    public int getFood() {
        return this.food;
    }

    /**
     * @return an int representing this civ's resource cache.
     */
    public int getResources() {
        return this.resources;
    }

    /**
     * Decrements this civ's food.
     *
     * @param foodAmount the amount to decrement food by.
     */
    public void eat(int foodAmount) {
        this.food -= foodAmount;
    }

    /**
     * Increments this civ's food.
     *
     * @param foodAmount the amount to increment food by.
     */
    public void makeFood(int foodAmount) {
        this.food += foodAmount;
    }

    /**
     * Decrements this civ's resources.
     *
     * @param resourcesAmount the amount to decrement resources by.
     */
    public void dockResources(int resourcesAmount) {
        this.resources -= resourcesAmount;
    }

    /**
     * Increments this civ's resources.
     *
     * @param resourcesAmount the amount to increment resources by.
     */
    public void produceResources(int resourcesAmount) {
        this.resources += resourcesAmount;
    }

    /**
     * Decrements this civ's happiness.
     *
     * @param happinessAmount the amount to decrement happiness by.
     */
    public void dockHappiness(int happinessAmount) {
        this.happiness -= happinessAmount;
    }

    /**
     * Increments this civ's happiness.
     *
     * @param happinessAmount the amount to increment happiness by.
     */
    public void increaseHappiness(int happinessAmount) {
        this.happiness += happinessAmount;
    }

    /**
     * @return this civ's version of a new melee unit.
     */
    public MeleeUnit getMeleeUnit() {
        return new MeleeUnit(this);
    }

    /**
     * @return this civ's version of a new ranged unit.
     */
    public RangedUnit getRangedUnit() {
        return new RangedUnit(this);
    }

    /**
     * @return this civ's version of a new hybrid unit.
     */
    public HybridUnit getHybridUnit() {
        return new HybridUnit(this);
    }

    /**
     * @return this civ's version of a new siege unit.
     */
    public SiegeUnit getSiegeUnit() {
        return new SiegeUnit(this);
    }

    /**
     * @return this civ's version of a new settler unit.
     */
    public SettlerUnit getSettlerUnit(String settlementName) {
        return new SettlerUnit(this, settlementName);
    }

    /**
     * @return this civ's version of a new angler unit.
     */
    public AnglerUnit getAnglerUnit() {
        return new AnglerUnit(this);
    }

    /**
     * @return this civ's version of a new coal miner unit.
     */
    public CoalMinerUnit getCoalMinerUnit() {
        return new CoalMinerUnit(this);
    }

    /**
     * @return this civ's version of a new farmer unit.
     */
    public FarmerUnit getFarmerUnit() {
        return new FarmerUnit(this);
    }

    /**
     * @return this civ's version of a new master builder unit.
     */
    public MasterBuilderUnit getMasterBuilderUnit() {
        return new MasterBuilderUnit(this);
    }

    /**
     * @return this civ's version of a new settlement.
     *
     * @param settlementName the name of the Settlement.
     */
    public Settlement getSettlement(String settlementName) {
        return new Settlement(this, settlementName);
    }

    /**
     * @return this civ's version of a new fishing shack.
     */
    public FishingShack getFishingShack() {
        return new FishingShack(this);
    }

    /**
     * @return this civ's version of a new coal mine.
     */
    public CoalMine getCoalMine() {
        return new CoalMine(this);
    }

    /**
     * @return this civ's version of a new farm.
     */
    public Farm getFarm() {
        return new Farm(this);
    }

    /**
     * @return this civ's version of a new landmark.
     */
    public Landmark getLandmark() {
        return new Landmark(this);
    }
}
