package model;

/**
 * Represents a Landmark that can generate tech points.
 *
 * @version 1.0
 * @author Jim Harris
 */
class Landmark extends Building {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Landmark(Civilization owner) {
        super(200, owner, 0, 0, 0, 10, 0, 10);
    }

    @Override
    public void invest() {
        setTechPointGeneration(getTechPointGeneration() + 5);
    }

    @Override
    public char symbol() {
        return '!';
    }

    @Override
    public String toString() {
        return "Landmark. " + super.toString();
    }
}
