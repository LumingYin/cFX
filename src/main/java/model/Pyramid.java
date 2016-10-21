package model;

class Pyramid extends Landmark {
    private boolean isFirstRun;

    public Pyramid(Civilization c) {
        super(c);
        isFirstRun = true;
    }

    @Override
    public void invest() {
        super.invest();
        if (isFirstRun) {
            getOwner().getTechnology().philosophize();
            isFirstRun = false;
        }
    }

    @Override
    public String toString() {
        return "Pyramid. " + super.toString();
    }
}