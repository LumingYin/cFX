package model;

class HybridUnit extends MilitaryUnit {
    public HybridUnit(Civilization owner) {
        super(50, owner, 10, 10, 14, 5, 0, 30);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'H';
    }


    @Override
    public String toString() {
        return "Hybrid Unit. " + super.toString();
    }
}
