import java.util.Random;

public class Population {
    private int warriors;
    private int civilians;
    private int happiness;
    private Random rand;

    public Population() {
        warriors = 50;
        civilians = 50;
        happiness = 200;
        rand = new Random();
    }

    public void increaseHappiness(int amount) {
        happiness = happiness + amount;
    }

    public void decreaseHappiness(int amount) {
        if (amount > happiness) {
            happiness = happiness - amount;
        } else {
            happiness = 0;
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

    public boolean canCook(Game g, CoalMine c) {
        int tempNumberOfBurns = 0;
        for (int i = 0; i < 4; i++) {
            c.burn();
            tempNumberOfBurns++;
        }
        if (tempNumberOfBurns == 4) {
            warriors = warriors + 40;
            civilians = civilians + 60;
            return true;
        } else {
            c.increaseCoal(tempNumberOfBurns);
            return false;
        }
    }

    public boolean canCook(Fish f, CoalMine c) {
        int tempNumberOfBurns = 0;
        for (int i = 0; i < 4; i++) {
            c.burn();
            tempNumberOfBurns++;
        }
        if (tempNumberOfBurns == 4) {
            warriors = warriors + 10;
            civilians = civilians + 15;
            return true;
        } else {
            c.increaseCoal(tempNumberOfBurns);
            return false;
        }
    }

    public int getHappiness() {
        return happiness;
    }


}