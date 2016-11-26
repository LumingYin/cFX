package model;

import javafx.scene.image.Image;
/**
 * Represents a univsity that can increase happiness.
 *
 * @version 1.0
 * @author Luming Yin
 */
class AmericanEmpireUniversity extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public AmericanEmpireUniversity(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }


    @Override
    public String toString() {
        return "Univeristy " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/uni_icon.PNG");
    }
}
