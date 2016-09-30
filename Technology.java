public class Technology {
    private int understanding;
    private boolean foundMeaningOfLife;
    private int experienceLevel;
    private boolean builtWonderOfTheWorld;

    public Technology() {
        understanding = 0;
        foundMeaningOfLife = false;
        experienceLevel = 0;
        builtWonderOfTheWorld = false;
    }

    public void philosophize() {
        understanding = understanding + 25;
        updateFoundMeaningOfLife();
    }

    public void improveWriting() {
        understanding = understanding + 10;
        updateFoundMeaningOfLife();
    }

    private void updateFoundMeaningOfLife() {
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void increaseExperience(int experienceLevelIncrease) {
        experienceLevel = experienceLevel + experienceLevelIncrease;
        updateBuiltWonderOfTheWorld();
    }

    private void updateBuiltWonderOfTheWorld() {
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public boolean hasTechnologyWin() {
        // I have heard mixed discussions as whether
        // it requires both builtWonderOfTheWorld and
        // foundMeaningOfLife to be true in order for
        // technology to win

        // "||" (OR) is used as indicated by the
        // discussions on Piazza
        boolean winStatus =
            builtWonderOfTheWorld || foundMeaningOfLife ? true : false;
        return winStatus;
    }

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }

}