package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;
import javafx.scene.control.Label;


public class ResourcesMenu {
    HBox hbox;
    Label lblStart;
    Label lblResources;
    Label lblSettlements;
    Label lblMoney;
    Label lblFood;
    Label lblHappiness;
    Civilization civ;

    /**
    * creates a resource bar and display the current state of 
    * your civilization's resouces
    */
    public ResourcesMenu() {
        civ = GameController.getCivilization();
        hbox = new HBox(16);
        this.update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        hbox.getChildren().clear();
        lblStart = new Label("Strategy Level: " + civ.getStrategy().getStrategyLevel());
        lblResources = new Label("Resources: " + civ.getResources());
        lblSettlements = new Label("Settlements: " + civ.getNumSettlements());
        lblMoney = new Label("Money: " + civ.getTreasury().getCoins());
        lblFood = new Label("Food: " + civ.getFood());
        lblHappiness = new Label("Happiness: " + civ.getHappiness());
        hbox.getChildren().addAll(lblStart, lblResources, lblSettlements, lblMoney, lblFood, lblHappiness);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        this.update();
        return hbox;
    }
}