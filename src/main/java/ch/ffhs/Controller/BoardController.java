package ch.ffhs.Controller;

import ch.ffhs.Models.Board;
import ch.ffhs.Shared.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Controller for board
 */
public abstract class BoardController {

    private Board board;
    private Button[][] buttons;
    private JSONObject actualBoard;
    private int level;
    private int actualBoardId;
    private int timer;
    private HomeController homeController;

    private Label[] columnLabels, rowLabels;

    public void setRowLabels(Label[] rowLabels) {
        this.rowLabels = rowLabels;
    }

    public void setColLabels(Label[] columnLabels) {
        this.columnLabels = columnLabels;
    }

    public void setButtons(Button[][] buttons) {
        this.buttons = buttons;
    }

    public abstract void initialize();

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    private void setLabels(JSONObject board) {
        JSONArray columns = (JSONArray) board.get("columns");

        for (int i = 0; i < columns.size(); i++) {
            JSONArray col = (JSONArray) columns.get(i);
            String colText = col.toString().replace("[", "").replace("]", "").replace(",", "\n");
            Label colLabel = columnLabels[i];
            colLabel.setText(colText);
        }

        JSONArray rows = (JSONArray) board.get("rows");
        for (int i = 0; i < rows.size(); i++) {
            JSONArray row = (JSONArray) rows.get(i);
            String rowText = row.toString().replace("[", "").replace("]", "").replace(",", " ");
            rowLabels[i].setText(rowText);
        }
    }

    @FXML
    public void clickButton(final ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        List<String> index = Arrays.asList(btn.getId().replace("btn_", "").split("_"));
        int row = Integer.parseInt(index.get(0));
        int column = Integer.parseInt(index.get(1));
        setButtonLayout(row, column);
        if (checkFinish()) {
            homeController.counterService.cancel();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fertig");

            alert.setHeaderText("Herzlichen Glückwunsch!");

            alert.showAndWait();
        }
    }

    public boolean checkFinish() {
        JSONArray solution = (JSONArray) actualBoard.get("solution");
        boolean[][] solutionArray = new boolean[solution.size()][solution.size()];
        for (int i = 0; i < solution.size(); i++) {
            JSONArray row = (JSONArray) solution.get(i);
            for (int j = 0; j < row.size(); j++) {
                solutionArray[i][j] = (boolean) row.get(j);
            }
        }
        boolean finished = true;
        for (int i = 0; i < solutionArray.length; i++) {
            for (int j = 0; j < solutionArray[i].length; j++) {
                if (solutionArray[i][j]) {
                    if (!buttons[i][j].getStyle().equals("-fx-background-color: #645E9D")) {
                        finished = false;
                        break;
                    }
                }
            }
        }
        return finished;
    }

    private void setButtonLayout(int row, int column) {
        State state = board.setNextState(row, column);
        Button btn = buttons[row][column];

        switch (state) {
            case UNDEFINED:
                btn.setText("");
                break;
            case MARKED:
                btn.setStyle("-fx-background-color: #645E9D");
                break;
            case SPACE:
                btn.setStyle("-fx-background-color: none");
                btn.setText("X");
                break;
        }
    }

    public void loadSolution() {
        JSONArray solution = (JSONArray) actualBoard.get("solution");
        boolean[][] solutionArray = new boolean[solution.size()][solution.size()];
        for (int i = 0; i < solution.size(); i++) {
            JSONArray row = (JSONArray) solution.get(i);
            for (int j = 0; j < row.size(); j++) {
                solutionArray[i][j] = (boolean) row.get(j);
            }
        }
        setSolutionState(solutionArray);
        board.resetBoard();
    }

    public void restart() {
        board.resetBoard();
        clearBoardLayout();
    }

    private void clearBoardLayout() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                buttons[i][j].setStyle("-fx-background-color: none");
                buttons[i][j].setText("");
            }
        }
    }

    private void setSolutionState(boolean[][] solutionArray) {
        for (int i = 0; i < solutionArray.length; i++) {
            for (int j = 0; j < solutionArray[i].length; j++) {
                if (solutionArray[i][j]) {
                    buttons[i][j].setStyle("-fx-background-color: #645E9D");
                } else {
                    buttons[i][j].setStyle("-fx-background-color: none;");
                }
                buttons[i][j].setText("");
            }
        }
    }

    public void startGame(int level) {
        this.level = level;
        try {
            loadGame();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBoard(int boardId) {
        // get labels
        String filePath = getClass().getResource("/games.json").getPath();
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject games = (JSONObject) jsonObject.get("games");
            JSONArray boards = (JSONArray) games.get(this.level == 10 ? "10x10" : "15x15");

            actualBoard = (JSONObject) boards.get(boardId);
            setLabels(actualBoard);
            this.actualBoardId = boardId;
        } catch (IOException | ParseException ex) {
            System.out.println("Error loading file");
        }
        board = new Board(this.level);
    }

    public void loadNextGame() {
        loadBoard((this.actualBoardId + 1) % 4);
        clearBoardLayout();
    }

    public void saveGame(String time) {
        JSONObject saveGame = new JSONObject();
        saveGame.put("id", this.actualBoardId);
        saveGame.put("time", Integer.parseInt(time));
        saveGame.put("level", this.level);

        JSONArray list = new JSONArray();

        for (Button[] button : buttons) {
            JSONArray array = new JSONArray();
            for (Button value : button) {
                if (value.getStyle().equals("-fx-background-color: #645E9D")) {
                    array.add(true);
                } else {
                    array.add(false);
                }

            }
            list.add(array);
        }

        saveGame.put("buttons", list);

        try (FileWriter file = new FileWriter("save.json")) {
            file.write(saveGame.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGame() throws IOException, ParseException {
        File file = new File("save.json");
        if (file.exists()) {
            FileReader reader = new FileReader("save.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            int currentLevel = Integer.parseInt(jsonObject.get("level").toString());
            if (currentLevel != this.level) {
                loadBoard(0);
            } else {
                Long id = (Long) jsonObject.get("id");
                Long timer = (Long) jsonObject.get("time");
                setTimer(timer.intValue());
                JSONArray saveArray = (JSONArray) jsonObject.get("buttons");
                boolean[][] saveState = new boolean[saveArray.size()][saveArray.size()];
                for (int i = 0; i < saveArray.size(); i++) {
                    JSONArray row = (JSONArray) saveArray.get(i);
                    for (int j = 0; j < row.size(); j++) {
                        saveState[i][j] = (boolean) row.get(j);
                    }
                }
                loadBoard(Integer.parseInt(id.toString()));
                setSolutionState(saveState);
            }
        } else {
            loadBoard(0);
        }
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
