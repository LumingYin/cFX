package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        Button attack = new Button("Attack");
    	Button move = new Button("Move");

    	attack.setOnAction(event -> {
            // if (GameController.getLastClicked().getTile().getOccupant().getOwner() == GameController.getCivilization()) {
            //     showAlert("Cannot Attack", "You cannot attack yourself!");
            // } else {
                GameController.attacking();
            // }
            GridFX.update();
    	});

    	move.setOnAction(event -> {
    		GameController.moving();
            GridFX.update();
    	});

        addMenuItem(attack);
    	addMenuItem(move);

    }
}
