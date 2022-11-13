package connectfour;

public class ConnectFour{

    private Board board = new Board();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn;

    public void setTurn(int n) {
        switch(n) {
            case 1:
                turn = 1;
                break;
            case 2:
                turn = 2;
                break;
            default:
                System.out.println("Invalid Inputb\n");
                return;
        }
    }

    public void setPlayerOneSymbol(String symbol) {
        player1.setPiece(symbol);;
    }

    public void setPlayerTwoSymbol(String symbol) {
        player2.setPiece(symbol);
    }

    public void setPlayerOneMove(int n) {
        player1.setMove(n);
    }

    public void setPlayerTwoMove(int n) {
        player2.setMove(n);
    }

    public void placePiece()
    {
        if (turn == 1) {
            board.placePiece(player1);
        }
        else {
            board.placePiece(player2);
        }
    }

    public int winningPlayer() {
        return board.checkWinner();
    }

    public boolean checkDraw() {
        return board.checkForDraw();
    }
}