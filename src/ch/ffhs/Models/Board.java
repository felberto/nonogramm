package ch.ffhs.Models;

import ch.ffhs.Shared.State;

import java.util.Arrays;

public class Board {

    private State[][] board;

    public Board(int length) {
        createInitialState(length);
    }

    private void createInitialState(int length) {
        board = new State[length][length];
        for (State[] row : board) {
            Arrays.fill(row, State.UNDEFINED);
        }
    }

    public State setState(int row, int column) {
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
}
