package model;

class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization c) {
        super(c);
    }

    @Override
    public void battle(MapObject m) {
        m.damage(this.getDamage());
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