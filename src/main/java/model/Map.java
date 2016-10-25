package model;

import java.util.Random;

/**
 * Represents the map that the game will be played on. All MapObjects for the
 * game will be stored on here, each on its own TerrainTile, which are what
 * compose the Map.
 *
 * @version 1.0
 * @author Jim Harris
 */
class Map {

    private TerrainTile[][] map;

    /**
     * Public constructor that builds the map. The graphics for Map will degrade
     * once there are more than 10 rows or 10 columns, as it expects each row
     * and column number to require only one character to represent.
     *
     * @param rows the number of rows this map should have.
     * @param columns the number of columns this map should have.
     */
    public Map(int rows, int columns) {
        TileType[] types = TileType.values();
        map = new TerrainTile[rows][columns];
        Random rand = new Random();
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = new TerrainTile(types[rand.nextInt(types.length)]);
            }
        }
    }

    /**
     * This will return the TerrainTile at the provided coordinates. This will
     * result in a java.lang.ArrayIndexOutOfBoundsException in the event that
     * an invalid tile is entered.
     *
     * @param r the row of the desired tile.
     * @param c the column of the desired tile.
     * @return the TerrainTile at the given coordinates.
     */
    public TerrainTile getTile(int r, int c) {
        return map[r][c];
    }

    /**
     * Returns whether or not a specified tile is empty, i.e the return value
     * of its getOccupant() method is null. This will result in a
     * java.lang.ArrayIndexOutOfBoundsException in the event that an invalid
     * tile is entered.
     *
     * @param r the row of the desired tile to check.
     * @param c the column of the desired tile to check.
     * @return whether or not the tile at the coordinates is empty.
     */
    public boolean isEmpty(int r, int c) {
        return map[r][c].getOccupant() == null;
    }

    /**
     * @return an int representing the number of rows this Map has.
     */
    public int getRows() {
        return map.length;
    }

    /**
     * This will result in a java.lang.ArrayIndexOutOfBoundsException in the
     * event that the Map has no tiles.
     *
     * @return an int representing the number of columns this Map has. This
     */
    public int getColumns() {
        return map[0].length;
    }

    /**
     * Returns a graphical representation of the Map for presentation on a
     * text based game screen. Prints out all of the tiles like this:
     *
     *            /TORC\      Where T is the symbol of the TileType of the tile,
     *            \____/      O is the symbol of the Tile occupant, R is the
     *                        row of the tile as represented in the array, and
     *                        c is the column of the tile as represented in the
     *                        array.
     *
     * @return a String representation of the map.
     */
    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < map[0].length / 2; i++) {
            ret += "      ____";
        }

        if (map[0].length % 2 == 1) {
            ret += "      ____";
        }
        ret += "\n";

        for (int r = 0; r < map.length; r++) {
            String rowString = "";
            for (int c = 0; c < map[r].length; c += 2) {
                TerrainTile tile = map[r][c];
                String tileString = tile.symbol() + ""
                    + (tile.getOccupant() != null
                        ? tile.getOccupant().symbol()
                        : ' ')
                    + "" + r + "" + c;
                rowString += "____/" + tileString + "\\";
            }
            if (map[r].length % 2 == 0) {
                rowString += "____";
            }
            rowString = "     " + rowString.substring(4);
            if (r != 0 && map[r].length % 2 == 0) {
                rowString += "/";
            }
            rowString += "\n     ";
            for (int c = 1; c < map[r].length; c += 2) {
                TerrainTile tile = map[r][c];
                String tileString = tile.symbol() + ""
                    + (tile.getOccupant() != null
                        ? tile.getOccupant().symbol()
                        : ' ')
                    + "" + r + "" + c;
                rowString += "\\____/" + tileString;
            }
            if (map[r].length % 2 == 0) {
                rowString += "\\";
            } else {
                rowString += "\\____/";
            }
            rowString += "\n";
            ret += rowString;
        }

        ret += "      ";

        for (int i = 1; i < map[0].length; i += 2) {
            ret += "    \\____/";
        }

        return ret + "\n";
    }
}
