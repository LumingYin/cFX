import java.util.Random;

public class River {
    private String name;
    private Fish[] fishArray = new Fish[5];
    private Random randomNumberGenerator;

    public River(String name) {
        randomNumberGenerator = new Random();
        this.name = name;
        generateRandomFish();
    }

    private void generateRandomFish() {
        for (int i = 0; i < fishArray.length; i++) {
            int n = randomNumberGenerator.nextInt(5);
            fishArray[i] = new Fish(n);
        }
    }

    public Fish getFish() {
        for (int i = 0; i < fishArray.length; i++) {
            if (fishArray[i] != null) {
                Fish toBeReturned = fishArray[i];
                fishArray[i] = null;
                return toBeReturned;
            }
        }
        return null;
    }

    public boolean replenishFish() {
        if (riverIsEmpty()) {
            generateRandomFish();
            return true;
        } else {
            return false;
        }
    }

    private boolean riverIsEmpty() {
        for (int i = 0; i < fishArray.length; i++) {
            if (fishArray[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }
}