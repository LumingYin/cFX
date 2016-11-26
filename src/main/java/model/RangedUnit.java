package model;

import javafx.scene.image.Image;

/**
 * Represents a Ranged unit.
 *
 * @version 1.0
 * @author Jim Harris
 */
class RangedUnit extends MilitaryUnit {

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public RangedUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof RangedUnit
            || o instanceof HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'R';
    }


    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/range_unit_icon.PNG");
    }
}
