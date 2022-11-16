package connectfour;

public class ConnectFour{

    private Board board = new Board();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private FileIO fileIO = new FileIO();
    private int turn;

    public void setTurn(int n) {
        turn = n;
    }

    public int getTurn() {
        return turn;
    }

    public void swapTurn() {
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }

    public void setPlayerOneSymbol(String symbol) {
        player1.setPiece(symbol);
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

    public void getInstructions() {
        System.out.println("\nSelect following inputs to place your piece in the column\n");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println("Enter 10 to quit and save your game");

    }

    public void loadGame(String fileName) {
       int[][]  matrix = new int[6][7];
       matrix = fileIO.fileReader(fileName);
       setBoard(matrix);
    }

    public void saveGame() {
        int[][]  matrix = new int[6][7];
        matrix = board.getMatrix();
        fileIO.fileWriter(matrix);
    }

    public void setBoard(int[][] matrix) {
        board.setBoard(matrix);
    }

    public void placePiece() {
        if (turn == 1) {
            board.placePiece(player1.getMove(), player1.getPiece());
        } else {
            board.placePiece(player2.getMove(), player2.getPiece());
        }
    }

    public int winningPlayer() {
        return board.checkWinner();
    }

    public boolean checkDraw() {
        return board.checkForDraw();
    }
 
    public boolean isColumnFull(int n) {
           return board.isColumnFull(n);
    }

    public void getCurrBoard() {
        board.getBoard();
    }
}