package model;

/**
 * Represents a Coal Miner unit that can build a coal mine.
 *
 * @author Jim Harris
 * @version 1.0
 */
class CoalMinerUnit extends Unit implements Convertable {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getCoalMine();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.HILLS;
    }

    @Override
    public char symbol() {
        return 'c';
    }

    @Override
    public String toString() {
        return "Coal miners. " + super.toString();
    }
}
