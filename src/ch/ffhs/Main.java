package ch.ffhs;

import ch.ffhs.Controller.StartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Nonogramme lösen");
        mainView();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void mainView() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Views/start.fxml"));
            AnchorPane pane = loader.load();

            primaryStage.setMinHeight(600.00);
            primaryStage.setMinWidth(600.00);

            StartController startController = loader.getController();
            startController.setMain(this);

            Scene scene = new Scene(pane);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
        }
    }
}
