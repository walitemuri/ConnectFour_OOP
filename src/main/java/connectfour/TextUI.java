package connectfour;
import java.util.Scanner;

public class TextUI{

    /**
     * @param cfour
     */
    private static int getColInput(ConnectFour cfour) {
        
        boolean valid = false;
        String strInput;
        int num;

        Scanner input = new Scanner(System.in);
            
        while (!valid) {
            System.out.println("Enter a column to place piece: ");
            strInput = input.nextLine();
            try {
                num = Integer.parseInt(strInput);
                if (num > 7 || num < 1) {
                    System.out.println("Error - enter an integer value between 1-7");
                    valid = false;
                }else {
                    if (cfour.isColumnFull(num)) {
                        System.out.println("Error - Selected Column is Full.");
                        valid = false;
                    } else {
                        valid = true;
                        return num;
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println("Error - enter an integer value between 1-7");
            }    
        }
        return 0;
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
                break;
            } else if (cFourGame.winningPlayer() == 2) {
                userIO.printWinner(2);
                break;
            } else if (draw) {
                System.out.println("Its a draw");
            }

            move = getColInput(cFourGame);
            if (move == 4) {
                return;
            }

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