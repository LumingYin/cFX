package model;

/**
 * Represnts a Great Wall that can increase strategy.
 *
 * @version 1.0
 * @author Jim Harris
 */
class GreatWall extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public GreatWall(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getStrategy().battle();
    }

    @Override
    public String toString() {
        return "Great Wall " + super.toString();
    }
}
