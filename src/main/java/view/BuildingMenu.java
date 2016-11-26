package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import javafx.scene.control.Button;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {

    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        super();
        Button invest = new Button("Invest");
    	Button demolish = new Button("Demolish");

        invest.setOnAction(event -> {
            if (GameController.getCivilization().getTreasury().getCoins() >= 25) {
                Building bdl = (Building) (GameController.getLastClicked().getTile().getOccupant());
                bdl.invest();
                GameController.getCivilization().getTreasury().spend(25);
                GameScreen.getResources().update();
            } else {
                showAlert("Insufficient Balance", "As a result, you are unable to invest in this Building.");
            }
        GridFX.update();
        GameScreen.switchMenu(GameController.GameState.BUILDING);
        GameController.setLastClicked(GameController.getLastClicked());
        });

        demolish.setOnAction(event -> {
        if (GameController.getCivilization().getNumSettlements() <= 1) {
            showAlert("Cannot Demolish Building", "If this building is demolished, you will have no building left.");
        } else if (GameController.getLastClicked().getTile().getOccupant().getOwner() == GameController.getCivilization()) {
            ((Building) GameController.getLastClicked().getTile().getOccupant()).demolish();
            GameController.getLastClicked().getTile().setOccupant(null);
            GameController.getCivilization().decrementNumSettlements();
            GameScreen.getResources().update();
        }
        GridFX.update();
        GameController.setLastClicked(GameController.getLastClicked());
        });

        addMenuItem(invest);
    	addMenuItem(demolish);
        // getRootNode();
        // endTurn();
        GameController.updateResourcesBar();
        //TODO
    }
}
