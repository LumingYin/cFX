package model;

public class SettlerUnit extends Unit implements Convertable {
    private String nameOfTownToSettle;

    public SettlerUnit(Civilization owner, String nameOfTownToSettle) {
        super(owner);
        this.nameOfTownToSettle = nameOfTownToSettle;
    }

    public Building convert() {
        this.getOwner().incrementNumSettlements();
        return this.getOwner().getSettlement(nameOfTownToSettle);
    }

    public char symbol() {
        return 's';
    }

    public boolean canConvert(TileType type) {
        if (type == TileType.PLAINS) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Settlers of " + nameOfTownToSettle + ". " + super.toString();
    }
}