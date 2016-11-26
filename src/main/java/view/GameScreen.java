package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import view.GridFX;
import model.Map;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    GridFX grid;
    Map map;
    static AbstractMenu statusMenu;
    static ResourcesMenu resourcesMenu;
    static VBox vbox;

    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        grid = GridFX.getInstance();
        map = GridFX.getMap();
        resourcesMenu = new ResourcesMenu();
        statusMenu = new StatusMenu();
        this.setCenter(grid);
        vbox = new VBox();
        // vbox.setPadding(new Insets(0, 50, 0, 0));
        vbox.getChildren().addAll(statusMenu.getRootNode());
        this.setLeft(vbox);
        this.setTop(resourcesMenu.getRootNode());
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        resourcesMenu.update();
      //TODO
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
            case NEUTRAL: 
            statusMenu = new StatusMenu();
            break;
            case MILITARY: 
            statusMenu = new MilitaryMenu();
            break;
            case WORKER: 
            statusMenu = new WorkerMenu();
            break;
            case BUILDING: 
            statusMenu = new BuildingMenu();
            break;
            case RECRUITING: 
            statusMenu = new RecruitMenu();
            break;
        }
        vbox.getChildren().clear();
        vbox.getChildren().addAll(statusMenu.getRootNode());
    }
}
