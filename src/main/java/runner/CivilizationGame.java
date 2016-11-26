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
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import view.StartScreen;
import view.CivEnum;
import view.GridFX;
import view.GameScreen;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;

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
        stage.setScene(startGame());
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
        startBtn.setTranslateY(-70);

        VBox civListBox = new VBox();
        civListBox.getChildren().addAll(civList);
        civListBox.setAlignment(Pos.BOTTOM_CENTER);
        civListBox.setTranslateY(-105);

        Text textBox = new Text();
        textBox.setText("Select a civilization to begin:");
        textBox.setFill(Color.RED);
        textBox.setFont(Font.font(null, 14));
        textBox.setTranslateY(-220);

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
                    default:
                        break;
                    }
                    GridFX.getMap().putSettlement(townName.get(),
                        GameController.getCivilization(), 0, 9);
                    GridFX.update();
                    GridFX.getMap().addEnemies(bandit, 1);
                    gameScreen = new GameScreen();
                    scene2 = new Scene(gameScreen);
                    stage.setScene(scene2);
                    stage.setMinHeight(745.0);
                    stage.setMinWidth(850.0);
                    stage.setMaxHeight(745.0);
                    stage.setMaxWidth(850.0);
                }
            });

        startScreen.getChildren().addAll(textBox, startBtn, civListBox);
        startScreen.setAlignment(Pos.BOTTOM_CENTER);
        scene1 = new Scene(startScreen);
        return scene1;
    }
}
