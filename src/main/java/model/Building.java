package model;

abstract class Building extends MapObject {
    private int goldGeneration;
    private int resourceGeneration;
    private int foodGeneration;
    private int techPointGeneration;
    private int philosophyGeneration;
    private int happinessGeneration;

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

    public abstract void invest();

    public void demolish() {
        getOwner().produceResources(Math.max(resourceGeneration, 5) * 5);
    }

    public void tick() {
        getOwner().getTreasury().earn(goldGeneration);
        getOwner().produceResources(resourceGeneration);
        getOwner().makeFood(foodGeneration);
        getOwner().getTechnology().increaseUnderstanding(philosophyGeneration);
        getOwner().getTechnology().increaseBuildExperience(techPointGeneration);
        getOwner().increaseHappiness(happinessGeneration);
    }

    public int getGoldGeneration() {
        return goldGeneration;
    }

    public void setGoldGeneration(int generation) {
        this.goldGeneration = generation;
    }

    public int getResourceGeneration() {
        return resourceGeneration;

    }

    public void setResourceGeneration(int generation) {
        this.resourceGeneration = generation;

    }

    public int getFoodGeneration() {
        return foodGeneration;

    }

    public void setFoodGeneration(int generation) {
        this.foodGeneration = generation;

    }

    public int getTechPointGeneration() {
        return techPointGeneration;

    }

    public void setTechPointGeneration(int generation) {
        this.techPointGeneration = generation;

    }

    public int getPhilosophyGeneration() {
        return philosophyGeneration;

    }

    public void setPhilosophyGeneration(int generation) {
        this.philosophyGeneration = generation;

    }

    public int getHappinessGeneration() {
        return happinessGeneration;

    }

    public void setHappinessGeneration(int generation) {
        this.happinessGeneration = generation;
    }


    @Override
    public String toString() {
        return "Building. " + super.toString();
    }

}
