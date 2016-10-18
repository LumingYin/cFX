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
        int minedCoal = hills.mineCoal();
        makeFood(minedCoal);
        return "You mined the coal and acquired " + minedCoal + " coal!";
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
