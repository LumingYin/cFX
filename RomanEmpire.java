public class RomanEmpire {
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

    public RomanEmpire() {
        population = new Population();
        treasury = new Treasury();
        coalMine = new CoalMine();
        river = new River("Tiber");
        technology = new Technology();
        strategy = new Strategy();
        settlementArray = new Settlement[10];
        hills = new Hills();
    }

    public Hills getHills() {
        return hills;
    }

    public boolean buildAqueduct(Settlement s) {
        if (getNumSettlements() < 10 && s.build(treasury.getCoins(), population, 250, 130)) {
            technology.increaseExperience(10);
            population.canWork(130);
            treasury.spend(250);
            return true;
        } else {
            return false;
        }
    }

    public boolean buildBathHouse(Settlement s) {
        if (getNumSettlements() < 10 && s.build(treasury.getCoins(), population, 110, 20)) {
            technology.increaseExperience(10);
            treasury.spend(110);
            population.canWork(20);
            return true;
        } else {
            return false;
        }
    }


    public boolean buildVilla(Settlement s) {
        if (s.build(treasury.getCoins(), population, 80, 15)) {
            technology.increaseExperience(5);
            treasury.spend(250);
            population.canWork(115);
            return true;
        } else {
            return false;
        }
    }


    public void studyPhilosophy() {
        if (population.getHappiness() >= 10) {
            population.decreaseHappiness(10);
            technology.philosophize();
        }
    }
}