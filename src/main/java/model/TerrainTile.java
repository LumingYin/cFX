package model;

class TerrainTile implements Symbolizable {
    private MapObject occupant;
    private TileType type;

    public TerrainTile(TileType type, MapObject occupant) {
        this.type = type;
        this.occupant = occupant;
    }

    public TerrainTile(TileType type) {
        this(type, null);
    }

    public TileType getType() {
        return type;
    }

    public void setOccupant(MapObject occupant) {
        this.occupant = occupant;
    }

    public MapObject getOccupant() {
        return occupant;
    }

    public boolean isEmpty() {
        return occupant == null;
    }

    @Override
    public char symbol() {
        return type.getSymbol();
    }

    @Override
    public String toString() {
        return type.getName() + " tile that has an endurance cost of "
            + type.getCost();
    }
}
