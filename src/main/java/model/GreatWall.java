package model;

class GreatWall extends Landmark {
    private boolean isFirstRun = true;

    public GreatWall(Civilization c) {
        super(c);
    }

    @Override
    public void invest() {
        super.invest();
        if (isFirstRun) {
            getOwner().getStrategy().battle();
            isFirstRun = false;
        }
    }

    @Override
    public String toString() {
        return "GreatWall. " + super.toString();
    }
}