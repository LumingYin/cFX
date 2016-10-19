package model;

class RomanEmpire extends Civilization {
    private Hills hills;

    public RomanEmpire() {
        super("Roman Empire");
        hills = new Hills();
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }

    @Override
    public String explore() {
        hills.replenishGame();
        int minedCoal = hills.mineCoal();
        super.produceResources(minedCoal);
        return "You mined the coal and acquired " + minedCoal + " coal!";
    }

}
