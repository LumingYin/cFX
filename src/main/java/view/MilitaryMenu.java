package view;

import controller.GameController;
import javafx.scene.control.Button;

/**
 * Created by William on 11/11/2016.
 */

public class MilitaryMenu extends AbstractMenu {
    private Button attack;
    private Button move;
    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        attack = new Button("Attack");
        move = new Button("Move");

        attack.setOnAction(event -> {
                GameController.attacking();
                GameController.updateResourcesBar();
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
