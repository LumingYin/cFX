package model;

public class LegionUnit extends MeleeUnit {
    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage((int) (1.5 * getDamage()));
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
        if (!m.isDestroyed() && (!(m instanceof HybridUnit))) {
            damage(((MilitaryUnit) m).getDamage());
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
