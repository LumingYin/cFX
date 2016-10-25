package model;

/**
 * Represents a Military unit that is able to fight.
 *
 * @version 1.0
 * @author Jim Harris
 */
abstract class MilitaryUnit extends Unit {

    private int damage;

    /**
     * Public constructor.
     *
     * @param health an int representing the health of this unit.
     * @param owner the owner of this unit.
     * @param baseEndurance how far this unit can move each turn.
     * @param pay how much gold this unit costs per turn.
     * @param initialGoldCost how much gold this unit costs to hire.
     * @param initialFoodCost how much food this unit requires to hire.
     * @param initialResourceCost how many resources this unit needs to hire.
     * @param damage how much damage this unit can deal.
     */
    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }

    @Override
    public void tick() {
        super.tick();
        setCanAttack(true);
    }

    /**
     * @return an int representing the damage this unit can deal.
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Sets the damage of this unit.
     *
     * @param damage the amount of damage this unit can deal.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Makes this unit attack another MapObject on the game map.
     *
     * @param o the enemy MapObject to attack.
     */
    public void attack(MapObject o) {
        getOwner().getStrategy().battle();
        battle(o);
        setCanAttack(false);
    }

    /**
     * Inflicts damage to another MapObject, and allows that MapObject to
     * execute a counterattack if possible.
     *
     * @param o the enemy MapObject to damage.
     */
    public abstract void battle(MapObject o);


    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }
}
