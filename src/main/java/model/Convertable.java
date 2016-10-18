package model;

interface Convertable {
    Building convert();
    boolean canConvert(TileType type);
}
