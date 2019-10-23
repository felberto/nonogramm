package ch.ffhs.Models;

import ch.ffhs.Shared.State;

import java.util.Arrays;

/**
 * Class for board
 */
public class Board {

    private State[][] board;
    private int size;

    public Board(int length) {
        size = length;
        createInitialState(length);
    }

    private void createInitialState(int length) {
        board = new State[length][length];
        resetBoard();
    }

    public void resetBoard() {
        for (State[] row : board) {
            Arrays.fill(row, State.UNDEFINED);
        }
    }

    public State setNextState(int row, int column) {
        switch (board[row][column]) {
            case UNDEFINED:
                board[row][column] = State.MARKED;
                break;
            case MARKED:
                board[row][column] = State.SPACE;
                break;
            case SPACE:
                board[row][column] = State.UNDEFINED;
                break;
        }
        return board[row][column];
    }

    public int getSize() {
        return size;
    }

    public State[][] getBoard() {
        return board;
    }
}
