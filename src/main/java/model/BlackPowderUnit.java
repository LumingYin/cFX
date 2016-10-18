package model;

public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization c) {
        super(c);
    }

    // do they mean override siege or attack?
    @Override
    public void attack(MapObject m) {
        getOwner().getStrategy().siege();
        // siege(m);
        // setCanAttack(false);
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