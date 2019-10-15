package ch.ffhs.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HighscoreController {
    @FXML
    private AnchorPane anchorPane_main;

    @FXML
    private void clickBack(final ActionEvent event) throws IOException {
        this.anchorPane_main.getChildren().clear();
        this.anchorPane_main.getChildren().add(FXMLLoader.load(getClass().getResource("/fxml/start.fxml")));
    }
}
