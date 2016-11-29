package view;

import controller.GameController;
import javafx.scene.layout.GridPane;
import model.Civilization;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

import javafx.scene.control.Label;


public class ResourcesMenu {
    private GridPane gridPane;
    private Label lblStart, lblStartValue;
    private Label lblResources, lblResourcesValue;
    private Label lblSettlements, lblSettlementsValue;
    private Label lblMoney, lblMoneyValue;
    private Label lblFood, lblFoodValue;
    private Label lblHappiness, lblHappinessValue;
    private Civilization civ;

    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        civ = GameController.getCivilization();
        // vbox = new VBox(5);
        // hbox1 = new HBox(16);
        // hbox2 = new HBox(16);
        this.update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        // vbox.getChildren().clear();
        // hbox1.getChildren().clear();
        // hbox2.getChildren().clear();
        gridPane.getChildren().clear();
        lblStart = new Label("STRAT LEVEL:");
        String lblStartResult = String.format("%04d     \n", civ.
            getStrategy().getStrategyLevel());
        lblStartValue = new Label(lblStartResult);

        lblResources = new Label("RESOURCES:");
        String lblResourcesResult = String.format("%04d     \n", civ.
            getResources());
        lblResourcesValue = new Label(lblResourcesResult);

        lblSettlements = new Label("SETTLEMENTS:");
        String lblSettlementsResult = String.format("%04d     \n", civ.
            getNumSettlements());
        lblSettlementsValue = new Label(lblSettlementsResult);

        lblMoney = new Label("MONEY:");
        String lblMoneyResult = String.format("%04d     \n", civ.
            getTreasury().getCoins());
        lblMoneyValue = new Label(lblMoneyResult);

        lblFood = new Label("FOODS:");
        String lblFoodResult = String.format("%04d     \n", civ.getFood());
        lblFoodValue = new Label(lblFoodResult);

        lblHappiness = new Label("HAPPINESS LVL:");
        String lblHappinessResult = String.format("%04d     \n", civ.
            getHappiness());
        lblHappinessValue = new Label(lblHappinessResult);

        gridPane.add(lblStart, 0, 0, 1, 1);
        gridPane.add(lblStartValue, 1, 0, 1, 1);
        gridPane.add(lblMoney, 2, 0, 1, 1);
        gridPane.add(lblMoneyValue, 3, 0, 1, 1);
        gridPane.add(lblHappiness, 4, 0, 1, 1);
        gridPane.add(lblHappinessValue, 5, 0, 1, 1);
        gridPane.add(lblResources, 0, 1, 1, 1);
        gridPane.add(lblResourcesValue, 1, 1, 1, 1);
        gridPane.add(lblFood, 2, 1, 1, 1);
        gridPane.add(lblFoodValue, 3, 1, 1, 1);
        gridPane.add(lblSettlements, 4, 1, 1, 1);
        gridPane.add(lblSettlementsValue, 5, 1, 1, 1);

        gridPane.setHalignment(lblStart, HPos.RIGHT);
        gridPane.setValignment(lblStart, VPos.CENTER);
        gridPane.setHalignment(lblResources, HPos.RIGHT);
        gridPane.setValignment(lblResources, VPos.CENTER);
        gridPane.setHalignment(lblSettlements, HPos.RIGHT);
        gridPane.setValignment(lblSettlements, VPos.CENTER);
        gridPane.setHalignment(lblMoney, HPos.RIGHT);
        gridPane.setValignment(lblMoney, VPos.CENTER);
        gridPane.setHalignment(lblFood, HPos.RIGHT);
        gridPane.setValignment(lblFood, VPos.CENTER);
        gridPane.setHalignment(lblHappiness, HPos.RIGHT);
        gridPane.setValignment(lblHappiness, VPos.CENTER);

    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a GridPane representation of the resource bar
    */
    public GridPane getRootNode() {
        this.update();
        return gridPane;
    }
}