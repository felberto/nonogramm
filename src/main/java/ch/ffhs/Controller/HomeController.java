package ch.ffhs.Controller;

import ch.ffhs.Service.CounterService;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
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
    CounterService counterService = new CounterService();

    private BoardController boardController;
    private ObservableList<String> options;
    @FXML
    private Label timer;

    // called on initialization
    public void initialize() {
        ChangeListener<String> changeListener = (observableValue, oldValue, newValue) -> createBoard(false);
        options = FXCollections.observableArrayList("Level: 10x10", "Level: 15x15");
        choiceBoxLevel.setItems(options);
        createBoard(true);
        choiceBoxLevel.getSelectionModel().selectedItemProperty().addListener(changeListener);
        timer.textProperty().bind(counterService.messageProperty());
    }

    public void stopCounter() {
        boardController.checkFinish();
    }

    private void createBoard(boolean isInitialLoad) {
        int level = 10;
        String boardPath = "/fxml/board_10x10.fxml";

        if (isInitialLoad) {
            File file = new File("save.json");
            if (file.exists()) {
                try {
                    FileReader reader = new FileReader("save.json");
                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
                    int savedLevel = Integer.parseInt(jsonObject.get("level").toString());
                    if (savedLevel == 10) {
                        choiceBoxLevel.setValue(options.get(0));
                        level = 10;
                        boardPath = "/fxml/board_10x10.fxml";
                    } else {
                        choiceBoxLevel.setValue(options.get(1));
                        level = 15;
                        boardPath = "/fxml/board_15x15.fxml";
                    }
                } catch (ParseException | IOException e) {
                    e.printStackTrace();
                }
            } else { // no file, initial load
                choiceBoxLevel.setValue(options.get(0));
            }
        } else { // not initial load
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
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(boardPath));
            VBox vbox = loader.load();
            this.vbox_home.getChildren().addAll(vbox.getChildren());
            boardController = loader.getController();
            boardController.startGame(level);
            if (isInitialLoad) {
                counterService.setTimer(boardController.getTimer());
            } else {
                counterService.setTimer(0);
            }
            if (!counterService.isRunning()) {
                counterService.start();
            } else {
                counterService.restart();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickTutorial(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/tutorial.fxml")));
        boardController.saveGame(timer.getText());
    }

    @FXML
    private void clickBack(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/start.fxml")));
        boardController.saveGame(timer.getText());
    }

    @FXML
    private void clickSolution(final ActionEvent event) {
        if (boardController == null) {
            return;
        } else {
            boardController.loadSolution();
            counterService.setTimer(0);
            counterService.cancel();
        }
    }

    @FXML
    void clickRestart(final ActionEvent event) {
        if (boardController == null) {
            return;
        } else {
            boardController.restart();
            counterService.setTimer(0);
            counterService.restart();
        }
    }

    @FXML
    private void clickNextGame() {
        boardController.loadNextGame();
        counterService.setTimer(0);
        counterService.restart();
    }
}
