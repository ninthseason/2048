package pers.ninthseason.tzfe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    public Board board = new Board();
    public Action action = new Action(board);

    @Test
    void testAction() {
        System.out.println("初始化棋盘: ");
        action.initBoard();
        board.showBoard();

        System.out.println("上移");
        if (action.upMove()) {
            action.randomAdd();
        }
        board.showBoard();

        System.out.println("下移");
        if (action.downMove()) {
            action.randomAdd();
        }
        board.showBoard();

        System.out.println("右移");
        if (action.rightMove()) {
            action.randomAdd();
        }
        board.showBoard();

        System.out.println("左移");
        if (action.leftMove()) {
            action.randomAdd();
        }
        board.showBoard();
    }
}