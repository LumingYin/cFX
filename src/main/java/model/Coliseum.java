package model;

class Coliseum extends Landmark {
    private boolean isFirstRun;

    public Coliseum(Civilization c) {
        super(c);
        isFirstRun = true;
    }

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