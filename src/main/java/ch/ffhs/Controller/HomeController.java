package ch.ffhs.Controller;

import ch.ffhs.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {

    public Main main;
    @FXML
    private VBox vbox_main;
    @FXML
    private Button btnTutorial, btnRestart, btnSolution;
    @FXML
    private VBox vbox_home;
    @FXML
    private ChoiceBox<String> choiceBoxLevel;

    private BoardController boardController;

    public void setMain(Main main) {
        this.main = main;
    }

    // called on initialization
    public void initialize() {
        createBoard();
        ObservableList<String> options = FXCollections.observableArrayList("Level: 10x10", "Level: 15x15");
        choiceBoxLevel.setItems(options);
        choiceBoxLevel.setValue(options.get(0));
    }

    private void createBoard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/board_10x10.fxml"));
            VBox vbox = loader.load();
            this.vbox_home.getChildren().addAll(vbox.getChildren());
            boardController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickTutorial(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/tutorial.fxml")));
    }

    @FXML
    private void clickBack(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/start.fxml")));
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
}
