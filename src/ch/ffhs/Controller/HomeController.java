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
    private Button btnTutorial;
    @FXML
    private VBox vbox_home;
    @FXML
    private Button btnRestart;
    @FXML
    private ChoiceBox<String> choiceBoxLevel;
    @FXML
    private Button btnSolution;

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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Views/board_10x10.fxml"));
            VBox vbox = loader.load();
            this.vbox_home.getChildren().addAll(vbox.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickTutorial(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/tutorial.fxml")));
    }
}
