package view;

import javafx.scene.layout.GridPane;
import model.Map;
import model.TerrainTile;
import controller.GameController;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class GridFX extends GridPane {
    private static Map map;
    private static GridFX instance = new GridFX();
    private int mapSize = 0;
    private int h, v;

    private GridFX() {
        instance = this;    //pseudo singleton so that update can be called
        h = GameController.getRow();
        v = GameController.getCol();
        map = new Map(h, v);
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < v; c++) {
                this.add(new TerrainTileFX(map.getTile(r, c)), c, r);
            }
        }
    }

    public static void update() {
        instance.getChildren().forEach(
                n -> ((TerrainTileFX) n).updateTileView());
    }

    public static boolean adjacent(TerrainTileFX current, TerrainTileFX other) {
        return adjacent(current.getTile(), other.getTile());
    }

    public static boolean adjacent(TerrainTile selected, TerrainTile other) {
        int srow = selected.getRow();
        int scol = selected.getCol();
        int orow = other.getRow();
        int ocol = other.getCol();
        return (Math.abs(orow - srow) <= 1) && (Math.abs(ocol - scol) <= 1);
    }

    public static Map getMap() {
        return map;
    }

    public static GridFX getInstance() {
        return instance;
    }
}
