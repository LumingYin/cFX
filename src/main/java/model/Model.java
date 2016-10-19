package model;

public class Model {

    private static Civilization playerCivilization;
    private static Map map;
    private static boolean playing;
    private static TerrainTile selected;
    private static int selectedRow;
    private static int selectedCol;

    static {
        map = new Map(10, 10);
        playing = true;
    }

    private Model() {
    }

    public static boolean getPlaying() {
        return playing;
    }

    public static void setPlaying(boolean playing) {
        Model.playing = false;
    }

    public static boolean chooseCivilization(int civChoice) {
        switch (civChoice) {
        case 1:
            playerCivilization = new Egypt();
            return true;
        case 2:
            playerCivilization = new QinDynasty();
            return true;
        case 3:
            playerCivilization = new RomanEmpire();
            return true;
        default:
            return false;
        }
    }

    public static String explore() {
        return playerCivilization.explore();
    }

    public static void putSettlement(String name, Civilization civ,
        int r, int c) {
        map.getTile(r, c).setOccupant(civ.getSettlement(name));
        playerCivilization.incrementNumSettlements();
    }

    public static void addEnemies(Civilization civ) {
        map.getTile(4, 7).setOccupant(civ.getMeleeUnit());
        map.getTile(5, 7).setOccupant(civ.getMeleeUnit());
        map.getTile(4, 6).setOccupant(civ.getMeleeUnit());
        map.getTile(5, 8).setOccupant(civ.getSettlement("Bandit Hideout"));
    }

    public static boolean adjacentTo(int r, int c, String what) {
        if (c % 2 == 0) {
            if (r < map.getRows() - 1
                && adjBool(r + 1, c, what)) {
                return true;
            } else {
                for (int r2 = r - 1; r2 < r + 1 && r2 > -1
                    && r2 < map.getRows();
                    r2++) {
                    for (int c2 = (c == 0 ? 0 : c - 1); c2 < c + 2
                        && c2 < map.getColumns(); c2++) {
                        if (adjBool(r2, c2, what)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (r > 0 && adjBool(r - 1, c, what)) {
                return true;
            } else {
                for (int r2 = r; r2 < r + 2 && r2 < map.getRows();
                    r2++) {
                    for (int c2 = (c == 0 ? 0 : c - 1); c2 < c + 2
                        && c2 < map.getColumns(); c2++) {
                        if (adjBool(r2, c2, what)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean adjBool(int r, int c, String what) {
        switch (what) {
        case "SETTLEMENT":
            return map.getTile(r, c).getOccupant() instanceof Settlement;
        case "SELECTED":
            return map.getTile(r, c) == selected;
        default:
            return false;
        }
    }

    public static void addFirstSettlement(String name) {
        putSettlement(name, playerCivilization, 5 , 5);
        addEnemies(new Civilization("Bandits"));
    }

    public static String gameScreen() {
        Civilization civ = playerCivilization;
        String gameScreen = map.toString()
            + "Materials:\n"
            + "Gold: " + civ.getTreasury().getCoins() + "\t"
            + "Food: " + civ.getFood() + "\t"
            + "Resources: " + civ.getResources() + "\t"
            + "Happiness: " + civ.getHappiness() + "\n"
            + "Stats:\n"
            + "Philosophy Points: " + civ.getTechnology().getUnderstanding()
            + "\t"
            + "Technology Points: " + civ.getTechnology().getBuildExperience()
            + "\t"
            + "Strategy Points: " + civ.getStrategy().getStrategyLevel()
            + "\t"
            + "Settlements Remaining: " + civ.getNumSettlements() + "\n";
        return gameScreen;
    }

    public static void selectTile(int r, int c) {
        selected = map.getTile(r, c);
        selectedRow = r;
        selectedCol = c;
    }

    public static String selectedOptions() {
        MapObject occupant = selected.getOccupant();
        if (occupant != null) {
            if (occupant.getOwner() != playerCivilization) {
                return "That tile contains the enemy " + occupant.toString();
            } else if (occupant instanceof Building) {
                return "BUILDING";
            } else if (occupant instanceof MilitaryUnit) {
                return "MILITARY_UNIT";
            } else {
                return "WORKER_UNIT";
            }
        } else if (adjacentTo(selectedRow, selectedCol, "SETTLEMENT")) {
            return "RECRUIT_SPACE";
        } else {
            return "That tile is empty, and is a " + selected.toString();
        }
    }

    public static String selectedString() {
        return selected.toString();
    }


    public static String selectedMapObjectString() {
        return selected != null
            ? selected.getOccupant().toString()
            : "null";
    }

    public static boolean moveSelected(int r, int c) {
        if (adjacentTo(r, c, "SELECTED")
            && ((Unit) selected.getOccupant()).canMove(
            selected.getType().getCost())
            && map.isEmpty(r, c)) {
            map.getTile(r, c).setOccupant(selected.getOccupant());
            ((Unit) selected.getOccupant()).deductEndurance(
                map.getTile(r, c).getType().getCost());
            selected.setOccupant(null);
            return true;
        } else {
            return false;
        }
    }

    public static boolean recruitSelected(int selection, String name) {
        Unit newUnit = null;
        switch (selection) {
        case 1:
            newUnit = playerCivilization.getMeleeUnit();
            break;
        case 2:
            newUnit = playerCivilization.getRangedUnit();
            break;
        case 3:
            newUnit = playerCivilization.getHybridUnit();
            break;
        case 4:
            newUnit = playerCivilization.getSiegeUnit();
            break;
        case 5:
            newUnit = playerCivilization.getSettlerUnit(name);
            break;
        case 6:
            newUnit = playerCivilization.getFarmerUnit();
            break;
        case 7:
            newUnit = playerCivilization.getCoalMinerUnit();
            break;
        case 8:
            newUnit = playerCivilization.getAnglerUnit();
            break;
        case 9:
            newUnit = playerCivilization.getMasterBuilderUnit();
            break;
        default:
            break;
        }
        if (newUnit != null && newUnit.isAffordable()) {
            newUnit.applyInitialCosts();
            selected.setOccupant(newUnit);
            return true;
        }
        return false;
    }

    public static boolean attackSelected(int r, int c) {
        if (!map.isEmpty(r, c)) {
            TerrainTile tile = map.getTile(r, c);
            MapObject mapobj = tile.getOccupant();
            if (mapobj != null
                && mapobj.getOwner() != playerCivilization
                && selected.getOccupant() instanceof MilitaryUnit
                && ((MilitaryUnit) (selected.getOccupant())).getCanAttack()) {
                ((MilitaryUnit) (selected.getOccupant())).attack(mapobj);
                if (mapobj.isDestroyed()) {
                    tile.setOccupant(null);
                }
                if (((MilitaryUnit) (selected.getOccupant())).isDestroyed()) {
                    selected.setOccupant(null);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean convertSelected() {
        Convertable worker = (Convertable) selected.getOccupant();
        if (worker.canConvert(selected.getType())) {
            selected.setOccupant(worker.convert());
            return true;
        } else {
            return false;
        }
    }

    public static void tick() {
        for (int r = 0; r < map.getRows(); r++) {
            for (int c = 0; c < map.getColumns(); c++) {
                if (!map.getTile(r, c).isEmpty()) {
                    map.getTile(r, c).getOccupant().tick();
                }
            }
        }
    }

    public static boolean checkWin() {
        return playerCivilization.getTechnology().hasTechnologyWin()
            || playerCivilization.getStrategy().conqueredTheWorld();
    }

    public static boolean investSelected() {
        if (playerCivilization.getTreasury().getCoins() >= 20) {
            ((Building) selected.getOccupant()).invest();
            playerCivilization.getTreasury().spend(20);
            return true;
        } else {
            return false;
        }
    }

    public static boolean demolishSelected() {
        if (selected.getOccupant() instanceof Settlement
            && playerCivilization.getNumSettlements() <= 1) {
            return false;
        } else {
            ((Building) selected.getOccupant()).demolish();
            selected.setOccupant(null);
            return true;
        }
    }
}
