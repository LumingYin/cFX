package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import model.Map;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;


/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private GridFX grid;
    private Map map;
    private ScrollPane scrollPane;
    private static AbstractMenu statusMenu;
    private static ResourcesMenu resourcesMenu;
    private static VBox vbox;
    private static HBox hbox;

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
        scrollPane = new ScrollPane();
        scrollPane.setContent(grid);
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

        this.setCenter(scrollPane);
        vbox = new VBox();
        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);

        vbox.setStyle("-fx-padding: 12;"
                      + "-fx-border-insets: 5;"
                      + "-fx-background-color: #000000;"
                      );
        hbox.setStyle("-fx-padding: 12;"
                      + "-fx-border-insets: 5;"
                      + "-fx-background-color: #000000;");
        hbox.getChildren().addAll(resourcesMenu.getRootNode());
        vbox.getChildren().addAll(statusMenu.getRootNode());
        this.setLeft(vbox);
        this.setTop(hbox);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        resourcesMenu.update();
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
        default:
            break;
        }
        vbox.getChildren().clear();
        vbox.getChildren().addAll(statusMenu.getRootNode());
    }
}
