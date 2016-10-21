package model;

class SettlerUnit extends Unit implements Convertable {
    private String townName;

    public SettlerUnit(Civilization owner, String townName) {
        super(owner);
        this.townName = townName;
    }

    public Building convert() {
        this.getOwner().incrementNumSettlements();
        return this.getOwner().getSettlement(townName);
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
        return "Settlers of " + townName + ". " + super.toString();
    }
}