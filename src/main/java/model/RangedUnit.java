package model;

class RangedUnit extends MilitaryUnit implements Symbolizable {
    public RangedUnit(Civilization c) {
        super(100, c, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
        if (!m.isDestroyed() && (m instanceof RangedUnit
            || m instanceof HybridUnit)) {
            damage(((MilitaryUnit) m).getDamage());
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

}
