package model;

/**
 * Represents something that can be converted into a Building.
 */
interface Convertable {

    /**
     * @return the Building that this object turns into.
     */
    Building convert();

    /**
     * @return a boolean representing whether or not this object can convert.
     *
     * @param type the type of terrain tile this unit is currently on.
     */
    boolean canConvert(TileType type);
}
