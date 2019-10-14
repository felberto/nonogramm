package ch.ffhs.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StartController {

    @FXML
    Button btnPlay;
    @FXML
    Button btnHighscore;
    @FXML
    private AnchorPane anchorPane_main;

    @FXML
    private void clickPlay(final ActionEvent event) throws IOException {
        this.anchorPane_main.getChildren().clear();
        this.anchorPane_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/home.fxml")));
    }

    @FXML
    private void clickHighscore(final ActionEvent event) throws IOException {
        this.anchorPane_main.getChildren().clear();
        this.anchorPane_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/highscore.fxml")));
    }
}
