package model;

import javafx.scene.image.Image;

/**
 * Represents a Melee unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class MeleeUnit extends MilitaryUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public MeleeUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit
            || o instanceof HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'M';
    }


    @Override
    public String toString() {
        return "Melee Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/melee_unit_icon.PNG");
    }
}
