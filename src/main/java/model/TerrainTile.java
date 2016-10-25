package model;

/**
 * Represents a Tile on the game map that has a TileType and possibly a
 * MapObject occupant.
 *
 * @version 1.0
 * @author Jim Harris
 */
class TerrainTile implements Symbolizable {
    private MapObject occupant;
    private TileType type;

    /**
     * Public constructor.
     *
     * @param type the type of the terrain of this tile.
     * @param occupant the MapObject on this tile.
     */
    public TerrainTile(TileType type, MapObject occupant) {
        this.type = type;
        this.occupant = occupant;
    }

    /**
     * Public constructor.
     *
     * @param type the type of the terrain of this tile.
     */
    public TerrainTile(TileType type) {
        this(type, null);
    }

    /**
     * @return a TileType representing the kind of terrain this tile has.
     */
    public TileType getType() {
        return type;
    }

    /**
     * Sets the occupant of this tile.
     *
     * @param occupant the MapObject that is on this tile.
     */
    public void setOccupant(MapObject occupant) {
        this.occupant = occupant;
    }

    /**
     * @return the MapObject occupying this tile.
     */
    public MapObject getOccupant() {
        return occupant;
    }

    /**
     * @return whether or not this tile is empty (has no occupant).
     */
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
