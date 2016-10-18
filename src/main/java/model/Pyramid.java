package model;

class Pyramid extends Landmark {

    public Pyramid(Civilization c) {
        super(c);
    }

    private boolean isFirstRun = true;

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