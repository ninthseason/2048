package pers.ninthseason.tzfe;

import java.util.ArrayList;

public interface IBoard {
    void showBoard();

    void updateBoard(int x, int y, int value);

    int getValue(int x, int y);

    ArrayList<int[]> getSpaceIndex();

    boolean compareBoard(int[][] preBoard);

    int[][] getRawData();
}
