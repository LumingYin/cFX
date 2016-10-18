package model;

class Farm extends Building {
    public Farm(Civilization owner) {
        super(200, owner, 0, 0, 10, 0, 0, 10);
    }

    @Override
    public char symbol() {
        return '+';
    }

    @Override
    public void invest() {
        int origFoodGeneration = getFoodGeneration();
        setFoodGeneration(origFoodGeneration + 2);
    }

    @Override
    public String toString() {
        return "Farm. " + super.toString();
    }

}