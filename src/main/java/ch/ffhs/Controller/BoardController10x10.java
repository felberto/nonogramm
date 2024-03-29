package ch.ffhs.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BoardController10x10 extends BoardController {

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

    @Override
    public void initialize() {
        super.setColLabels(new Label[]{label_col_0, label_col_1, label_col_2, label_col_3, label_col_4, label_col_5,
                label_col_6, label_col_7, label_col_8, label_col_9});

        super.setRowLabels(new Label[]{label_row_0, label_row_1, label_row_2, label_row_3, label_row_4, label_row_5,
                label_row_6, label_row_7, label_row_8, label_row_9});

        super.setButtons(new Button[][]{
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
        });
    }
}
