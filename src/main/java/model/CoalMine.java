package model;

class CoalMine extends Building {
    private static final int COAL = 20;
    private int burnCost = 10;

    public CoalMine(Civilization owner) {
        super(200, owner, 0, 0, 0, 0, 0, 0);
        setResourceGeneration(COAL - burnCost);
    }

    @Override
    public void invest() {
        if (burnCost > 0) {
            burnCost -= 1;
        }
        setResourceGeneration(COAL - burnCost);
    }

    @Override
    public char symbol() {
        return '(';
    }

    public int getBurnCost() {
        return burnCost;
    }

    public int getCoal() {
        return COAL;
    }

    @Override
    public String toString() {
        return "Coalmine. " + super.toString();
    }
}
