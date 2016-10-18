package model;

abstract class Unit extends MapObject {
    private int baseEndurance;
    private int endurance;
    private int pay;
    private int initialGoldCost;
    private int initialFoodCost;
    private int initialResourceCost;
    private int initialHappinessCost;
    private boolean canAttack;

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

    public Unit(Civilization owner) {
        this(30, owner, 5, 5, 7, 5, 10, 0);
    }

    public void consumeResources() {
        getOwner().getTreasury().spend(pay);
    }

    @Override
    public void tick() {
        consumeResources();
        regenerateEndurance();
    }

    public void regenerateEndurance() {
        this.endurance = this.baseEndurance;
    }

    public boolean getCanAttack() {
        return this.canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public int getBaseEndurance() {
        return this.baseEndurance;
    }

    public boolean canMove(int enduranceCost) {
        return endurance >= enduranceCost;
    }

    public void setBaseEndurance(int baseEndurance) {
        this.baseEndurance = baseEndurance;
    }

    public void deductEndurance(int reduction) {
        this.endurance -= reduction;
    }

    public int getInitialGoldCost() {
        return this.initialGoldCost;
    }

    public int getInitialFoodCost() {
        return this.initialFoodCost;
    }

    public int getInitialResourceCost() {
        return this.initialResourceCost;
    }

    public int getInitialHappinessCost() {
        return this.initialHappinessCost;
    }

    public boolean isAffordable() {
        Civilization owner = getOwner();
        return owner.getTreasury().getCoins() >= initialGoldCost
            && owner.getFood() >= initialFoodCost
            && owner.getResources() >= initialResourceCost
            && owner.getHappiness() >= initialHappinessCost;
    }

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
