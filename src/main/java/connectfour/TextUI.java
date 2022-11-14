package connectfour;
import java.util.Scanner;

public class TextUI{

    /**
     * @param cfour
     */
    private static int getColInput() {

        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void printWinner(int n) {
        System.out.println("Helo");
    }

    
    public static void main(String[] args) {
        
        TextUI userIO = new TextUI();
        ConnectFour cFourGame = new ConnectFour();
        cFourGame.setPlayerOneSymbol("X");
        cFourGame.setPlayerTwoSymbol("O");
        cFourGame.setTurn(1);
        int move;

        while(cFourGame.winningPlayer() == 0) {

            boolean draw = cFourGame.checkDraw();

            if (cFourGame.winningPlayer() == 1) {
                userIO.printWinner(1);
                System.out.println("X win");
                break;
            } else if (cFourGame.winningPlayer() == 2) {
                userIO.printWinner(2);
                System.out.println("X win");
                break;
            } else if (draw) {
                System.out.println("Its a draw");
            }

            move = getColInput();
            
            System.out.println(move);
            System.out.println(cFourGame.getTurn());
            if (cFourGame.getTurn() == 1) {
                cFourGame.setPlayerOneMove(move);
            } else {
                cFourGame.setPlayerTwoMove(move);
            }
            cFourGame.placePiece();
            cFourGame.swapTurn();
            cFourGame.getCurrBoard();
        }

    }

}