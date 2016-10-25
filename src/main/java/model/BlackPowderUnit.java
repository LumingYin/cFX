package model;

/**
 * Represents a Black Powder unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class BlackPowderUnit extends SiegeUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

    @Override
    public char symbol() {
        return 'B';
    }


    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
}
