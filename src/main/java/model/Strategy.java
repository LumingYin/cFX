package model;

class Strategy {
    private int strategyLevel;
    private boolean conqueredTheWorld;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;

    public void battle() {
        strategyLevel += BATTLE_INCREASE;
        setConqueredTheWorld();
    }

    public void siege() {
        strategyLevel += SIEGE_INCREASE;
        setConqueredTheWorld();
    }

    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }

    private void setConqueredTheWorld() {
        conqueredTheWorld = (strategyLevel >= 150);
    }
}
