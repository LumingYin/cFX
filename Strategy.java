public class Strategy {
    private int strategyLevel;
    private boolean conqueredTheWorld;
    private static final int BATTLE_INCREASE = 10;
    private static final int SIEGE_INCREASE = 40;

    public void battle() {
        strategyLevel = strategyLevel + BATTLE_INCREASE;
        updateConqueredTheWorld();
    }

    public void sigue() {
        strategyLevel = strategyLevel + SIEGE_INCREASE;
        updateConqueredTheWorld();
    }

    private void updateConqueredTheWorld() {
        conqueredTheWorld = strategyLevel > 180 ? true : false;
    }

    public boolean hasTechnologyWin() {
        updateConqueredTheWorld();
        return conqueredTheWorld;
    }
    public boolean conqueredTheWorld() {
        return conqueredTheWorld;
    }

    public int getStrategyLevel() {
        return strategyLevel;
    }
}