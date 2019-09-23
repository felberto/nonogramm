package ch.ffhs.Models;

import ch.ffhs.Shared.State;

public class Board {

    private State[][] board;

    public Board() {
    }

    public State[][] getBoard() {
        return board;
    }

    public void setBoard(State[][] board) {
        this.board = board;
    }
}
