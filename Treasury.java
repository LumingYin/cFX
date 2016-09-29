public class Treasury {
	private int coins = 200;

	public int getCoins() {
		return coins;
	}

	public boolean spend(int cost) {
		if (coins >= cost) {
			coins = coins - cost;
			return true;
		} else {
			return false;
		}
	}

	public void earn(int earnedAmount) {
		coins = coins + earnedAmount;
	}

}