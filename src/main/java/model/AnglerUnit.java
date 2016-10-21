package model;

class AnglerUnit extends Unit implements Convertable {
    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return this.getOwner().getFishingShack();
    }

    @Override
    public char symbol() {
        return 'a';
    }

    @Override
    public boolean canConvert(TileType type) {
        if (type == TileType.WATER) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Anglers. " + super.toString();
    }
}