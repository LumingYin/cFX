package model;

import javafx.scene.image.Image;

/**
 * Represents a Landmark that can generate tech points.
 *
 * @version 1.0
 * @author Jim Harris
 */
public class Landmark extends Building {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Landmark(Civilization owner) {
        super(200, owner, 0, 0, 0, 10, 0, 10);
    }

    @Override
    public void invest() {
        setTechPointGeneration(getTechPointGeneration() + 5);
    }

    @Override
    public char symbol() {
        return '!';
    }

    @Override
    public String toString() {
        return "Landmark. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/landmark_icon.PNG");
    }
}
