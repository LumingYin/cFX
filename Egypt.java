public class Egypt {
    private Population population;
    private Treasury treasury;
    private CoalMine coalMine;
    private River river;
    private Technology technology;
    private Strategy strategy;
    private Settlement[] settlementArray;
    // specific variable begins here
    private Desert desert;

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

    public Egypt() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Bolbitinic");
        technology = new Technology();
        strategy = new Strategy();
        settlementArray = new Settlement[10];
        desert = new Desert();
    }

    public Desert getDesert() {
        return desert;

    }

    public boolean buildPyramid(Settlement s) {
        if (getNumSettlements() < 10 && s.build(treasury.getCoins(), population, 500, 100)) {
            technology.increaseExperience(10);
            treasury.spend(500);
            population.canWork(100);
            return true;
        } else {
            return false;
        }
    }

    public void practiceHieroglyphics() {
        population.increaseHappiness(10);
        technology.improveWriting();
    }


}