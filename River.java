import java.util.Random;

public class River {
	private String name;
	private Fish[] fishArray = new Fish[5];

	public River(String name) {
		this.name = name;
		generateRandomFish();
	}

	private void generateRandomFish() {
		Random randomNumberGenerator = new Random();
		for (Fish f : fishArray) {
			int n = randomNumberGenerator.nextInt(5);
			f = new Fish(n);
		}
	}

	public Fish getFish() {
		for (Fish f: fishArray) {
			if (f != null) {
				return f;
			}
		}
		return null;
	}

	public boolean replenishFish() {
		boolean isEmpty = true;
		for (Fish f: fishArray) {
			if (f != null) {
				isEmpty = false;
			}
		}
		if (isEmpty == false) {
			return false;
		} else {
			generateRandomFish();
			return true;
		}
	}

	public String getName() {
		return name;
	}
}