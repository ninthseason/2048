package pers.ninthseason.tzfe;

public class Launcher {
    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println("****************************************");
        System.out.println("*********         2048         *********");
        System.out.println("*********  Powered By Kl1nge5  *********");
        System.out.println("****************************************");
        System.out.println();
        while (true) {
//            controller.showBoard();
            controller.step();
        }
    }
}
