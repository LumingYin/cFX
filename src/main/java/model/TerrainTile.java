package model;

import controller.TileType;
import javafx.scene.image.Image;
import java.util.HashMap;

/**
 * Represents a Tile on the game map that has a TileType and possibly a
 * MapObject occupant.
 *
 * @version 1.0
 * @author Jim Harris
 */
public class TerrainTile implements Symbolizable, Viewable {
    private MapObject occupant;
    private TileType type;
    private int row;
    private int col;
    private static HashMap<TileType, Image> tilepics = new HashMap<>();

    static {
        tilepics.put(TileType.PLAINS,
                new Image("File:./src/main/java/view/grass.jpg"));
        tilepics.put(TileType.ICE,
                new Image("File:./src/main/java/view/ice.jpg"));
        tilepics.put(TileType.FOREST,
                new Image("File:./src/main/java/view/forest.jpg"));
        tilepics.put(TileType.MOUNTAIN,
                new Image("File:./src/main/java/view/mountains.jpg"));
        tilepics.put(TileType.DESERT,
                new Image("File:./src/main/java/view/desert.jpg"));
        tilepics.put(TileType.WATER,
                new Image("File:./src/main/java/view/water.jpg"));
    }

    /**
     * Public constructor.
     *
     * @param type the type of the terrain of this tile.
     * @param occupant the MapObject on this tile.
     */
    public TerrainTile(TileType type, MapObject occupant, int row, int col) {
        this.type = type;
        this.occupant = occupant;
        this.row = row;
        this.col = col;
    }

    /**
     * Public constructor.
     *
     * @param type the type of the terrain of this tile.
     */
    public TerrainTile(TileType type, int row, int col) {
        this(type, null, row, col);
    }

    /**
     * @return a TileType representing the kind of terrain this tile has.
     */
    public TileType getType() {
        return type;
    }

    public void setType(TileType a) {
        type = a;
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
                + type.getCost() + "(" + row + ", " + col + ")";
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Image getImage() {
        return tilepics.get(this.type);
    }
}
