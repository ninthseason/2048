package pers.ninthseason.tzfe;

import java.util.Scanner;

public class Controller {

    private final Board board;
    private final Action action;

    public Controller() {
        this.board = new Board();
        this.action = new Action(board);
        action.initBoard();
    }

    public void step() {
        board.showBoard();
        Scanner scanner = new Scanner(System.in);
        String cmdString = scanner.nextLine();
        if (cmdString.isEmpty()) {
            cmdString = "?";
        }
        char cmd = cmdString.charAt(0);
        switch (cmd) {
            case 'w':
                if (action.upMove()) {
                    action.randomAdd();
                }
                break;
            case 's':
                if (action.downMove()) {
                    action.randomAdd();
                }
                break;
            case 'a':
                if (action.leftMove()) {
                    action.randomAdd();
                }
                break;
            case 'd':
                if (action.rightMove()) {
                    action.randomAdd();
                }
                break;
            default:
                step();
        }
    }
}