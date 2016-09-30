public class QinDynasty {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlementArray;
    // specific variable begins here
    private Hills hills;

    // generic methods
    public boolean settle(Settlement s) {
        for (int i = 0; i < settlementArray.length; i++) {
            if (settlementArray[i] == null) {
                settlementArray[i] = s;
                return true;
            }
        }
        return false;
    }

    public int getNumSettlements() {
        int numOfSettlements = 0;
        for (int i = 0; i < settlementArray.length; i++) {
            if (settlementArray[i] != null) {
                numOfSettlements = numOfSettlements + 1;
            }
        }
        return numOfSettlements;
    }

    public Population getPopulation() {
        return population;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public CoalMine getCoalMine() {
        return coalMine;
    }

    public River getRiver() {
        return river;
    }

    public Technology getTechnology() {
        return technology;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Settlement[] getSettlements() {
        return settlementArray;
    }

    // specific methods begins here

    public QinDynasty() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Qin");
        technology = new Technology();
        strategy = new Strategy();
        settlementArray = new Settlement[10];
        hills = new Hills();
    }

    public Hills getHills() {
        return hills;
    }

    public boolean buildWall(Settlement s) {
        if (this.getNumSettlements() < 10 && s.build(treasury.getCoins(), population, 1000, 100)) {
            technology.increaseExperience(10);
            treasury.spend(1000);
            population.canWork(100);
            return true;
        } else {
            return false;
        }
    }


    public boolean buildHouse(Settlement s) {
        if (this.getNumSettlements() < 10 && s.build(treasury.getCoins(), population, 30, 8)) {
            technology.increaseExperience(10);
            treasury.spend(30);
            population.canWork(8);
            return true;
        } else {
            return false;
        }
    }

    public void establishLegalism() {
        if (population.getHappiness() >= 20) {
            technology.philosophize();
            population.decreaseHappiness(20);
        }
    }
}