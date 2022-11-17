package connectfour;
import java.util.Scanner;


/**
 * This class is a Template for the TextUI Object
 * <p>
 * 1 Atrribute - Scanner 
 * Responsbile for handling UI and Interaction
 * 
 * @author Wali Temuri - 1183379
 */
public class TextUI{

    private Scanner input = new Scanner(System.in);

    private void closeScanner() {
        input.close();
    }

     /**
     * Prints the menu and ensures correct input
     * Uses Scanner to get user input and try-catch blocks for input validation
     * Returns String containing input
     *      
     * @param Null
     * @return String
     */
    private String getMenu() {
        System.out.println("Would you like to load a saved game or play a new one?");
        System.out.println("1.Load Game");
        System.out.println("2.Run a New Game");

        boolean valid = false;
        String strInput = "";
        int num;

        while(!valid) {
            System.out.println("Enter Selection (1-2): ");
            strInput = input.next();
            try {
                num = Integer.parseInt(strInput);
                if(num > 2 || num < 1) {
                    System.out.println("Error - enter an integer value between 1-2");
                    valid = false;
                } else {
                    if(num == 1) {
                        System.out.println("Enter filename: ");
                        strInput = input.next();
                        return strInput;
                    }else if(num == 2) {
                        return null;
                    }else { 
                        valid = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error Invalid Input - Enter 1 to Load Game, 2 for a New Game");
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    /**
     * Method Is responsible for Getting Column Input
     * Uses Scanner to get user input and try-catch blocks for input validation
     * Returns integer containing move
     *      
     * @param Connect4Game
     * @return Int
     */
    private int getColInput(ConnectFour cfour) {
        
        boolean valid = false;
        String strInput = "";
        int num;

            while (!valid) {
                System.out.println("Enter a column to place piece (1-7) or 10 to Save and Quit: ");
               
                strInput = input.next();
                try {
                    num = Integer.parseInt(strInput);
                    if (num > 7 || num < 1) {
                        if(num == 10) {
                            valid = true;
                            return num;
                        }else {
                            System.out.println("Error - enter an integer value between 1-7");
                            valid = false;
                        }
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
                    System.out.println(e.getMessage());
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

     /**
     * Main method
     * Runs the game using Connect4 instance and TextUI
     *      
     * @param String[] args
     * @return Int
     */
    public static void main(String[] args) {
    
        TextUI userIO = new TextUI();
        ConnectFour cFourGame = new ConnectFour();
        cFourGame.setPlayerOneSymbol("X");
        cFourGame.setPlayerTwoSymbol("O");
        cFourGame.setTurn(1);
        int move;
        String fileName = userIO.getMenu();
        
        if (fileName != null) {
            cFourGame.loadGame(fileName);
        }

        cFourGame.getInstructions();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cFourGame.getCurrBoard();        
        while(cFourGame.winningPlayer() == 0 &&!cFourGame.checkDraw()) {

            move = userIO.getColInput(cFourGame);
            if(move == 10) {
                cFourGame.saveGame();
                userIO.closeScanner();
                System.out.println("Game is saved in /course/coursework/A2/assets/saveFile.csv");
                System.exit(0);
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
       userIO.printWinner(cFourGame.winningPlayer());
       userIO.closeScanner();
    }
}