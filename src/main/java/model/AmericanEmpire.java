package model;

/**
 * Represents the American Empire civilization.
 *
 * @version 1.0
 * @author Luming Yin
 */
public class AmericanEmpire extends Civilization {
    private Hills hills = new Hills();

    /**
     * Public constructor.
     */
    public AmericanEmpire() {
        super("American Empire");
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
        return new AmericanEmpireUniversity(this);
    }

}
