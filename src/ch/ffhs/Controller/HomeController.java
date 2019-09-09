package ch.ffhs.Controller;

import ch.ffhs.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HomeController {

    public Main main;
    @FXML
    private Pane pane;
    @FXML
    private Button btnRestart;
    @FXML
    private ChoiceBox<?> dropdownLevel;
    @FXML
    private Button btnSolution;

    public void setMain(Main main) {
        this.main = main;
        createBoard();
    }

    public void createBoard() {
        Button btn1 = new Button();
        btn1.setStyle("-fx-border-color: rgb(122,122,122); -fx-border-width: 1px;");
        btn1.setPrefHeight(10.0);
        btn1.setPrefWidth(10.0);
        Button btn2 = new Button();
        btn2.setStyle("-fx-border-color: rgb(122,122,122); -fx-border-width: 1px;");
        btn2.maxWidth(4.0);
        btn2.maxHeight(4.0);

        HBox hbox = new HBox(btn1, btn2);
        pane.getChildren().add(hbox);
        System.out.println(btn1.getWidth() + ", " + btn1.getHeight());
    }
}
