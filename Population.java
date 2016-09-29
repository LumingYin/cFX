import java.util.Random;

public class Population {
	private int warriors = 50;
	private int civilians = 50;
	private int happiness = 200;
    private Random rand = new Random();

    public void increaseHappiness(int amount) {
    	happiness = happiness + amount;
    }

    public void decreaseHappiness(int amount) {
        if (amount > happiness) {
		  happiness = happiness - amount;
        }
	}

	public void canWork(int numberOfWorkers) {
		if (numberOfWorkers <= civilians) {
			civilians = civilians - numberOfWorkers;
		}
	}

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public Game hunt(Hills h) {
    	return h.hunt();
    }

    public Fish fish(River r) {
    	return r.getFish();
    }

    public int getPopulation() {
        return warriors + civilians + happiness;
    }

    public int getWarriors() {
        return warriors;
    }

    public int getCivilians() {
        return civilians;
    }

    public void setWarriors(int a) {
        this.warriors = a;
    }

    public boolean canCook(Game f, CoalMine c) {
        int totalNumberOfBurns = 0;
        //if (totalNumberOfBurns >= 4) {
        for (int i = 0; i < 4; i++) {
            c.burn();
            totalNumberOfBurns++;
        }
            if (totalNumberOfBurns == 4) {
                warriors = warriors + 40;
                civilians = civilians + 60;
                return true;
        } else {
            c.increaseCoal(totalNumberOfBurns);
            return false;
        }
    }

    public boolean canCook(Fish f, CoalMine c) {
        return false;
    }

}