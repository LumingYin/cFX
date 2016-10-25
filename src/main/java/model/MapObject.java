package model;

/**
 * Represents an object that can be placed on the game Map and damaged.
 *
 * @version 1.0
 * @author Jim Harris
 */
abstract class MapObject implements Symbolizable {
    private int health;
    private Civilization owner;

    /**
     * Public constructor.
     *
     * @param health the health of this MapObject
     * @param owner the Civilization that owns this MapObject
     */
    public MapObject(int health, Civilization owner) {
        this.health = health;
        this.owner = owner;
    }

    /**
     * @return the Civilization that owns this MapObject
     */
    public Civilization getOwner() {
        return owner;
    }

    /**
     * Inflicts damage to this Unit.
     *
     * @param healthAmount the amount of damage to inflict.
     */
    public void damage(int healthAmount) {
        this.health -= healthAmount;
    }

    /**
     * @return a boolean representing whether or not this Unit has no health.
     */
    public boolean isDestroyed() {
        return this.health <= 0;
    }

    /**
     * Will be run on each MapObject at the beginning of each turn. Used for
     * resetting values and applying costs and such.
     */
    public abstract void tick();

    @Override
    public String toString() {
        return "Health: " + health + ", Owner: " + owner.getName() + ".";
    }

}
