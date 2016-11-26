package model;

import javafx.scene.image.Image;
/**
 * Represents a coal mine that can generate resources.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris
 */
class CoalMine extends Building {
    private static final int COAL = 20;
    private int burnCost = 10;

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public CoalMine(Civilization owner) {
        super(200, owner, 0, 0, 0, 0, 0, 0);
        setResourceGeneration(COAL - burnCost);
    }

    @Override
    public void invest() {
        if (burnCost > 0) {
            burnCost -= 1;
        }
        setResourceGeneration(COAL - burnCost);
    }

    @Override
    public char symbol() {
        return '(';
    }

    /**
     * @return an int representing the burn cost of this Coal Mine.
     */
    public int getBurnCost() {
        return burnCost;
    }

    /**
     * @return an int representing the base coal genration of this Coal Mine.
     */
    public int getCoal() {
        return COAL;
    }

    @Override
    public String toString() {
        return "Coalmine. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/coal_mine_icon.PNG");
    }
}
