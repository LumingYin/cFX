package view;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.image.ImageView;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    private Button startButton;
    private ListView<CivEnum> civList;

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        // Creates the background imageView
        Image im = new Image("File:./src/main/java/view/civ_background.png");
        ImageView imv = new ImageView();
        imv.setImage(im);
        imv.setFitWidth(1280);
        imv.setFitHeight(720);
        imv.setPreserveRatio(true);
        this.getChildren().add(imv);

        startButton = new Button("");
        Image startBtnImage = new Image(getClass().
            getResourceAsStream("startBtn.png"));
        startButton.setGraphic(new ImageView(startBtnImage));

        ObservableList<CivEnum> enumToUIList = FXCollections.
            observableArrayList(CivEnum.values());
        civList = new ListView<>();
        civList.setMaxSize(300, 230);
        civList.setItems(enumToUIList);
        civList.setId("city-list");
        civList.getSelectionModel().select(0);
        civList.getFocusModel().focus(0);
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civList;
    }
}