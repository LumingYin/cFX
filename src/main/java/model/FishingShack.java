package model;

import java.util.Random;
import javafx.scene.image.Image;

/**
 * represents a FishingShack type of Building on a Tile on the Map
 * @author Ryan Voor
 * @version 3.0
 */
public class FishingShack extends Building {
    private SimpleSet<Fish> fish;
    private static Random rand = new Random();

    /**
     * constructs a new FishingShack object with the
     * given Civilization as its owner
     */
    public FishingShack(Civilization owner) {
        super(200, owner, 5, 0, 10, 0, 0, 10);
        fish = new MySet<>();
        invest();
    }

    @Override
    public void invest() {
        replenishFish();
        int foodGeneration = 0;
        int goldGeneration = 0;
        Object[] fishes = fish.toArray();
        for (Object o : fishes) {
            Fish f = (Fish) o;
            foodGeneration += (int) (f.getHealth() / 2);
            goldGeneration += f.getHealth() - foodGeneration;
        }
        setFoodGeneration(foodGeneration);
        setGoldGeneration(goldGeneration);
    }

    @Override
    public char symbol() {
        return '&';
    }

    /**
     * Returns a random Fish from the FishingShack if there are
     * any Fish in the FishingShack. The Fish that is returned
     * should be removed. Returns null if there
     * are no Fish in the FishingShack.
     * @return the fish removed from the FishingShack
     */
    public Fish getFish() {
        try {
            Fish toBeReturned = fish.getRandomElement();
            return fish.remove(toBeReturned);
        } catch (ElementDoesNotExistException e) {
            return null;
        }
    }

    /**
     * Puts 5 new Fish into the FishingShack if the FishingShack is
     * empty.
     * Each Fish should be passed 2 random numbers from 0 (inclusive)
     * to 5 (exclusive)
     * Returns true if the FishingShack's Fish were replenished.
     * Returns false if the FishingShack's Fish were not replenished.
     * @return whether the FishingShack's Fish were replenished
     */
    public boolean replenishFish() {
        if (!fish.isEmpty()) {
            return false;
        }
        while (fish.size() < 5) {
            fish.add(new Fish(rand.nextInt(5), rand.nextInt(5)));
        }
        return true;
    }

    @Override
    public String toString() {
        return "FishingShack. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/fishing_shack_icon.PNG");
    }
}
