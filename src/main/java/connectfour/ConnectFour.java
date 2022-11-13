package connectfour;

public class ConnectFour{

    private Board board = new Board();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private int turn;

    public void setTurn(int n)
    {
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

    public void setBoard(Board b)
    {
        board = b;
    }

    public void setPlayerOne(Player player)
    {
        player1 = player;
    }

    public void setPlayerTwo(Player player)
    {
        player2 = player;
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

}