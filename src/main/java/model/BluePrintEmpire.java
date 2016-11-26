package model;

/**
 * Represents the BluePrint Empire civilization.
 *
 * @version 1.0
 * @author Luming Yin
 */
public class BluePrintEmpire extends Civilization {
    private Hills hills = new Hills();

    /**
     * Public constructor.
     */
    public BluePrintEmpire() {
        super("BluePrint Empire");
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
        return new BluePrintEscapeRoom(this);
    }

}
