package connectfour;

public class Board{

    private static int col = 7;
    private static int row = 6;
    private int[][] board = new int[row][col];

    public void getBoard() {

        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(0));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(1));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(2));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(3));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(4));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(5));
        System.out.println("|---|---|---|---|---|---|---|");
        System.out.println(getRow(6));
        System.out.println("|---|---|---|---|---|---|---|");
    }

    private String getRow(int r) {
        //Instantiating a StringBuilder object to create modifiable string
        StringBuilder newRow = new StringBuilder("| ");

        //Looping through every row and appending appropriate values contingent on the board matrix values
        for(int i = 0; i < col; i++) {
            if (board[r][i] == 0) {
                newRow.append("-");
            }
            if (board[r][i] == 1) {
                newRow.append("O");
            }
            if (board[r][i] == 2) {
                newRow.append("X");
            }
            newRow.append(" | ");
        }

        newRow.deleteCharAt(newRow.lastIndexOf(" "));
        return newRow.toString();
    }

    private boolean isColumnFull(int column) {
        return(board[0][column - 1] == 1 ||board[0][column - 1] == 2);
    }

    private boolean validInput(int input) {
        return
        ((input == 1) || 
        (input == 2) || 
        (input == 3) ||
        (input == 4) || 
        (input == 5) || 
        (input == 6) || 
        (input == 7));
    }
    
    /**
     * Gets the next available row for a given column slot
     * @param column
     * @return
     */
    private int getNextSlot(int column) { 
        int pos = 5;
        boolean found = false;

        while(pos >= 0 && !found) {
            if(!(board[pos][column] == 1) && !(board[pos][column] == 2)){
                found = true;
            }else {
                pos--;
            }
        }
        return pos;
    }
    /**
     * Function: placePiece
     * Places a piece in the selected column on the next available spot
     * @param player
     * @return
     */
    public int placePiece(Player player) {

        int colChoice = player.getMove() - 1;
        String symbol = player.getPiece();

        if (isColumnFull(colChoice)){
            return 0;
        }

        if (symbol.equals("X"))
        {
            board[getNextSlot(colChoice)][colChoice] = 1;
        } else {
            board[getNextSlot(colChoice)][colChoice] = 2;
        }

        return 1;
    }

    /**
     * Returns true if Board is full
     * @return
     */
    private boolean isBoardFull() {
        boolean full = true;

        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(board[i][j] == 1 || board[i][j] == 2)
                {
                    full = false;
                }
            }
        }
        return full;
    }

    /**
     * Check Vertical win Conditions
     * @return
     */
    private int checkVerticalWinner() {

        int winner = 0;

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == board[i+1][j] &&
                (board[i][j] == board[i +2][j]) && 
                (board[i][j] == board[+3][j]) && 
                board[i][j] != 0) {
                    winner = board[i][j];
                }
            }
        }

        return winner;
    }

    private int checkHorizontalWinner() {

        int winner = 0;

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] == board[i][j+1] &&
                (board[i][j] == board[i][j+2]) && 
                (board[i][j] == board[i][j+3]) && 
                board[i][j] != 0) {
                    winner = board[i][j];
                }
            }
        }

        return winner;
    }

    private int checkLeftDiagonalWinner() {

        int winner = 0;

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] == board[i+1][j+1] &&
                (board[i][j] == board[i+2][j+2]) && 
                (board[i][j] == board[i+3][j+3]) && 
                board[i][j] != 0) {
                    winner = board[i][j];
                }
            }
        }

        return winner;
    }

    private int checkRightDiagonalWinner() {

        int winner = 0;

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] == board[i+1][j-1] &&
                (board[i][j] == board[i+2][j-2]) && 
                (board[i][j] == board[i+3][j-3]) && 
                board[i][j] != 0) {
                    winner = board[i][j];
                }
            }
        }

        return winner;
    }

    private int checkWinner() {

        int winner = 0;

        if(checkVerticalWinner() == 1 || checkVerticalWinner() == 2) {
            winner = checkVerticalWinner();
        }else if(checkHorizontalWinner() == 1 || checkHorizontalWinner() == 2) {
            winner = checkHorizontalWinner();
        }else if(checkLeftDiagonalWinner() == 1 || checkLeftDiagonalWinner() == 2) {
            winner = checkLeftDiagonalWinner();
        }else if (checkRightDiagonalWinner() == 1 || checkRightDiagonalWinner() == 2) {
            winner = checkRightDiagonalWinner();
        }

        return winner;
    }

    private boolean checkForDraw() {
        return(isBoardFull() == true &&(checkWinner() != 1 && checkWinner() != 2));
    }

}