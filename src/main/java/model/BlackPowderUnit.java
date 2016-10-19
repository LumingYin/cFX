package model;

public class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization c) {
        super(c);
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
    }

    // // do they mean override siege or attack?
    // @Override
    // public void attack(MapObject m) {
    //     getOwner().getStrategy().siege();
    //     // siege(m);
    //     // setCanAttack(false);
    // }

    @Override
        public char symbol() {
        return 'B';
    }

    @Override
        public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
}