package model;

/**
 * Represents the Roman Empire civilization.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris
 */
class RomanEmpire extends Civilization {
    private Hills hills = new Hills();

    /**
     * Public constructor.
     */
    public RomanEmpire() {
        super("Roman Empire");
    }

    @Override
    public String explore() {
        int resources = hills.mineCoal();
        produceResources(resources);
        return "You go mining and get " + resources + " resources!";
    }

    /**
     * @return the Hills for this Civilization.
     */
    public Hills getHills() {
        return hills;
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }

}
