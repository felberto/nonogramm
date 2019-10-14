package ch.ffhs.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BoardController15x15 extends BoardController {

    @FXML
    private Button btn_0_0, btn_0_1, btn_0_2, btn_0_3, btn_0_4, btn_0_5, btn_0_6, btn_0_7, btn_0_8, btn_0_9, btn_0_10, btn_0_11, btn_0_12, btn_0_13, btn_0_14,
            btn_1_0, btn_1_1, btn_1_2, btn_1_3, btn_1_4, btn_1_5, btn_1_6, btn_1_7, btn_1_8, btn_1_9, btn_1_10, btn_1_11, btn_1_12, btn_1_13, btn_1_14,
            btn_2_0, btn_2_1, btn_2_2, btn_2_3, btn_2_4, btn_2_5, btn_2_6, btn_2_7, btn_2_8, btn_2_9, btn_2_10, btn_2_11, btn_2_12, btn_2_13, btn_2_14,
            btn_3_0, btn_3_1, btn_3_2, btn_3_3, btn_3_4, btn_3_5, btn_3_6, btn_3_7, btn_3_8, btn_3_9, btn_3_10, btn_3_11, btn_3_12, btn_3_13, btn_3_14,
            btn_4_0, btn_4_1, btn_4_2, btn_4_3, btn_4_4, btn_4_5, btn_4_6, btn_4_7, btn_4_8, btn_4_9, btn_4_10, btn_4_11, btn_4_12, btn_4_13, btn_4_14,
            btn_5_0, btn_5_1, btn_5_2, btn_5_3, btn_5_4, btn_5_5, btn_5_6, btn_5_7, btn_5_8, btn_5_9, btn_5_10, btn_5_11, btn_5_12, btn_5_13, btn_5_14,
            btn_6_0, btn_6_1, btn_6_2, btn_6_3, btn_6_4, btn_6_5, btn_6_6, btn_6_7, btn_6_8, btn_6_9, btn_6_10, btn_6_11, btn_6_12, btn_6_13, btn_6_14,
            btn_7_0, btn_7_1, btn_7_2, btn_7_3, btn_7_4, btn_7_5, btn_7_6, btn_7_7, btn_7_8, btn_7_9, btn_7_10, btn_7_11, btn_7_12, btn_7_13, btn_7_14,
            btn_8_0, btn_8_1, btn_8_2, btn_8_3, btn_8_4, btn_8_5, btn_8_6, btn_8_7, btn_8_8, btn_8_9, btn_8_10, btn_8_11, btn_8_12, btn_8_13, btn_8_14,
            btn_9_0, btn_9_1, btn_9_2, btn_9_3, btn_9_4, btn_9_5, btn_9_6, btn_9_7, btn_9_8, btn_9_9, btn_9_10, btn_9_11, btn_9_12, btn_9_13, btn_9_14,
            btn_10_0, btn_10_1, btn_10_2, btn_10_3, btn_10_4, btn_10_5, btn_10_6, btn_10_7, btn_10_8, btn_10_9, btn_10_10, btn_10_11, btn_10_12, btn_10_13, btn_10_14,
            btn_11_0, btn_11_1, btn_11_2, btn_11_3, btn_11_4, btn_11_5, btn_11_6, btn_11_7, btn_11_8, btn_11_9, btn_11_10, btn_11_11, btn_11_12, btn_11_13, btn_11_14,
            btn_12_0, btn_12_1, btn_12_2, btn_12_3, btn_12_4, btn_12_5, btn_12_6, btn_12_7, btn_12_8, btn_12_9, btn_12_10, btn_12_11, btn_12_12, btn_12_13, btn_12_14,
            btn_13_0, btn_13_1, btn_13_2, btn_13_3, btn_13_4, btn_13_5, btn_13_6, btn_13_7, btn_13_8, btn_13_9, btn_13_10, btn_13_11, btn_13_12, btn_13_13, btn_13_14,
            btn_14_0, btn_14_1, btn_14_2, btn_14_3, btn_14_4, btn_14_5, btn_14_6, btn_14_7, btn_14_8, btn_14_9, btn_14_10, btn_14_11, btn_14_12, btn_14_13, btn_14_14;


    @FXML
    private Label label_col_0, label_col_1, label_col_2, label_col_3, label_col_4, label_col_5, label_col_6, label_col_7, label_col_8, label_col_9,
            label_col_10, label_col_11, label_col_12, label_col_13, label_col_14,
            label_row_0, label_row_1, label_row_2, label_row_3, label_row_4, label_row_5, label_row_6, label_row_7, label_row_8, label_row_9,
            label_row_10, label_row_11, label_row_12, label_row_13, label_row_14;

    @Override
    public void initialize() {
        super.setColLabels(new Label[]{label_col_0, label_col_1, label_col_2, label_col_3, label_col_4, label_col_5,
                label_col_6, label_col_7, label_col_8, label_col_9, label_col_10, label_col_11, label_col_12, label_col_13, label_col_14,});

        super.setRowLabels(new Label[]{label_row_0, label_row_1, label_row_2, label_row_3, label_row_4, label_row_5,
                label_row_6, label_row_7, label_row_8, label_row_9, label_row_10, label_row_11, label_row_12, label_row_13, label_row_14});

        super.setButtons(new Button[][]{
                {btn_0_0, btn_0_1, btn_0_2, btn_0_3, btn_0_4, btn_0_5, btn_0_6, btn_0_7, btn_0_8, btn_0_9, btn_0_10, btn_0_11, btn_0_12, btn_0_13, btn_0_14},
                {btn_1_0, btn_1_1, btn_1_2, btn_1_3, btn_1_4, btn_1_5, btn_1_6, btn_1_7, btn_1_8, btn_1_9, btn_1_10, btn_1_11, btn_1_12, btn_1_13, btn_1_14},
                {btn_2_0, btn_2_1, btn_2_2, btn_2_3, btn_2_4, btn_2_5, btn_2_6, btn_2_7, btn_2_8, btn_2_9, btn_2_10, btn_2_11, btn_2_12, btn_2_13, btn_2_14},
                {btn_3_0, btn_3_1, btn_3_2, btn_3_3, btn_3_4, btn_3_5, btn_3_6, btn_3_7, btn_3_8, btn_3_9, btn_3_10, btn_3_11, btn_3_12, btn_3_13, btn_3_14},
                {btn_4_0, btn_4_1, btn_4_2, btn_4_3, btn_4_4, btn_4_5, btn_4_6, btn_4_7, btn_4_8, btn_4_9, btn_4_10, btn_4_11, btn_4_12, btn_4_13, btn_4_14},
                {btn_5_0, btn_5_1, btn_5_2, btn_5_3, btn_5_4, btn_5_5, btn_5_6, btn_5_7, btn_5_8, btn_5_9, btn_5_10, btn_5_11, btn_5_12, btn_5_13, btn_5_14},
                {btn_6_0, btn_6_1, btn_6_2, btn_6_3, btn_6_4, btn_6_5, btn_6_6, btn_6_7, btn_6_8, btn_6_9, btn_6_10, btn_6_11, btn_6_12, btn_6_13, btn_6_14},
                {btn_7_0, btn_7_1, btn_7_2, btn_7_3, btn_7_4, btn_7_5, btn_7_6, btn_7_7, btn_7_8, btn_7_9, btn_7_10, btn_7_11, btn_7_12, btn_7_13, btn_7_14},
                {btn_8_0, btn_8_1, btn_8_2, btn_8_3, btn_8_4, btn_8_5, btn_8_6, btn_8_7, btn_8_8, btn_8_9, btn_8_10, btn_8_11, btn_8_12, btn_8_13, btn_8_14},
                {btn_9_0, btn_9_1, btn_9_2, btn_9_3, btn_9_4, btn_9_5, btn_9_6, btn_9_7, btn_9_8, btn_9_9, btn_9_10, btn_9_11, btn_9_12, btn_9_13, btn_9_14},
                {btn_10_0, btn_10_1, btn_10_2, btn_10_3, btn_10_4, btn_10_5, btn_10_6, btn_10_7, btn_10_8, btn_10_9, btn_10_10, btn_10_11, btn_10_12, btn_10_13, btn_10_14},
                {btn_11_0, btn_11_1, btn_11_2, btn_11_3, btn_11_4, btn_11_5, btn_11_6, btn_11_7, btn_11_8, btn_11_9, btn_11_10, btn_11_11, btn_11_12, btn_11_13, btn_11_14},
                {btn_12_0, btn_12_1, btn_12_2, btn_12_3, btn_12_4, btn_12_5, btn_12_6, btn_12_7, btn_12_8, btn_12_9, btn_12_10, btn_12_11, btn_12_12, btn_12_13, btn_12_14},
                {btn_13_0, btn_13_1, btn_13_2, btn_13_3, btn_13_4, btn_13_5, btn_13_6, btn_13_7, btn_13_8, btn_13_9, btn_13_10, btn_13_11, btn_13_12, btn_13_13, btn_13_14},
                {btn_14_0, btn_14_1, btn_14_2, btn_14_3, btn_14_4, btn_14_5, btn_14_6, btn_14_7, btn_14_8, btn_14_9, btn_14_10, btn_14_11, btn_14_12, btn_14_13, btn_14_14}
        });
    }
}
