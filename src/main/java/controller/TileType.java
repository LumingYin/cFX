package controller;

/**
 * An enum representing the terrain type of a TerrainTile.
 *
 * @version 1.0
 * @author Jim Harris
 */
public enum TileType {

    PLAINS('P', "Plains", 1),
    MOUNTAIN('M', "Mountain", 5),
    HILLS('H', "Hills", 3),
    ICE('I', "Ice", 3),
    WATER('W', "Water", 5),
    DESERT('D', "Desert", 3),
    FOREST('F', "Forest", 2);

    private char symbol;
    private String name;
    private int cost;

    /**
     * Public constructor.
     *
     * @param symbol the symbol to represent this kind of tile.
     * @param name the name of this kind of terrain.
     * @param cost the endurance needed to traverse this kind of tile.
     */
    TileType(char symbol, String name, int cost) {
        this.symbol = symbol;
        this.name = name;
        this.cost = cost;
    }

    /**
     * @return the symbol for this kind of tile.
     */
    public char getSymbol() {
        return this.symbol;
    }

    /**
     * @return a String representing the name of this tile type.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return an int representing the cost to move over this kind of tile.
     */
    public int getCost() {
        return this.cost;
    }


    public String getTerrain() {
        return name;
    }
}