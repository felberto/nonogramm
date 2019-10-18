package ch.ffhs.Controller;

import ch.ffhs.Models.Board;
import ch.ffhs.Shared.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class BoardController {

    private Board board;
    private Button[][] buttons;
    private JSONObject actualBoard;
    private String level;
    private int actualBoardId;

    @FXML
    private Button btn_0_0, btn_0_1, btn_0_2, btn_0_3, btn_0_4, btn_0_5, btn_0_6, btn_0_7, btn_0_8, btn_0_9,
            btn_1_0, btn_1_1, btn_1_2, btn_1_3, btn_1_4, btn_1_5, btn_1_6, btn_1_7, btn_1_8, btn_1_9,
            btn_2_0, btn_2_1, btn_2_2, btn_2_3, btn_2_4, btn_2_5, btn_2_6, btn_2_7, btn_2_8, btn_2_9,
            btn_3_0, btn_3_1, btn_3_2, btn_3_3, btn_3_4, btn_3_5, btn_3_6, btn_3_7, btn_3_8, btn_3_9,
            btn_4_0, btn_4_1, btn_4_2, btn_4_3, btn_4_4, btn_4_5, btn_4_6, btn_4_7, btn_4_8, btn_4_9,
            btn_5_0, btn_5_1, btn_5_2, btn_5_3, btn_5_4, btn_5_5, btn_5_6, btn_5_7, btn_5_8, btn_5_9,
            btn_6_0, btn_6_1, btn_6_2, btn_6_3, btn_6_4, btn_6_5, btn_6_6, btn_6_7, btn_6_8, btn_6_9,
            btn_7_0, btn_7_1, btn_7_2, btn_7_3, btn_7_4, btn_7_5, btn_7_6, btn_7_7, btn_7_8, btn_7_9,
            btn_8_0, btn_8_1, btn_8_2, btn_8_3, btn_8_4, btn_8_5, btn_8_6, btn_8_7, btn_8_8, btn_8_9,
            btn_9_0, btn_9_1, btn_9_2, btn_9_3, btn_9_4, btn_9_5, btn_9_6, btn_9_7, btn_9_8, btn_9_9;

    @FXML
    private Label label_col_0, label_col_1, label_col_2, label_col_3, label_col_4, label_col_5, label_col_6, label_col_7, label_col_8, label_col_9,
            label_row_0, label_row_1, label_row_2, label_row_3, label_row_4, label_row_5, label_row_6, label_row_7, label_row_8, label_row_9;

    private Label[] columnLabels, rowLabels;

    public void initialize() {
        columnLabels = new Label[]{label_col_0, label_col_1, label_col_2, label_col_3, label_col_4, label_col_5,
                label_col_6, label_col_7, label_col_8, label_col_9};

        rowLabels = new Label[]{label_row_0, label_row_1, label_row_2, label_row_3, label_row_4, label_row_5,
                label_row_6, label_row_7, label_row_8, label_row_9};

        buttons = new Button[][]{
                {btn_0_0, btn_0_1, btn_0_2, btn_0_3, btn_0_4, btn_0_5, btn_0_6, btn_0_7, btn_0_8, btn_0_9},
                {btn_1_0, btn_1_1, btn_1_2, btn_1_3, btn_1_4, btn_1_5, btn_1_6, btn_1_7, btn_1_8, btn_1_9},
                {btn_2_0, btn_2_1, btn_2_2, btn_2_3, btn_2_4, btn_2_5, btn_2_6, btn_2_7, btn_2_8, btn_2_9},
                {btn_3_0, btn_3_1, btn_3_2, btn_3_3, btn_3_4, btn_3_5, btn_3_6, btn_3_7, btn_3_8, btn_3_9},
                {btn_4_0, btn_4_1, btn_4_2, btn_4_3, btn_4_4, btn_4_5, btn_4_6, btn_4_7, btn_4_8, btn_4_9},
                {btn_5_0, btn_5_1, btn_5_2, btn_5_3, btn_5_4, btn_5_5, btn_5_6, btn_5_7, btn_5_8, btn_5_9},
                {btn_6_0, btn_6_1, btn_6_2, btn_6_3, btn_6_4, btn_6_5, btn_6_6, btn_6_7, btn_6_8, btn_6_9},
                {btn_7_0, btn_7_1, btn_7_2, btn_7_3, btn_7_4, btn_7_5, btn_7_6, btn_7_7, btn_7_8, btn_7_9},
                {btn_8_0, btn_8_1, btn_8_2, btn_8_3, btn_8_4, btn_8_5, btn_8_6, btn_8_7, btn_8_8, btn_8_9},
                {btn_9_0, btn_9_1, btn_9_2, btn_9_3, btn_9_4, btn_9_5, btn_9_6, btn_9_7, btn_9_8, btn_9_9}
        };
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
    public void clickButton(final ActionEvent event) {
        Button btn = (Button) event.getSource();
        List<String> index = Arrays.asList(btn.getId().replace("btn_", "").split("_"));
        int row = Integer.parseInt(index.get(0));
        int column = Integer.parseInt(index.get(1));
        setButtonLayout(row, column);
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
                    buttons[i][j].setText("");
                    buttons[i][j].setStyle("-fx-background-color: none;");
                }
            }
        }
    }

    private void setLevel(String level) {
        switch (level) {
            case "Level: 10x10":
                this.level = "10x10";
                break;
            case "Level: 15x15":
                this.level = "15x15";
                break;
        }
    }

    public void startGame(String levelString) {
        setLevel(levelString);
        loadBoard(0);
    }

    private void loadBoard(int boardId) {
        // get labels
        String filePath = getClass().getResource("/games.json").getPath();
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONObject games = (JSONObject) jsonObject.get("games");
            JSONArray boards = (JSONArray) games.get(this.level);

            actualBoard = (JSONObject) boards.get(boardId);
            setLabels(actualBoard);
            this.actualBoardId = boardId;
        } catch (IOException | ParseException ex) {
            System.out.println("Error loading file");
        }
        board = new Board(this.level.equals("10x10") ? 10 : 15);
    }

    public void loadNextGame() {
        loadBoard((this.actualBoardId + 1) % 4);
        clearBoardLayout();
    }

    public void saveGame() {
        JSONObject saveGame = new JSONObject();
        saveGame.put("id", this.actualBoardId);

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

    public void loadGame() throws IOException, ParseException {
        File file = new File("save.json");
        if (file.exists()) {
            FileReader reader = new FileReader("save.json");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            Long id = (Long) jsonObject.get("id");
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
    }
}
