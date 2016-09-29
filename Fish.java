public class Fish {
    private int healthIncrease;

    public Fish(int health) {
        this.healthIncrease = health;
    }

    public Fish() {
        this(20);
    }

    public int getHealth() {
        return healthIncrease;
    }
}