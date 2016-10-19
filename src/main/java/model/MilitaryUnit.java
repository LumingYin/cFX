package model;

public abstract class MilitaryUnit extends Unit {
    private int damage;

    public MilitaryUnit(int health, Civilization c, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {
        super(health, c, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int d) {
        this.damage = d;
    }

    @Override
    public void tick() {
        super.tick();
        setCanAttack(true);
    }

    abstract void battle(MapObject m);

    public void attack(MapObject m) {
        if (getCanAttack()) {
            getOwner().getStrategy().battle();
            battle(m);
            setCanAttack(false);            
        }
    }

    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }
}