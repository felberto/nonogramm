package ch.ffhs.Controller;

import ch.ffhs.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StartController {

    public Main main;
    @FXML
    Button btnPlay;
    @FXML
    Button btnHighscore;
    @FXML
    private AnchorPane anchorPane_main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void clickPlay(final ActionEvent event) throws IOException {
        this.anchorPane_main.getChildren().clear();
        this.anchorPane_main.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/home.fxml")));
    }

    @FXML
    private void clickHighscore(final ActionEvent event) throws IOException {
        this.anchorPane_main.getChildren().clear();
        this.anchorPane_main.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/highscore.fxml")));
    }
}
