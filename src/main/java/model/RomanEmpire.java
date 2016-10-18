package model;

class RomanEmpire extends Civilization {
    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        hills.replenishGame();
        int minedCoal = hills.mineCoal();
        super.produceResources(minedCoal);
        return "You mined the coal and acquired " + minedCoal + " coal!";
    }

}
