package connectfour;
import java.util.Scanner;

public class TextUI{

    private Scanner input = new Scanner(System.in);

    private void closeScanner() {
        input.close();
    }

    private int getColInput(ConnectFour cfour) {
        
        boolean valid = false;
        String strInput = "";
        int num;

            while (!valid) {
                System.out.println("Enter a column to place piece: ");
               
                strInput = input.next();
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
        if(n == 1) {
            System.out.println("X is the Winner");
        }else if (n == 2) {
            System.out.println("O is the Winner");
        } else {
            System.out.println("Draw");
        }
    }

    
    public static void main(String[] args) {
        
        TextUI userIO = new TextUI();
        ConnectFour cFourGame = new ConnectFour();
        cFourGame.setPlayerOneSymbol("X");
        cFourGame.setPlayerTwoSymbol("O");
        cFourGame.setTurn(1);
        int move;

        cFourGame.getInstructions();
        while(cFourGame.winningPlayer() == 0 &&!cFourGame.checkDraw()) {

            move = userIO.getColInput(cFourGame);
            
            if (cFourGame.getTurn() == 1) {
                cFourGame.setPlayerOneMove(move);
            } else {
                cFourGame.setPlayerTwoMove(move);
            }
            cFourGame.placePiece();
            cFourGame.swapTurn();
            cFourGame.getCurrBoard();
        }
       userIO.printWinner(cFourGame.winningPlayer());
       userIO.closeScanner();
    }

}