package pers.ninthseason.tzfe;

public interface IAction {

    void initBoard();

    boolean upMove();

    boolean downMove();

    boolean rightMove();

    boolean leftMove();

    void randomAdd();
}
