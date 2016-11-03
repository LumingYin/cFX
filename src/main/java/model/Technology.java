package model;

/**
 * Holds all the Technology information for a Civilization
 *
 * @author Ryan Voor
 * @version 2.0
 */
class Technology {

    private int techPoints;
    private SimpleSet<Skill> skills;

    /**
     * Constructs a new Technology object
     * initializes techPoints to 0 and
     * initializes skills to an empty MySet of Skills.
     */
    public Technology() {
        techPoints = 0;
        skills = new MySet<>();
    }

    /**
     * Increments techPoints and adds a new
     * Skill to the techs set. The Skill that is added
     * should be random (HINT: take a look at the getRandomSkill()
     * method in the Skill class)
     */
    public void gainATech() {
        techPoints++;
        boolean looping = true;
        while (looping) {
            looping = !skills.add(Skill.getRandomSkill());
        }
    }

    /**
     * Getter for the techPoints of this Civilization
     * @return int the techPoints of this Civilization
     */
    public int getTechPoints() {
        return techPoints;
    }

    /**
     * Getter for the skills of this Civilization
     * @return SimpleSet of Skills this Civilization
     */
    public SimpleSet<Skill> getSkills() {
        return skills;
    }

    /**
     * Returns whether this Civilization has achieved a Technology win
     * @return boolean whether this Civilization has achieved 20 techPoints
     */
    public boolean hasTechnologyWin() {
        return techPoints >= 20;
    }

    /**
     * @return an int representing the amount of understanding.
     */
    public int getUnderstanding() {
        return getTechPoints();
    }

    /**
     * @return an int representing the amount of build experience.
     */
    public int getBuildExperience() {
        return getTechPoints();
    }

    /**
     * Adds a technical skill.
     */
    public void increaseBuildExperience() {
        gainATech();
    }

    /**
     * Adds a technical skill.
     *
     * @param i HAH
     */
    public void increaseBuildExperience(int i) {
        gainATech();
    }

    /**
     * @return a boolean representing whether or not the player has built a
     * nifty tourist attraction.
     */
    public boolean builtWonderOfTheWorld() {
        return techPoints >= 10;
    }

    /**
     * Increases understanding by a specified amount.
     *
     * @param increase HAH
     */
    public void increaseUnderstanding(int increase) {
        gainATech();
    }

    /**
     * Adds a technical skill.
     */
    public void philosophize() {
        gainATech();
    }

    /**
     * Adds a technical skill.
     */
    public void improveWriting() {
        gainATech();
    }
}
