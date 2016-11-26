package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import javafx.scene.control.Button;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;


/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
	ListView<UnitEnum> unitView;

	enum UnitEnum {
	    MELEE_UNIT {
	        @Override
	        public String toString() {
	            return "Melee Unit";
	        }
	    },
	    RANGED_UNIT {
	        @Override
	        public String toString() {
	            return "Ranged Unit";
	        }
	    },
	    HYBRID_UNIT {
	        @Override
	        public String toString() {
	            return "Hybrid Unit";
	        }
	    },
	    SIEGE_UNIT {
	        @Override
	        public String toString() {
	            return "Siege Unit";
	        }
	    },
	    SETTLER_UNIT {
	        @Override
	        public String toString() {
	            return "Settler Unit";
	        }
	    },
	    FARMERS {
	        @Override
	        public String toString() {
	            return "Farmers";
	        }
	    },
		COAL_MINERS {
	        @Override
	        public String toString() {
	            return "Coal Miners";
	        }
	    },
	    ANGELERS {
	        @Override
	        public String toString() {
	            return "Angelers";
	        }
	    },
	    MASTER_BUILDERS {
	        @Override
	        public String toString() {
	            return "Master Builders";
	        }
	    },

	}
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
    	ObservableList<UnitEnum> everyUnit = FXCollections.observableArrayList(UnitEnum.values());
        unitView = new ListView();
        // unitView.setMaxSize(200, 100);
        unitView.setItems(everyUnit);
        unitView.getSelectionModel().select(0);
        unitView.getFocusModel().focus(0);
        Button select = new Button("Select");
        select.setOnAction(event -> {
            UnitEnum selUni = unitView.getSelectionModel().getSelectedItem();
            Unit newUnit = null;
            switch (selUni) {
                case MELEE_UNIT: 
	                newUnit = GameController.getCivilization().getMeleeUnit();
	                break;
                case RANGED_UNIT: 
	                newUnit = GameController.getCivilization().getRangedUnit();
	                break;
                case HYBRID_UNIT: 
	                newUnit = GameController.getCivilization().getHybridUnit();
	                break;
                case SIEGE_UNIT: 
	                newUnit = GameController.getCivilization().getSiegeUnit();
	                break;
                case SETTLER_UNIT: 
	                newUnit = GameController.getCivilization().getSettlerUnit("Settler Stub");
	                break;
                case FARMERS: 
	                newUnit = GameController.getCivilization().getFarmerUnit();
	                break;
                case COAL_MINERS: 
	                newUnit = GameController.getCivilization().getCoalMinerUnit();
	                break;
                case ANGELERS: 
	                newUnit = GameController.getCivilization().getAnglerUnit();
	                break;
                case MASTER_BUILDERS: 
	                newUnit = GameController.getCivilization().getMasterBuilderUnit();
	                break;
                default:
                	break;
            }
		    if (newUnit != null && newUnit.isAffordable()) {
	            newUnit.applyInitialCosts();
	            GameController.getLastClicked().getTile().setOccupant(newUnit);
	        }
	        GridFX.update();
	        GameController.setLastClicked(GameController.getLastClicked());
		});

        addMenuItem(unitView);
        addMenuItem(select);

    }
}
