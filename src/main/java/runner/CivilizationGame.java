package runner;

import controller.GameController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import view.StartScreen;
import view.CivEnum;
import view.GridFX;
import view.GameScreen;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.AmericanEmpire;
import model.BluePrintEmpire;
import model.FutureLandEmpire;
import model.Bandit;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.Optional;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private Stage stage;
    private Scene scene1, scene2;
    private StartScreen startScreen;
    private GameScreen gameScreen;
    private ListView<CivEnum> civList;
    private Button startBtn;
    private Bandit bandit;
    private int mapSize;
    // private File temp;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setMinHeight(720.0);
        stage.setMinWidth(1280.0);
        stage.setMaxHeight(720.0);
        stage.setMaxWidth(1280.0);
        // stage.initStyle(StageStyle.TRANSPARENT);
        Scene x = startGame();
        stage.setScene(x);
        x.getStylesheets().add(CivilizationGame.class.
            getResource("style.css").toExternalForm());
        stage.show();
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is responsible for setting the scene to the corresponding
     * layout.
     * and returning the scene.
     *
     * @return Scene
     */

    public Scene startGame() {
        startScreen = new StartScreen();
        civList = startScreen.getCivList();
        bandit = new Bandit();
        startBtn = startScreen.getStartButton();
        startBtn.setTranslateY(-50);
        VBox civListBox = new VBox();
        civListBox.getChildren().addAll(civList);
        civListBox.setAlignment(Pos.BOTTOM_CENTER);
        civListBox.setTranslateY(-230);
        Text textBox = new Text();
        textBox.setText("Select your civilization");
        textBox.setFill(Color.WHITE);
        textBox.setId("select-text");
        textBox.setTranslateY(-470);

        TextInputDialog popup = new TextInputDialog();
        startBtn.setOnAction(event -> {
                popup.setTitle("A new Settlement");
                popup.setHeaderText("You have built a Settlement!");
                popup.setContentText("Enter the Name of your first town:");
                Optional<String> townName = popup.showAndWait();
                if (townName.isPresent() && !townName.get().isEmpty()) {
                    CivEnum selCiv = startScreen.getCivList().
                        getSelectionModel().getSelectedItem();
                    switch (selCiv) {
                    case ANCIENT_EGYPT:
                        GameController.setCivilization(new Egypt());
                        break;
                    case QIN_DYNASTY:
                        GameController.setCivilization(new QinDynasty());
                        break;
                    case ROMAN_EMPIRE:
                        GameController.setCivilization(new RomanEmpire());
                        break;
                    case AMERICAN_EMPIRE:
                        GameController.setCivilization(new AmericanEmpire());
                        break;
                    case FUTURELAND_EMPIRE:
                        GameController.setCivilization(new FutureLandEmpire());
                        break;
                    case BLUEPRINT_EMPIRE:
                        GameController.setCivilization(new BluePrintEmpire());
                        break;
                    default:
                        break;
                    }
                    switch (mapSize) {
                    case 0:
                        GameController.setRowColumn(10, 10);
                        break;
                    case 1:
                        GameController.setRowColumn(15, 15);
                        break;
                    case 2:
                        GameController.setRowColumn(20, 20);
                        break;
                    case 3:
                        GameController.setRowColumn(25, 25);
                        break;
                    case 4:
                        GameController.setRowColumn(30, 30);
                        break;
                    default:
                        GameController.setRowColumn(10, 10);
                        break;
                    }
                    GridFX.update();
                    switch (mapSize) {
                    case 0:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 9);
                        GridFX.getMap().addEnemies(bandit, 1);
                        break;
                    case 1:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 14);
                        GridFX.getMap().addEnemies(bandit, 2);
                        break;
                    case 2:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 19);
                        GridFX.getMap().addEnemies(bandit, 3);
                        break;
                    case 3:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 24);
                        GridFX.getMap().addEnemies(bandit, 4);
                        break;
                    case 4:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 29);
                        GridFX.getMap().addEnemies(bandit, 5);
                        break;
                    default:
                        GridFX.getMap().putSettlement(townName.get(),
                            GameController.getCivilization(), 0, 9);
                        GridFX.getMap().addEnemies(bandit, 1);
                        break;
                    }
                    GridFX.update();
                    gameScreen = new GameScreen();
                    scene2 = new Scene(gameScreen);
                    scene2.getStylesheets().add(CivilizationGame.class.
                        getResource("style2.css").toExternalForm());
                    stage.setScene(scene2);
                    stage.setMinHeight(810.0);
                    stage.setMaxHeight(810.0);
                    stage.setMinWidth(880.0);
                    stage.setMaxWidth(880.0);
                }
            });

        Text textBox2 = new Text();
        textBox2.setText("Select your map's size");
        textBox2.setFill(Color.WHITE);
        textBox2.setId("select-text");
        textBox2.setTranslateY(-180);

        final ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.
            observableArrayList(
            "10 × 10 [Beginners' Journey]", "15 × 15 [Kinda Intermediate]",
            "20 × 20 [Pretty Difficult]", "25 × 25 [Very Difficult]",
            "30 × 30 [Quite Advanced]")
        );
        cb.setValue("10 × 10 [Beginners' Journey]");
        cb.setTranslateY(-145);
        cb.setId("map-size");

        cb.getSelectionModel().selectedIndexProperty().addListener(new
            ChangeListener<Number>() {
                public void changed(ObservableValue ov,
                    Number value, Number newValue) {
                    mapSize = (int) newValue;
            }
        });

        startScreen.getChildren().addAll(textBox, startBtn,
            civListBox, textBox2, cb);
        startScreen.setAlignment(Pos.BOTTOM_CENTER);
        scene1 = new Scene(startScreen);
        return scene1;
    }
}
