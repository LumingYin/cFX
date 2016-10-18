package model;

public class SiegeUnit extends MilitaryUnit implements Symbolizable {
    public SiegeUnit(Civilization c) {
        super(200, c, 5, 10, 14, 5, 10, 60);
    }

    @Override
    public void battle(MapObject m) {
        if (m instanceof Building) {
            m.damage(this.getDamage());
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
    public void attack(MapObject m) {
        getOwner().getStrategy().siege();
        // siege(m);
        setCanAttack(false);
    }

}
