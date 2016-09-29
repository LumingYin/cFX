public class Settlement {

	private Building[] buildingArray;
	private String name;

	public boolean addBuilding(Building b) {
		for (int i = 0; i < buildingArray.length; i++) {
			if (buildingArray[i] == null) {
				buildingArray[i] = b;
				return true;
			}
		}
		return false;
	}

	public Settlement(String s) {
		name = s;
	}

	public boolean build(int allottedMoney, Population population, int cost, int workersRequired) {
		if (cost < allottedMoney && workersRequired <= population.getPopulation()) {
			allottedMoney = allottedMoney - cost;
			return true; //stub to be done
		} else {
			return false;
		}
	}

	public boolean expandSettlement() {
		int origLength = buildingArray.length;
		buildingArray = new Building[origLength];
		return true; //stub
	}

	public String getName() {
		return name;
	}

	// public void setName(String s) {
	// 	name = s;
	// }
}