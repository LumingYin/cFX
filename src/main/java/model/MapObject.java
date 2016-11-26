package model;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents an object that can be placed on the game Map and damaged.
 *
 * @version 1.0
 * @author Jim Harris
 */
public abstract class MapObject implements Symbolizable, Viewable {
    private int health;
    private Civilization owner;
    private Color color;

    /**
     * Public constructor.
     *
     * @param health the health of this MapObject
     * @param owner the Civilization that owns this MapObject
     */
    public MapObject(int health, Civilization owner) {
        this.health = health;
        this.owner = owner;
        if (owner instanceof Egypt) {
            color = Color.rgb(250, 250, 210, 0.4);
        } else if (owner instanceof QinDynasty) {
            color = Color.rgb(255, 0, 255, 0.4);
        } else if (owner instanceof RomanEmpire) {
            color = Color.rgb(255, 0, 0, 0.4);
        } else {
            color = color.rgb(0, 0, 0, 0.4);
        }
    }

    /**
     * @return the Civilization that owns this MapObject
     */
    public Civilization getOwner() {
        return owner;
    }

    /**
     * gets the health
     * @return the health of a MapObject
     */
    public int getHealth() {
        return health;
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

    public Image getImage() {
        return new Image("File:./src/main/java/view/bandit_icon.png");
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

    public String getStatusString() {
        String name = this.getClass().getSimpleName();
        return name + "\nOwner: " + owner.getName() + "\nHealth: " + health;
    }


    public boolean isFriendly() {
        return !(owner instanceof Bandit);
    }

    public boolean isMilitaryUnit() {
        return this instanceof MilitaryUnit;
    }

    public boolean isBuilding() {
        return this instanceof Building;
    }

    public boolean isWorker() {
        return this instanceof Convertable;
    }

    public Color getColor() {
        return color;
    }
}
