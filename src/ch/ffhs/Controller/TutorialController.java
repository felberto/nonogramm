package ch.ffhs.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TutorialController {

    @FXML
    private Button btnBack;

    @FXML
    private VBox vbox_main;

    @FXML
    private void clickBack(final ActionEvent event) throws IOException {
        this.vbox_main.getChildren().clear();
        this.vbox_main.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/home.fxml")));
    }
}
