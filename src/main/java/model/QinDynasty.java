package model;

class QinDynasty extends Civilization {
    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        hills.replenishGame();
        int foundFood = hills.hunt().getHealth();
        makeFood(foundFood);
        return "You explored the hills and acquired " + foundFood
            + " health, which translates to food!";
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

}
