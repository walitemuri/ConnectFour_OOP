package connectfour;

public class TextUI{

    public static void main(String[] args) {
        
        ConnectFour cFourGame = new ConnectFour();
        cFourGame.setPlayerOneSymbol("X");
        cFourGame.setPlayerTwoSymbol("O");
        cFourGame.setTurn(1);

        while(cFourGame.winningPlayer() == 0) {

            boolean draw = cFourGame.checkDraw();

            if (cFourGame.winningPlayer() == 1) {
                printWinner();
                break;
            } else if (cFourGame.winningPlayer() == 2) {
                printWinner();
                break;
            } else if (draw) {
                System.out.println("Its a draw");
            }

            cFourGame.placePiece();
            cFourGame.swapTurn();
        }

    }

}