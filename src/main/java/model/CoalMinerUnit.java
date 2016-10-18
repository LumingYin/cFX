package model;

public class CoalMinerUnit extends Unit implements Convertable {
    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    public Building convert() {
        return this.getOwner().getCoalMine();
    }

    public char symbol() {
        return 'c';
    }

    public boolean canConvert(TileType type) {
        if (type == TileType.HILLS) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Coal Miners. " + super.toString();
    }
}