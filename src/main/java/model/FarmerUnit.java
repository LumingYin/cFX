package model;

public class FarmerUnit extends Unit implements Convertable {
    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getFarm();
    }

    public char symbol() {
        return 'f';
    }

    public boolean canConvert(TileType type) {
        if (type == TileType.PLAINS) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Farmers. " + super.toString();
    }
}