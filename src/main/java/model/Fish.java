package model;

/**
 * represents a Fish in the FishingShack or River
 * @author Ryan Voor
 * @version 2.0
 */
class Fish {

    // instance variables
    private int weight;
    private int length;

    /**
     * constructs a new Fish with parameter values for
     * both weight and length
     * @param weight the weight of this Fish
     * @param length the length of this Fish
     */
    public Fish(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    /**
     * constructs a new Fish with default values of 5 for
     * both weight and length
     */
    public Fish() {
        this(5, 5);
    }

    /**
     * returns the health that this Fish would restore if eaten
     * that value is calculated by summing its weight and length
     * @return int the health this Fish would restore if eaten
     */
    public int getHealth() {
        return weight + length;
    }

    /**
     * Compares this object to the parameter Object
     * returns true if the passed in Object is:
     *     - not null
     *     - a Fish Object
     *     - has the same weight as this Fish
     *     - and has the same length as this Fish
     * otherwise it returns false
     * @param other the thing being compared to. Has type Object
     * @return whether the parameter object and this one are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Fish)) {
            return false;
        }
        Fish otherFish = (Fish) other;
        return this.weight == otherFish.weight
            && this.length == otherFish.length;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Fish: Weight=" + weight + ", Length=" + length;
    }
}
