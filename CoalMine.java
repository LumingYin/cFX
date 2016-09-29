public class CoalMine {
    private int coal;
    private static final int BURN_COST = 10;

    public CoalMine() {
        coal = 20;
    }

    public boolean burn() {
        if (coal >= BURN_COST) {
            coal -= BURN_COST;
            return true;
        }
        return false;
    }

    public int getBurnCost() {
        return BURN_COST;
    }

    public int getCoal() {
        return coal;
    }

    public void increaseCoal(int addedCoal) {
        coal += addedCoal;
    }
}