package model;

import javafx.scene.image.Image;

/**
 * Represents a Farm that can generate food.
 *
 * @version 1.0
 * @author Jim Harris
 */
public class Farm extends Building {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Farm(Civilization owner) {
        super(200, owner, 0, 0, 10, 0, 0, 10);
    }

    @Override
    public void invest() {
        setFoodGeneration(getFoodGeneration() + 2);
    }

    @Override
    public char symbol() {
        return '+';
    }


    @Override
    public String toString() {
        return "Farm. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/farm_icon.PNG");
    }
}
