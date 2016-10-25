package model;

import java.util.Random;

/**
 * Represents the different specific technologies or skills that
 * a Civilization can acquire. There are 20 different Skills
 *
 * @author Ryan Voor
 * @version 1.0
 */
enum Skill {
    POTTERY ("Pottery"),
    ARGRICULTURE ("Agriculture"),
    COMPUTING ("Computing"),
    RADIO ("Radio"),
    ARCHERY ("Archery"),
    PAINTING ("Painting"),
    SAILING ("Sailing"),
    MINING ("Mining"),
    MATHEMATICS ("Mathematics"),
    ENGINEERING ("Engineering"),
    ASTRONOMY ("Astronomy"),
    STEEL ("Steel"),
    BANKING ("Banking"),
    GUNPOWDER ("Gunpowder"),
    CHEMISTRY ("Chemistry"),
    ECONOMICS ("Economics"),
    DYNAMITE ("Dynamite"),
    ELECTRICITY ("Electricity"),
    NUCLEAR_FISSION ("Nuclear Fission"),
    LASERS ("Lasers");

    private String value;

    /**
     * Constructs a new Skill with the given String as
     * the String representation of that Skill
     * @param value the String value of the Skill
     */
    private Skill(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private static Random rand = new Random();

    /**
     * Gets a random Skill enum object
     * @return Skill a random Skill enum object
     */
    public static Skill getRandomSkill() {
        return Skill.values()[rand.nextInt(20)];
    }
}
