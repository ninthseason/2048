package pers.ninthseason.tzfe;

import java.util.ArrayList;

public class Board implements IBoard{

    private final int[][] boardData = new int[4][4];

    private int score = 0;

    public void addScore(int num) {
        score += num;
    }

    @Override
    public void showBoard() {
        System.out.println("当前分数: " + score);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(boardData[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("输 入 字 母 进 行 操 作:");
        System.out.println("↑ w | ↓ s | ← a | → d");
    }

    @Override
    public void updateBoard(int x, int y, int value) {
        boardData[x][y] = value;
    }

    @Override
    public int getValue(int x, int y) {
        if (x < 0 || x > 3 || y < 0 || y > 3) {
            return -1;
        }
        return boardData[x][y];
    }

    @Override
    public ArrayList<int[]> getSpaceIndex() {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (boardData[i][j] == 0) {
                    int[] t = {i, j};
                    result.add(t);
                }
            }
        }
        return result;
    }

    @Override
    public boolean compareBoard(int[][] preBoard) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (boardData[i][j] != preBoard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int[][] getRawData() {
        return boardData;
    }
}
