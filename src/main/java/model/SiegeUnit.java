package model;

import javafx.scene.image.Image;

/**
 * Represents a Siege unit.
 *
 * @version 1.0
 * @author Jim Harris
 */
class SiegeUnit extends MilitaryUnit {

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public SiegeUnit(Civilization owner) {
        super(200, owner, 5, 10, 14, 5, 10, 60);
    }

    @Override
    public void attack(MapObject o) {
        getOwner().getStrategy().siege();
        battle(o);
    }

    @Override
    public void battle(MapObject o) {
        if (o instanceof Building) {
            o.damage(this.getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'S';
    }

    @Override
    public String toString() {
        return "Siege Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/siege_unit_icon.PNG");
    }
}
