package model;

import javafx.scene.image.Image;
/**
 * Represents a univsity that can increase happiness.
 *
 * @version 1.0
 * @author Luming Yin
 */
class BluePrintEscapeRoom extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public BluePrintEscapeRoom(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }


    @Override
    public String toString() {
        return "Escape Room " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/escapeRoom_icon.PNG");
    }
}
