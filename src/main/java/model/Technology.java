package model;

class Technology {

    private int buildExperience;
    private boolean builtWonderOfTheWorld;

    private int understanding;
    private boolean foundMeaningOfLife;

    public int getUnderstanding() {
        return understanding;
    }

    public int getBuildExperience() {
        return buildExperience;
    }

    public void increaseBuildExperience() {
        buildExperience += 20;
        builtWonderOfTheWorld = (buildExperience >= 200);
    }

    public void increaseBuildExperience(int i) {
        buildExperience += i;
        builtWonderOfTheWorld = (buildExperience >= 200);
    }

    public boolean builtWonderOfTheWorld() {
        return builtWonderOfTheWorld;
    }

    public void increaseUnderstanding(int increase) {
        understanding += increase;
        foundMeaningOfLife = (understanding >= 200);
    }

    public void philosophize() {
        increaseUnderstanding(25);
    }

    public void improveWriting() {
        increaseUnderstanding(10);
    }

    public boolean hasTechnologyWin() {
        return builtWonderOfTheWorld || foundMeaningOfLife;
    }
}
