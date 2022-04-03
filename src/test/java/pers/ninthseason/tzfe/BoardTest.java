package pers.ninthseason.tzfe;

import org.junit.jupiter.api.Test;

import java.util.Random;

class BoardTest {

    public Board board = new Board();

    @Test
    void showBoard() {
        System.out.println("展示棋盘: ");
        board.showBoard();
    }

    @Test
    void updateBoard() {
        System.out.println("更新棋盘: ");
        Random random = new Random();
        int x = random.nextInt(4);
        int y = random.nextInt(4);
        int z = random.nextInt(128);

        System.out.println(x + ", " + y + " -> " + z);
        board.updateBoard(x, y, z);
        board.showBoard();
    }
}