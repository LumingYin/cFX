package model;

/**
 * Represents a Building that produces things for a Civilization.
 *
 * @version 1.0
 * @author Jim Harris
 */
abstract class Building extends MapObject {
    private int goldGeneration;
    private int resourceGeneration;
    private int foodGeneration;
    private int techPointGeneration;
    private int philosophyGeneration;
    private int happinessGeneration;

    /**
     * Public constructor.
     *
     * @param health an int representing health the Building has.
     * @param owner the Civilization that owns this Building.
     * @param goldGeneration an int representing the gold this Building produces
     * per turn.
     * @param resourceGeneration an int representing the resources this Building
     * produces per turn.
     * @param foodGeneration an int representing the food this Building produces
     * per turn.
     * @param techPointGeneration an int representing the tech points this
     * Building produces per turn.
     * @param philosophyGeneration an int representing the philosophy points
     * this Building produces per turn.
     * @param happinessGeneration an int representing the happiness this
     * Building produces per turn.
     */
    public Building(int health, Civilization owner, int goldGeneration,
        int resourceGeneration, int foodGeneration, int techPointGeneration,
        int philosophyGeneration, int happinessGeneration) {
        super(health, owner);
        this.goldGeneration = goldGeneration;
        this.resourceGeneration = resourceGeneration;
        this.foodGeneration = foodGeneration;
        this.techPointGeneration = techPointGeneration;
        this.philosophyGeneration = philosophyGeneration;
        this.happinessGeneration = happinessGeneration;
    }

    /**
     * Called when the user invests in this Building. This is generally used
     * to provide some boost to the owner Civilization's properties or to
     * increase the generation of some property.
     */
    public abstract void invest();

    /**
     * Called when this Building is demolished. Increases the resources of
     * the owner Civilization in exchange. Generally when this is called, this
     * Building will be removed from the game Map.
     */
    public void demolish() {
        getOwner().produceResources(Math.max(resourceGeneration, 5) * 5);
    }

    @Override
    public void tick() {
        getOwner().getTreasury().earn(goldGeneration);
        getOwner().produceResources(resourceGeneration);
        getOwner().makeFood(foodGeneration);
        getOwner().getTechnology().increaseUnderstanding(philosophyGeneration);
        getOwner().getTechnology().increaseBuildExperience(techPointGeneration);
        getOwner().increaseHappiness(happinessGeneration);
    }

    /**
     * @return an int representing the gold generation of this Building.
     */
    public int getGoldGeneration() {
        return goldGeneration;
    }

    /**
     * Sets the gold generation of this Building.
     *
     * @param generation the gold generation of this Building.
     */
    public void setGoldGeneration(int generation) {
        this.goldGeneration = generation;
    }

    /**
     * @return an int representing the resource generation of this Building.
     */
    public int getResourceGeneration() {
        return resourceGeneration;

    }

    /**
     * Sets the resources generation of this Building.
     *
     * @param generation the resource generation of this Building.
     */
    public void setResourceGeneration(int generation) {
        this.resourceGeneration = generation;

    }

    /**
     * @return an int representing the food generation of this Building.
     */
    public int getFoodGeneration() {
        return foodGeneration;

    }

    /**
     * Sets the food generation of this Building.
     *
     * @param generation the food generation of this Building.
     */
    public void setFoodGeneration(int generation) {
        this.foodGeneration = generation;

    }

    /**
     * @return an int representing the tech point generation of this Building.
     */
    public int getTechPointGeneration() {
        return techPointGeneration;

    }

    /**
     * Sets the tech point generation of this Building.
     *
     * @param generation the tech point generation of this Building.
     */
    public void setTechPointGeneration(int generation) {
        this.techPointGeneration = generation;

    }

    /**
     * @return an int representing the philosophy generation of this Building.
     */
    public int getPhilosophyGeneration() {
        return philosophyGeneration;

    }

    /**
     * Sets the philosophy generation of this Building.
     *
     * @param generation the philosophy generation of this Building.
     */
    public void setPhilosophyGeneration(int generation) {
        this.philosophyGeneration = generation;

    }

    /**
     * @return an int representing the happiness generation of this Building.
     */
    public int getHappinessGeneration() {
        return happinessGeneration;

    }

    /**
     * Sets the happiness generation of this Building.
     *
     * @param generation the happiness generation of this Building.
     */
    public void setHappinessGeneration(int generation) {
        this.happinessGeneration = generation;
    }


    @Override
    public String toString() {
        return "Building. " + super.toString();
    }

}
