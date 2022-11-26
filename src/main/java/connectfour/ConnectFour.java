package connectfour;
/**
 * This class is a Template for the ConnectFour Object
 * <p>
 * Composition of: 
 * 1 Board Object
 * 2 Player Objects
 * 1 FileIO Object
 * 1 Integer instance variable to represent turn 1 for X 2 for 0
 * </p>
 * <p>
 * This class is responsible for winners, draws, loading, saving
 * </p>
 * @author Wali Temuri - 1183379
 */
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
    /**
     * Loading Game Method, uses fileIO to read from CSV file
     * 
     * Returns void
     * 
     * @param String file name
     * @return void
     */
    public void loadGame(String fileName) {
       int[][]  matrix = new int[6][7];
       matrix = fileIO.fileReader(fileName);
       setBoard(matrix);
    }
    /**
     * Saving Game Method, uses fileIO to write to CSV file
     * 
     * Returns void
     * 
     * @param String file name
     * @return void
     */
    public void saveGame() {
        int[][]  matrix = new int[6][7];
        matrix = board.getMatrix();
        fileIO.fileWriter(matrix);
    }
    /**
     * Sets the board matrix in board instance
     * 
     * Returns void
     * 
     * @param Int[][] matrix
     * @return void
     */
    public void setBoard(int[][] matrix) {
        board.setBoard(matrix);
    }
    /**
     * Places piece in board instance
     * 
     * Returns void
     * 
     * @param Void 
     * @return void
     */
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

    public void clearBoard() {
        board.clearBoardMatrix();
    }
}