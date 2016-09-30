public class Settlement {
    private Building[] buildingArray;
    private String name;
    private int numberOfBuildings;

    public Settlement(String s) {
        name = s;
        buildingArray = new Building[0];
        numberOfBuildings = 0;
    }

    public void addBuilding(Building b) {
        if (numberOfBuildings >= buildingArray.length) {
            expandSettlement();
        }
        buildingArray[numberOfBuildings] = b;
        numberOfBuildings = numberOfBuildings + 1;
    }

    public boolean build(int allottedMoney, Population population,
        int cost, int workersRequired) {
        if (cost < allottedMoney
            && workersRequired <= population.getCivilians()) {
            Building newBuilding = new Building(cost, workersRequired);
            addBuilding(newBuilding);
            return true;
        }
        return false;
    }

    public void expandSettlement() {
        if (buildingArray.length == 0) {
            buildingArray = new Building[1];
        } else {
            int origLength = buildingArray.length;
            Building[] newBuildingArray = new Building[2 * origLength];
            for (int i = 0; i < origLength; i++) {
                newBuildingArray[i] = buildingArray[i];
            }
            buildingArray = newBuildingArray;
        }
    }

    public String getName() {
        return name;
    }

}