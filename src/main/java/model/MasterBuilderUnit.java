package model;

class MasterBuilderUnit extends Unit implements Convertable {
    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getLandmark();
    }

    public char symbol() {
        return 'm';
    }

    public boolean canConvert(TileType type) {
        if (type == TileType.PLAINS) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Master Builders. " + super.toString();
    }
}