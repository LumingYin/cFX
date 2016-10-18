package model;

class Coliseum extends Landmark {
    public Coliseum(Civilization c) {
        super(c);
    }

    private boolean isFirstRun = true;

    @Override
    public void invest() {
        super.invest();
        if (isFirstRun) {
            getOwner().increaseHappiness(50);
            isFirstRun = false;
        }
    }

    @Override
    public String toString() {
        return "Coliseum. " + super.toString();
    }
}