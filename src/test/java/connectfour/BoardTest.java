package connectfour;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
public class BoardTest{

   private Board board;

    @Before
    public void setup(){
        board = new Board();
    }

    @Test
    public void matrixMustBeOneInEvenColumnAndTwoInOdd() {
        int[][] testMatrix = new int[6][7];

        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                if(j % 2 == 0) {
                    testMatrix[i][j] = 1;
                }else {
                    testMatrix[i][j] = 2;
                }
            }
        }
        board.setBoard(testMatrix);
        testMatrix = board.getMatrix();
        Assert.assertEquals(1, testMatrix[0][2]);
        Assert.assertEquals(2, testMatrix[0][1]);
        Assert.assertEquals(1, testMatrix[5][2]);
        Assert.assertEquals(2, testMatrix[3][1]);
    }

    @Test 
    public void isColumnFull() {
        int col = 1;
        int col2 = 4;

        int[][] testMatrix = new int[6][7];

        //Filling col
        for (int i = 0; i < 6; i++) {
            testMatrix[i][0] = 1;
        }

        //Filling col2
        for(int j = 0; j < 6; j++) {
            testMatrix[j][3] = 2;
        }
        board.setBoard(testMatrix);
        Assert.assertTrue(board.isColumnFull(col));
        Assert.assertTrue(board.isColumnFull(col2));
        Assert.assertFalse(board.isColumnFull(6));
    }

    @Test
    public void placeXInFirstAndSecondColumn() {
        int[][] testMatrix = new int[6][7];
        board.setBoard(testMatrix);
        String symbol1 = "X";
        String symbol2 = "O";
        int colChoice1 = 1;
        int colChoice2 = 2;

        board.placePiece(colChoice1, symbol1);
        board.placePiece(colChoice2, symbol2);

        testMatrix = board.getMatrix();
        Assert.assertEquals(1, testMatrix[5][0]);
        Assert.assertEquals(2, testMatrix[5][1]);
    }

    @Test
    public void checkWinConditions() {
        int[][] testMatrix1 = new int[6][7];
        int[][] testMatrix2 = new int[6][7];
        int[][] testMatrix3 = new int[6][7];
        int[][] testMatrix4 = new int[6][7];

        //Vertical Win
        for (int i = 5; i > 1; i--) {
            testMatrix1[i][0] = 1;
        }

        //Horizontal Win
        for (int i = 0; i < 4; i++) {
            testMatrix2[5][i] = 2;
        }

        //Left Diagonal Win
        testMatrix3[5][0] = 1;
        testMatrix3[4][1] = 1;
        testMatrix3[3][2] = 1;
        testMatrix3[2][3] = 1;
        //Right Diagonal Win
        testMatrix4[5][6] = 2;
        testMatrix4[4][5] = 2;
        testMatrix4[3][4] = 2;
        testMatrix4[2][3] = 2;

        board.setBoard(testMatrix1);
        Assert.assertEquals(1, board.checkWinner());
        board.setBoard(testMatrix2);
        Assert.assertEquals(2, board.checkWinner());
        board.setBoard(testMatrix3);
        Assert.assertEquals(1,board.checkWinner());
        board.setBoard(testMatrix4);
        Assert.assertEquals(2,board.checkWinner());
    }

    @Test 
    public void isBoardFullShouldBeTrue() {
        int[][] testMatrix = new int[6][7];

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                testMatrix[i][j] = 1;
            }
        }
        board.setBoard(testMatrix);
        Assert.assertTrue(board.isBoardFull());
    }
}