package model;

public class MeleeUnit extends MilitaryUnit implements Symbolizable {
    public MeleeUnit(Civilization c) {
        super(100, c, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
        if (!m.isDestroyed() && (m instanceof MeleeUnit
            || m instanceof HybridUnit)) {
            damage(((MilitaryUnit) m).getDamage());
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

}
