package model;

import controller.TileType;
import javafx.scene.image.Image;

/**
 * Represents a Master Builder unit that can build a Landmark.
 *
 * @author Jim Harris
 * @version 1.0
 */
public class MasterBuilderUnit extends Unit implements Convertable {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getLandmark();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 'm';
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/master_builder_icon.PNG");
    }
}
