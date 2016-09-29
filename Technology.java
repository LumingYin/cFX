public class Technology {
	private int understanding = 0;
	private boolean foundMeaningOfLife = false;
	private int experienceLevel = 0;
	private boolean builtWonderOfTheWorld = false;

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
	}

	private void updateBuiltWonderOfTheWorld() {
		if (experienceLevel > 200) {
			builtWonderOfTheWorld = true;
		}
	}

	public boolean hasTechnologyWin() {
		boolean winStatus = builtWonderOfTheWorld && foundMeaningOfLife ? true : false;
		return winStatus;
	}

	public int getUnderstanding() {
		return understanding;
	}

	public int getBuildExperience() {
		return experienceLevel;
	}

}