package model;

public class AnglerUnit extends Unit implements Convertable {
    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getFishingShack();
    }

    public char symbol() {
        return 'a';
    }

    public boolean canConvert(TileType type) {
        if (type == TileType.WATER) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Anglers. " + super.toString();
    }
}