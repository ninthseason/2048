package pers.ninthseason.tzfe;

import java.util.ArrayList;
import java.util.Random;

public class Action implements IAction {

    private final Board board;
    private int[][] preBoard;

    public Action(Board board) {
        this.board = board;
        this.preBoard = board.getRawData().clone();
    }

    @Override
    public void initBoard() {
        randomAdd();
        randomAdd();
    }

    private void oneUpMove(int i, int j) {
        if (board.getValue(i - 1, j) == 0) {
            board.updateBoard(i - 1, j, board.getValue(i, j));
            board.updateBoard(i, j, 0);
            oneUpMove(i - 1, j);

        } else if (board.getValue(i - 1, j) == board.getValue(i, j)) {
            board.updateBoard(i - 1, j, board.getValue(i - 1, j) * 2);
            board.addScore(board.getValue(i, j));
            board.updateBoard(i, j, 0);
        }
    }

    @Override
    public boolean upMove() {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                oneUpMove(i, j);
            }
        }
        return checkMoveSuccessful();
    }

    private void oneDownMove(int i, int j) {
        if (board.getValue(i + 1, j) == 0) {
            board.updateBoard(i + 1, j, board.getValue(i, j));
            board.updateBoard(i, j, 0);
            oneDownMove(i + 1, j);

        } else if (board.getValue(i + 1, j) == board.getValue(i, j)) {
            board.updateBoard(i + 1, j, board.getValue(i + 1, j) * 2);
            board.addScore(board.getValue(i, j));
            board.updateBoard(i, j, 0);
        }
    }

    @Override
    public boolean downMove() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                oneDownMove(i, j);
            }
        }
        return checkMoveSuccessful();
    }

    private void oneRightMove(int i, int j) {
        if (board.getValue(i, j + 1) == 0) {
            board.updateBoard(i, j + 1, board.getValue(i, j));
            board.updateBoard(i, j, 0);
            oneRightMove(i, j + 1);

        } else if (board.getValue(i, j + 1) == board.getValue(i, j)) {
            board.updateBoard(i, j + 1, board.getValue(i, j + 1) * 2);
            board.addScore(board.getValue(i, j));
            board.updateBoard(i, j, 0);
        }
    }

    @Override
    public boolean rightMove() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                oneRightMove(j, i);
            }
        }
        return checkMoveSuccessful();
    }

    private void oneLeftMove(int i, int j) {
        if (board.getValue(i, j - 1) == 0) {
            board.updateBoard(i, j - 1, board.getValue(i, j));
            board.updateBoard(i, j, 0);
            oneLeftMove(i, j - 1);

        } else if (board.getValue(i, j - 1) == board.getValue(i, j)) {
            board.updateBoard(i, j - 1, board.getValue(i, j - 1) * 2);
            board.addScore(board.getValue(i, j));
            board.updateBoard(i, j, 0);
        }
    }

    @Override
    public boolean leftMove() {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                oneLeftMove(j, i);
            }
        }
        return checkMoveSuccessful();
    }

    @Override
    public void randomAdd() {
        Random random = new Random();
        ArrayList<int[]> spaceIndex = board.getSpaceIndex();
        if (spaceIndex.size() < 1) {
            return;
        }
        int x = random.nextInt(spaceIndex.size());
        board.updateBoard(spaceIndex.get(x)[0], spaceIndex.get(x)[1], 2);
        this.preBoard = board.getRawData();
    }

    private boolean checkMoveSuccessful() {
        if (board.compareBoard(preBoard)) {
            this.preBoard = board.getRawData();
            return true;
        }
        this.preBoard = board.getRawData();
        return false;
    }
}
