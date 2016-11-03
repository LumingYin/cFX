package controller;
import model.Model;
import view.UI;

public class GameController {

    public static boolean chooseCivilization(int civChoice) {
        return Model.chooseCivilization(civChoice);
    }

    public static void addFirstSettlement(String name) {
        Model.addFirstSettlement(name);
    }

    public static String gameScreen() {
        return Model.gameScreen();
    }

    public static boolean playing() {
        return Model.getPlaying();
    }

    public static void end() {
        Model.setPlaying(false);
    }

    public static void turnOption(int turnOption) {
        switch (turnOption) {
        case 1:
            UI.manage();
            break;
        case 2:
            UI.explore();
            break;
        case 3:
            UI.standings();
            break;
        case 4:
            end();
            break;
        default:
            break;
        }
    }

    public static void selectTile(int r, int c) {
        Model.selectTile(r, c);
    }

    public static String selectedOptions() {
        return Model.selectedOptions();
    }

    public static String selectedString() {
        return Model.selectedString();
    }

    public static String selectedMapObjectString() {
        return Model.selectedMapObjectString();
    }

    public static boolean moveSelected(int r, int c) {
        return Model.moveSelected(r, c);
    }

    public static boolean recruitSelected(int selection, String name) {
        return Model.recruitSelected(selection, name);
    }

    public static String explore() {
        return Model.explore();
    }

    public static boolean attackSelected(int r, int c) {
        return Model.attackSelected(r, c);
    }

    public static boolean convertSelected() {
        return Model.convertSelected();
    }

    public static void tick() {
        Model.tick();
    }

    public static boolean checkWin() {
        return Model.checkWin();
    }

    public static boolean investSelected() {
        return Model.investSelected();
    }

    public static boolean demolishSelected() {
        return Model.demolishSelected();
    }

    public static void standings(int choice) {
        Model.standings(choice);
    }
}
