package model;

/**
 * Represents a Legion unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class LegionUnit extends MeleeUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public LegionUnit(Civilization owner) {
        super(owner);
        this.setDamage((int) (this.getDamage() * 1.5));
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }
}
