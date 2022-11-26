package connectfour;

/**
 * This class is a Template for the Player Object
 * <p>
 * This class handles mutating and accessing player piece "X" or "O"
 * </p>
 * <p>
 * This class also updates the move the user is currently wanting to play
 * </p>
 * @author Wali Temuri - 1183379
 */
public class Player {
    
    private String piece;
    private int move;
     
    /**
     * Sets the piece of a Player object
     * 
     * Returns void
     * 
     * @param String containing the selected piece
     * @return void
     */
    public  void setPiece(String playerpiece) {

        piece = playerpiece;
    }
     /**
     * Sets the currentMove attribute of Player object
     * 
     * Returns void
     * 
     * @param int containing the move Player intends to make
     * @return void
     */
    public void setMove(int m) {

        move = m;
    }
     /**
     * Get the piece of the Player 
     * 
     * Returns String 
     * 
     * @param void
     * @return String containing the piece of Player 
     */
    public String getPiece() {
        return piece;
    }
    /**
     * Prints out the instructions for the Game
     * 
     * Returns int
     * 
     * @param void
     * @return integer containing the move Player intends to make
     */
    public int getMove() {
        return move;
    }

    @Override
    public String toString() {
        String playerProfile = piece + " " + Integer.toString(move);
        return playerProfile;
    }
}
