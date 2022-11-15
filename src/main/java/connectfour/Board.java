package connectfour;

public class Board {

    private static int col = 7;
    private static int row = 6;
    private int[][] matrix = new int[row][col];

    /**
     * 
     */
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
    }

    private String getRow(int r) {
        //Instantiating a StringBuilder object to create modifiable string
        StringBuilder newRow = new StringBuilder("| ");

        //Looping through every row and appending appropriate values contingent on the matrix matrix values
        for(int i = 0; i < col; i++) {
            if (matrix[r][i] == 0) {
                newRow.append("-");
            }
            if (matrix[r][i] == 1) {
                newRow.append("X");
            }
            if (matrix[r][i] == 2) {
                newRow.append("O");
            }
            newRow.append(" | ");
        }

        newRow.deleteCharAt(newRow.lastIndexOf(" "));
        return newRow.toString();
    }

    public boolean isColumnFull(int column) {
        if(column <= 0) {
            return false;
        }

        return(matrix[0][column - 1] == 1 || matrix[0][column - 1] == 2);
    }

    /**
     * Gets the next available row for a given column slot
     * @param column
     * @return
     */
    private int getNextSlot(int column) { 
        int pos = 5;
        boolean found = false;
        
        if(column < 0) {
            return 0;
        }

        while(pos >= 0 && !found) {
            if(!(matrix[pos][column] == 1) && !(matrix[pos][column] == 2)){
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
    public void placePiece(Player player) {
        String symbol = player.getPiece();
        int colChoice = player.getMove() - 1;

        if (colChoice < 0) {
            return;
        }
        
        if (isColumnFull(colChoice + 1)){
            return;
        }

        if (symbol == "X"){
            matrix[getNextSlot(colChoice)][colChoice] = 1;
        } else {
            matrix[getNextSlot(colChoice)][colChoice] = 2;
        }       

    }

    /**
     * Returns true if matrix is full
     * @return
     */
    private boolean isBoardFull() {
        boolean full = true;

        for(int j = 0; j < col; j++) {
            for(int i = 0; i < row; i++) {
                if(matrix[i][j] == 0) {
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
        int i;
        int j;

        for (i = 0; i < row - 3; i++) {
            for(j = 0; j < col; j++) {
                if((matrix[i][j] == 1)
                && (matrix[i+1][j] == 1)
                && (matrix[i+2][j] == 1)
                && (matrix[i+3][j] == 1)) {
                    winner = matrix[i][j];
                }
            }
        }
        for (i = 0; i < row - 3; i++) {
            for(j = 0; j < col; j++) {
                if((matrix[i][j] == 2)
                && (matrix[i+1][j] == 2)
                && (matrix[i+2][j] == 2)
                && (matrix[i+3][j] == 2)) {
                    winner = matrix[i][j];
                }
            }
        }

        return winner;
    }

    private int checkHorizontalWinner() {

        int winner = 0;
        int i;
        int j;

        for(j = 0; j < col - 3; j++) {
            for(i = 0; i < row; i++) {
                if((matrix[i][j] == 1) 
                && (matrix[i][j+1] == 1) 
                && (matrix[i][j+2] == 1)
                && (matrix[i][j+3] == 1)) {
                    winner = matrix[i][j];
                }
            }
        }

        for(j = 0; j < col - 3; j++) {
            for(i = 0; i < row; i++) {
                if((matrix[i][j] == 2) 
                && (matrix[i][j+1] == 2) 
                && (matrix[i][j+2] == 2)
                && (matrix[i][j+3] == 2)) {
                    winner = matrix[i][j];
                }
            }
        }

        return winner;
    }

    private int checkLeftDiagonalWinner() {

        int winner = 0;
        int i;
        int j;

        for(i = 3; i < row; i++) {
            for(j = 0; j < col - 3; j++) {
                if((matrix[i][j] == 1) 
                && (matrix[i-1][j+1] == 1) 
                && (matrix[i-2][j+2] == 1)
                && (matrix[i-3][j+3] == 1)) {
                    winner = matrix[i][j];
                }
            }
        }
        for(i = 3; i < row; i++) {
            for(j = 0; j < col - 3; j++) {
                if((matrix[i][j] == 2) 
                && (matrix[i-1][j+1] == 2) 
                && (matrix[i-2][j+2] == 2)
                && (matrix[i-3][j+3] == 2)) {
                    winner = matrix[i][j];
                }
            }
        }

        return winner;
    }

    private int checkRightDiagonalWinner() {

        int winner = 0;
        int i;
        int j;

        for(i = 3; i < row; i++) {
            for(j = 3; j < col; j++) {
                if((matrix[i][j] == 1) 
                && (matrix[i-1][j-1] == 1) 
                && (matrix[i-2][j-2] == 1)
                && (matrix[i-3][j-3] == 1)) {
                    winner = matrix[i][j];
                }
            }
        }

        for(i = 3; i < row; i++) {
            for(j = 3; j < col; j++) {
                if((matrix[i][j] == 2) 
                && (matrix[i-1][j-1] == 2) 
                && (matrix[i-2][j-2] == 2)
                && (matrix[i-3][j-3] == 2)) {
                    winner = matrix[i][j];
                }
            }
        }

        return winner;
    }

    public int checkWinner() {
        if(checkVerticalWinner() == 1 || checkVerticalWinner() == 2) {
            return checkVerticalWinner();
        }else if(checkHorizontalWinner() == 1 || checkHorizontalWinner() == 2) {
            return checkHorizontalWinner();
        }else if(checkLeftDiagonalWinner() == 1 || checkLeftDiagonalWinner() == 2) {
            return checkLeftDiagonalWinner();
        }else if (checkRightDiagonalWinner() == 1 || checkRightDiagonalWinner() == 2) {
            return checkRightDiagonalWinner();
        }
        return 0;
    }

    public boolean checkForDraw() {
        return(isBoardFull() && (checkWinner() != 1 && checkWinner() != 2));
    }

}