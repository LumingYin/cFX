package view;

import controller.GameController;
import model.Building;
import javafx.scene.control.Button;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button invest;
    private Button demolish;
    /**
     * there should be an invest and demolish button for this menu
     * as well as functions associated with the buttons
     */
    public BuildingMenu() {
        super();
        invest = new Button("Invest");
        demolish = new Button("Demolish");

        invest.setOnAction(event -> {
                if (GameController.getCivilization().getTreasury().
                    getCoins() >= 25) {
                    Building bdl = (Building) (GameController.
                        getLastClicked().getTile().getOccupant());
                    bdl.invest();
                    GameController.getCivilization().getTreasury().spend(25);
                    GameScreen.getResources().update();
                    playSFX("BuildingMenu_invest");
                } else {
                    showAlert("Insufficient Balance",
                        "It is not possible to invest in this Building.");
                }
                GridFX.update();
                GameScreen.switchMenu(GameController.GameState.BUILDING);
                GameController.setLastClicked(GameController.getLastClicked());
            });

        demolish.setOnAction(event -> {
                if (GameController.getCivilization().getNumSettlements() <= 1) {
                    showAlert("Cannot Demolish Building",
                        "If this building is demolished, "
                        + "you will have no building left.");
                } else if (GameController.getLastClicked().getTile().
                    getOccupant().getOwner() == GameController.
                        getCivilization()) {
                    ((Building) GameController.getLastClicked().
                        getTile().getOccupant()).demolish();
                    GameController.getLastClicked().getTile().setOccupant(null);
                    GameController.getCivilization().decrementNumSettlements();
                    GameScreen.getResources().update();
                    playSFX("BuildingMenu_demolish");
                }
                GridFX.update();
                GameController.setLastClicked(GameController.getLastClicked());
            });

        addMenuItem(invest);
        addMenuItem(demolish);
        GameController.updateResourcesBar();
    }
}
