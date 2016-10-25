package model;

/**
 * Represents a Master Builder unit that can build a Landmark.
 *
 * @author Jim Harris
 * @version 1.0
 */
class MasterBuilderUnit extends Unit implements Convertable {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public MasterBuilderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getLandmark();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 'm';
    }

    @Override
    public String toString() {
        return "Master Builders. " + super.toString();
    }
}
