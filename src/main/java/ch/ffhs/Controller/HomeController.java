package ch.ffhs.Controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Controller for home
 */
public class HomeController {

    @FXML
    private VBox vbox_main;
    @FXML
    private Button btnTutorial, btnRestart, btnSolution;
    @FXML
    private VBox vbox_home;
    @FXML
    private ChoiceBox<String> choiceBoxLevel;

    private BoardController boardController;

    // called on initialization
    public void initialize() {
        ChangeListener<String> changeListener = (observableValue, oldValue, newValue) -> createBoard();
        ObservableList<String> options = FXCollections.observableArrayList("Level: 10x10", "Level: 15x15");
        choiceBoxLevel.setItems(options);
        choiceBoxLevel.setValue(options.get(0));
        choiceBoxLevel.getSelectionModel().selectedItemProperty().addListener(changeListener);
        createBoard();
    }

    private void createBoard() {
        int level;
        String boardPath;
        if (choiceBoxLevel.getValue().equals("Level: 10x10")) {
            level = 10;
            boardPath = "/fxml/board_10x10.fxml";
        } else {
            level = 15;
            boardPath = "/fxml/board_15x15.fxml";
        }

        //remove children
        if (vbox_home.getChildren().size() > 0) {
            vbox_home.getChildren().clear();
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(boardPath));
            VBox vbox = loader.load();
            this.vbox_home.getChildren().addAll(vbox.getChildren());
            boardController = loader.getController();
            boardController.startGame(level);
            boardController.loadGame();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickTutorial(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/tutorial.fxml")));
        boardController.saveGame();
    }

    @FXML
    private void clickBack(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/start.fxml")));
        boardController.saveGame();
    }

    @FXML
    private void clickSolution(final ActionEvent event) {
        if (boardController == null) {
            return;
        } else {
            boardController.loadSolution();
        }
    }

    @FXML
    void clickRestart(final ActionEvent event) {
        if (boardController == null) {
            return;
        } else {
            boardController.restart();
        }
    }

    @FXML
    private void clickNextGame() {
        boardController.loadNextGame();
    }
}
