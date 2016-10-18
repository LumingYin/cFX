package model;

public class WarChariot extends RangedUnit {

    public WarChariot(Civilization c) {
        super(c);
        this.setBaseEndurance(2 * this.getBaseEndurance());
    }

    @Override
    public char symbol() {
        return 'W';
    }

    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }
}
