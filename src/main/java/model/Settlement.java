package model;

class Settlement extends Building {
    private String name;
    private int numBuildings;

    public Settlement(Civilization owner, String name) {
        super(200, owner, 10, 0, 0, 0, 0, 10);
        this.name = name;
        numBuildings = 0;
    }

    @Override
    public void invest() {
        setPhilosophyGeneration(getPhilosophyGeneration() + 5);
        numBuildings++;
        setGoldGeneration(getGoldGeneration() + 5);
    }

    @Override
    public char symbol() {
        return '$';
    }

    public String getName() {
        return name;
    }

    public int getNumBuildings() {
        return numBuildings;
    }

    @Override
    public String toString() {
        return name + " Settlement. " + super.toString();
    }
}
