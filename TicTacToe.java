/**
 * TicTacToe
 * UC5 validates whether a move is inside the board boundaries
 * and whether the selected cell is empty.
 */
public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests the validation logic
     * using sample row and column values.
     */
    public static void main(String[] args) {
        // Testing a valid middle-cell move (1, 1)
        System.out.println("Is move (1, 1) valid? " + isValidMove(1, 1));
    }

    /**
     * Checks if the given row and column are within bounds
     * and if the target cell is empty.
     * Input: Row, Column
     * Output: true if valid, false otherwise.
     */
    static boolean isValidMove(int row, int col) {
        // Check 1: Boundary Check (Must be between 0 and 2)
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check 2: Availability Check (Must be '-')
        if (board[row][col] != '-') {
            return false;
        }

        // If both checks pass, the move is valid
        return true;
    }
}