package model;

/**
 * Represents a War Charior unit.
 *
 * @version 1.0
 * @author Jim Harris
 */
class WarChariotUnit extends RangedUnit {

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public WarChariotUnit(Civilization owner) {
        super(owner);
        this.setBaseEndurance(this.getBaseEndurance() * 2);
        this.regenerateEndurance();
    }

    @Override
    public char symbol() {
        return 'W';
    }


    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }
}
