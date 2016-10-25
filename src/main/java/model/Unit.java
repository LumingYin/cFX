package model;

/**
 * Represents a Unit that is able to be hired and move around the map.
 *
 * @version 1.0
 * @author Jim Harris
 */
abstract class Unit extends MapObject {
    private int baseEndurance;
    private int endurance;
    private int pay;
    private int initialGoldCost;
    private int initialFoodCost;
    private int initialResourceCost;
    private int initialHappinessCost;
    private boolean canAttack;

    /**
     * Public constructor.
     *
     * @param health an int representing the health of this unit.
     * @param owner the owner of this unit.
     * @param baseEndurance how far this unit can move each turn.
     * @param pay how much gold this unit costs per turn.
     * @param initialGoldCost how much gold this unit costs to hire.
     * @param initialFoodCost how much food this unit requires to hire.
     * @param initialResourceCost how many resources this unit needs to hire.
     * @param initialHappinessCost how much happiness this unit costs to hire.
     */
    public Unit(int health, Civilization owner, int baseEndurance, int pay,
        int initialGoldCost, int initialFoodCost, int initialResourceCost,
        int initialHappinessCost) {
        super(health, owner);
        this.baseEndurance = baseEndurance;
        this.endurance = baseEndurance;
        this.pay = pay;
        this.initialGoldCost = initialGoldCost;
        this.initialFoodCost = initialFoodCost;
        this.initialResourceCost = initialResourceCost;
        this.initialHappinessCost = initialHappinessCost;
    }

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public Unit(Civilization owner) {
        this(30, owner, 5, 5, 7, 5, 10, 0);
    }

    /**
     * Reduces the gold of the owner civilization by @code{pay}
     */
    public void consumeResources() {
        getOwner().getTreasury().spend(pay);
    }

    @Override
    public void tick() {
        consumeResources();
        regenerateEndurance();
    }

    /**
     * Regenerates the endurance of this Unit so it can move again.
     */
    public void regenerateEndurance() {
        this.endurance = this.baseEndurance;
    }

    /**
     * @return a boolean representing if this Unit is allowed to attack.
     */
    public boolean getCanAttack() {
        return this.canAttack;
    }

    /**
     * Sets whether or not this unit can attack.
     *
     * @param canAttack whether or not this Unit may attack.
     */
    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    /**
     * @return an int representing the current endurance level of this Unit.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * @return an int representing the maximum endurance level of this Unit.
     */
    public int getBaseEndurance() {
        return this.baseEndurance;
    }

    /**
     * Determines whether or not the Unit is able to move a certain distance.
     *
     * @param enduranceCost the distance the Unit wants to move.
     * @return a boolean representing whether or not the Unit can move.
     */
    public boolean canMove(int enduranceCost) {
        return endurance >= enduranceCost;
    }

    /**
     * Sets the maximum endurance of the Unit.
     *
     * @param baseEndurance the maxmimum endurance of this Unit.
     */
    public void setBaseEndurance(int baseEndurance) {
        this.baseEndurance = baseEndurance;
    }

    /**
     * Reduces the current endurance of this Unit by a provided amount.
     *
     * @param reduction how much to decrease endurance by.
     */
    public void deductEndurance(int reduction) {
        this.endurance -= reduction;
    }

    /**
     * @return an int representing the initial gold cost of this Unit.
     */
    public int getInitialGoldCost() {
        return this.initialGoldCost;
    }

    /**
     * @return an int representing the initial food cost of this Unit.
     */
    public int getInitialFoodCost() {
        return this.initialFoodCost;
    }

    /**
     * @return an int representing the initial resource cost of this Unit.
     */
    public int getInitialResourceCost() {
        return this.initialResourceCost;
    }

    /**
     * @return an int representing the initial happiness cost of this Unit.
     */
    public int getInitialHappinessCost() {
        return this.initialHappinessCost;
    }

    /**
     * @return a boolean representing whether or not the owner Civilization can
     * afford to hire this Unit.
     */
    public boolean isAffordable() {
        Civilization owner = getOwner();
        return owner.getTreasury().getCoins() >= initialGoldCost
            && owner.getFood() >= initialFoodCost
            && owner.getResources() >= initialResourceCost
            && owner.getHappiness() >= initialHappinessCost;
    }

    /**
     * Applies the initial cost of this Unit to the owner Civilization.
     */
    public void applyInitialCosts() {
        getOwner().getTreasury().spend(initialGoldCost);
        getOwner().eat(initialFoodCost);
        getOwner().dockResources(initialResourceCost);
        getOwner().dockHappiness(initialHappinessCost);
    }

    @Override
    public String toString() {
        return "Unit. Endurance: " + endurance + ". " + "Can Attack: "
            + canAttack + ". " + super.toString();
    }
}
