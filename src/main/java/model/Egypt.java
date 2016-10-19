package model;

class Egypt extends Civilization {
    private Desert desert;

    public Egypt() {
        super("Egypt");
        desert = new Desert();
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int foundTreasure = desert.findTreasure();
        getTreasury().earn(foundTreasure);
        return "You explored the desert and acquired "
            + foundTreasure + " gold!";
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }

}
