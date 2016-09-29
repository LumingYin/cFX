public class Game {
	private int healthIncrease;

	public Game(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}

	public Game() {
		healthIncrease = 20;
	}

	public int getHealth() {
		return healthIncrease;
	}
}