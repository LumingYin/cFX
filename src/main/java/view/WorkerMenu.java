package view;

import controller.GameController;
import model.Convertable;
import javafx.scene.control.Button;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    /**
     * There should be a convert and move button
     * as well as the functions associated with those
     * buttons
     */
    public WorkerMenu() {
        Button move = new Button("Move");
        Button convert = new Button("Convert");

        move.setOnAction(event -> {
                GameController.moving();
                GridFX.update();
            });

        convert.setOnAction(event -> {
                Convertable worker = (Convertable) GameController.
                    getLastClicked().getTile().getOccupant();
                if (worker.canConvert(GameController.
                    getLastClicked().getTile().getType())) {
                    GameController.getLastClicked().
                getTile().setOccupant(worker.convert());
                    GameScreen.getResources().update();
                    GridFX.update();
                    GameController.setLastClicked(GameController.
                        getLastClicked());
                } else {
                    showAlert("Cannot Convert",
                        "The selected tile can not be converted.");
                }
            });

        addMenuItem(move);
        addMenuItem(convert);


    }


}
