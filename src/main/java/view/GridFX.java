package view;

import javafx.scene.layout.GridPane;
import model.Map;
import model.TerrainTile;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        try {
            String contents = new String(Files.
                readAllBytes(Paths.get(".ds.tmp")));
            mapSize = Integer.parseInt(contents);
            // File ff = new File(".ds.tmp");
            // boolean result = Files.deleteIfExists(ff.toPath());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        switch (mapSize) {
        case 0:
            h = 10;
            v = 10;
            break;
        case 1:
            h = 15;
            v = 15;
            break;
        case 2:
            h = 20;
            v = 20;
            break;
        case 3:
            h = 25;
            v = 25;
            break;
        case 4:
            h = 30;
            v = 30;
            break;
        default:
            h = 10;
            v = 10;
            break;
        }
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
