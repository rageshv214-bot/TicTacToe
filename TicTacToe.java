import java.util.Random;

/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move
 * by reusing slot conversion and validation logic.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };
    static char computerSymbol = 'O';

    /**
     * Entry point of the program. Triggers the computer move.
     */
    public static void main(String[] args) {
        computerMove();
        // Display board to verify move
        for (char[] row : board) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     */
    static void computerMove() {
        Random rand = new Random();
        boolean moved = false;

        while (!moved) {
            // Generate random slot between 1 and 9
            int slot = rand.nextInt(9) + 1;
            
            // Reuse logic from previous UCs (Map slot to indices)
            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            // Reuse validation logic
            if (board[row][col] == '-') {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                moved = true;
            }
        }
    }
}