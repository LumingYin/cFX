package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Bandit;
import model.Civilization;
import model.Map;
import model.MapObject;
import model.MilitaryUnit;
import model.Settlement;
import model.TerrainTile;
import model.Unit;
import view.GameScreen;
import view.GridFX;
import view.TerrainTileFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.io.File;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class GameController {
    private static TerrainTileFX lastClicked;
    private static Civilization playerCivilization;
    private static Civilization enemyCiv = new Bandit();
    private static GameState state = GameState.NEUTRAL;
    private static Random rand = new Random();
    private static int h, v;

    public static void setRowColumn(int row, int col) {
        h = row;
        v = col;
    }

    public static int getRow() {
        return h;
    }

    public static int getCol() {
        return v;
    }

    public enum GameState {
        NEUTRAL, MILITARY, WORKER, BUILDING, RECRUITING, ATTACKING, MOVING;
    }

    private static void playSFX(String fileName) {
        try {
            String s = "src/main/java/view/sfx/" + fileName + ".wav";
            File file = new File("src/main/java/view/sfx/" + fileName + ".wav");
            Media sound = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } catch (Throwable e) {
            System.out.print("");
        }
    }


    /**
     * Updates the state machine to control the game
     *
     * Transitions the controller states based on clicked Tiles
     * Updates menus based on the new state
     * Calls the updateTileView method to handle highlighting and coloring
     * @param last
     */
    public static void setLastClicked(TerrainTileFX last) {
        TerrainTileFX previousLastClicked = lastClicked;
        if (last == null) { //abort everything and reset, end turn was pressed
            lastClicked = null;
            if (previousLastClicked != null) {
                previousLastClicked.updateTileView();
            }
            state = GameState.NEUTRAL;
            GameScreen.switchMenu(state);
            return;
        }

        if (state == GameState.ATTACKING) {
            attack(last);
        } else if (state == GameState.MOVING) {
            if (move(last)) {
                lastClicked = last;
                playSFX("MilitaryMenu_move");
                GameController.updateResourcesBar();
                GridFX.update();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Unable to move");
                alert.setHeaderText("Unable to move the tile");
                alert.setContentText("You can only move to a"
                    + " nearby tile that is not the origonal tile when you"
                    + " haven't used up your moving quote in this turn.");
                alert.showAndWait();
            }
        }
        //update lastClicked
        lastClicked = last;

        //reset older tiles, if needed (updateTileView should handle all colors)
        if (previousLastClicked != null) {
            previousLastClicked.updateTileView();
        }

        //process the state transitions
        TerrainTile tile = last.getTile();
        if (tile.isEmpty()) {                           //empty
            if (nearSettlement(last)) {
                state = GameState.RECRUITING;
            } else {
                state = GameState.NEUTRAL;
            }
        } else if (tile.getOccupant().isFriendly()) {  //friendly occupant
            MapObject occupant = tile.getOccupant();
            if (occupant.isMilitaryUnit()) {
                state = GameState.MILITARY;
            } else if (occupant.isBuilding()) {
                state = GameState.BUILDING;
            } else {
                //assumes that anything that isn't a building or military unit
                //is a worker
                state  = GameState.WORKER;
            }
        } else {
            state = GameState.NEUTRAL;
        }

        //updates views, switches context menu depending on state
        lastClicked.updateTileView();
        GameScreen.switchMenu(state);
    }

    /**
     * Sets game state to ATTACKING (used as a transition state)
     */
    public static void attacking() {
        state = GameState.ATTACKING;
    }
    /**
     * Sets game state to MOVING (used as a transition state)
     */
    public static void moving() {
        state = GameState.MOVING;
    }

    /**
     * Attempts to move the previously clicked tile to the
     * most recently clicked tile.
     * @param newTile the target tile to move to
     * @return true or false whether the move was successful
     */
    private static boolean move(TerrainTileFX newTile) {
        boolean result = move(lastClicked.getTile(), newTile.getTile());
        newTile.updateTileView();
        lastClicked.updateTileView();
        return result;
    }

    /**
     * Internal helper method to handle moving mechanics
     * Uses the TerrainTile form so that the AI can use it too
     */
    private static boolean move(TerrainTile start, TerrainTile end) {
        if (!(end.isEmpty() && GridFX.adjacent(end, start)
                && ((Unit) start.getOccupant()).canMove(
                        end.getType().getCost()))) {
            return false;
        }
        end.setOccupant(start.getOccupant());
        start.setOccupant(null);
        int endCost = end.getType().getCost();
        ((Unit) end.getOccupant()).deductEndurance(endCost);
        state = GameState.NEUTRAL;
        return true;
    }

    /**
     * Attempts to attack the enemyTile with the previously selected tile
     */
    private static void attack(TerrainTileFX enemyTile) {
        TerrainTile enemy = enemyTile.getTile();
        TerrainTile attacker = lastClicked.getTile();
        attackTile(attacker, enemy);
        lastClicked.updateTileView();
        enemyTile.updateTileView();
        state = GameState.NEUTRAL;
    }

    /**
     * Internal helper to handle attacking mechanics
     * Uses the TerrainTile form so that the AI can use it too
     * @param attacker
     * @param enemy
     */
    private static void attackTile(TerrainTile attacker, TerrainTile enemy) {
        if (enemy.isEmpty()
            || enemy.getOccupant().getOwner()
                == attacker.getOccupant().getOwner()
            || !((MilitaryUnit) attacker.getOccupant()).getCanAttack()
            || !GridFX.adjacent(attacker, enemy)) {
            state = GameState.NEUTRAL;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Attack failed");
            alert.setHeaderText("Unable to attack");
            String s = "You can only attack a nearby enemy's unit.";
            if (!((MilitaryUnit) attacker.getOccupant()).getCanAttack()) {
                s = s + "\n\nYour unit is not eligible for attack. After ending"
                    + " this turn and starting a new turn, your unit may be"
                    + " eligible for attack.";
            }
            alert.setContentText(s);
            alert.showAndWait();
            return;
        }
        if (attacker.getOccupant().getOwner() == playerCivilization) {
            playSFX("MilitaryMenu_attack");
            GameController.updateResourcesBar();
            GridFX.update();
        }

        ((MilitaryUnit) attacker.getOccupant()).attack(enemy.getOccupant());

        if (((MilitaryUnit) attacker.getOccupant()).isDestroyed()) {
            attacker.setOccupant(null);
        }

        if ((enemy.getOccupant()).isDestroyed()) {
            enemy.setOccupant(null);
        }
    }

    /**
     * Sets the player's Civilization
     */
    public static void setCivilization(Civilization civ) {
        playerCivilization = civ;
    }
    /**
     * returns the player's Civilization
     * @return Civilization
     */
    public static Civilization getCivilization() {
        return playerCivilization;
    }

    /**
     * Sets the opposing civ
     * @param bandits Bandit civ to consider the enemy
     */
    public static void setBandits(Bandit bandits) {
        enemyCiv = bandits;
    }

    /**
     * Returns whether the current tile is a settlement, used when checking
     * if the recruit menu should be shown
     */
    private static boolean nearSettlement(TerrainTileFX tile) {
        int row = tile.getTile().getRow();
        int col = tile.getTile().getCol();
        Map map = GridFX.getMap();
        for (int r = row - 1; r < row + 2; r++) {
            for (int c = col - 1; c < col + 2; c++) {
                if (c >= 0 && c < h && r >= 0 && r < v) {
                    MapObject occupant = map.getTile(r, c).getOccupant();
                    if (occupant != null
                            && occupant instanceof Settlement
                            && occupant.isFriendly()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * returns the last clicked terrtainTileFX
     * @return TerrainTileFX
     */
    public static TerrainTileFX getLastClicked() {
        return lastClicked;
    }
    /**
     * called when turn ends, collects all resources upon ending a turn
     * from all the map objects on the map and updates the civlization's
     * resources
     */
    public static void tick() {
        Map map = GridFX.getMap();
        for (int r = 0; r < map.getRows(); r++) {
            for (int c = 0; c < map.getColumns(); c++) {
                if (!map.getTile(r, c).isEmpty()) {
                    map.getTile(r, c).getOccupant().tick();
                }
            }
        }
        updateResourcesBar();
    }


    /**
     * Updates the resource bar
     */
    public static void updateResourcesBar() {
        GameScreen.getResources().update();
    }

    /**
     * Please forgive me for what I have done...
     * - Marc
     * Uses BFS to find the nearest non-bandit unit
     * Moves closer and attempts to attack
     * Bandits are dumb and will swarm you
     */
    public static void ai() {
        List<TerrainTile> bandits = new ArrayList<>();
        TerrainTile banditHideout = null;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < v; c++) {
                TerrainTile tile = GridFX.getMap().getTile(r, c);
                if (!tile.isEmpty()
                        && !tile.getOccupant().isFriendly()) {
                    if (tile.getOccupant().isMilitaryUnit()) {
                        bandits.add(GridFX.getMap().getTile(r, c));
                    } else if (tile.getOccupant().isBuilding()) {
                        banditHideout = tile;
                    }
                }
            }
        }

        if (banditHideout != null) {
            if (rand.nextInt(100) < h) {
                TerrainTile spawn = getRandomAdjacentTile(
                        banditHideout.getRow(), banditHideout.getCol());
                if (spawn.isEmpty()) {
                    spawn.setOccupant(enemyCiv.getMeleeUnit());
                }
            }
        }

        for (TerrainTile tile : bandits) {
            int chance = rand.nextInt(100);
            int r = 0;
            int c = 0;
            if (chance < 25) {
                TerrainTile nearest = GridFX.getMap().getNearestNonBandit(
                        tile.getRow(), tile.getCol());
                if (nearest != null) {
                    if (GridFX.adjacent(nearest, tile)) {
                        boolean wasSettlement =
                                nearest.getOccupant() instanceof Settlement;
                        attackTile(tile, nearest);
                        //settlement destroyed
                        if (nearest.isEmpty() && wasSettlement) {
                            playerCivilization.decrementNumSettlements();
                        }
                    } else {
                        c = Map.getDirectedCol(tile, nearest);
                        r = Map.getDirectedRow(tile, nearest);
                    }
                }
            } else if (chance < 50) {
                c = rand.nextInt(3) - 1;
                r = rand.nextInt(3) - 1;
            }
            int newRow = tile.getRow() + r;
            int newCol = tile.getCol() + c;
            if (newRow >= 0 && newRow < h && newCol >= 0 && newCol < v) {
                //This handles an edge case where a unit can be killed in a
                //counter attack, and then the ai attempts to move the same unit
                //Very much an edge case
                if (tile.getOccupant() != null) {
                    move(tile, GridFX.getMap().getTile(newRow, newCol));
                }
            }
        }
    }

    /**
     * Returns a random adjacent tile
     */
    private static TerrainTile getRandomAdjacentTile(int row, int col) {
        int r = row + rand.nextInt(3) - 1;
        int c = col + rand.nextInt(3) - 1;
        while (!(r >= 0 && r < h && c > 0 && c < v)) {
            r = row + rand.nextInt(3) - 1;
            c = col + rand.nextInt(3) - 1;
        }
        return GridFX.getMap().getTile(r, c);

    }
}


