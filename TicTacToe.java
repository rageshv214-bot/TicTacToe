/**
 * TicTacToe
 * UC9 checks whether a player has won by examining
 * rows, columns, and diagonals.
 */
public class TicTacToe {

    static char[][] board = new char[3][3];

    /**
     * Entry point of the program. Tests the win-check logic.
     */
    public static void main(String[] args) {
        // Sample setup for testing a row win
        board[0][0] = 'X'; board[0][1] = 'X'; board[0][2] = 'X';
        
        System.out.println("Has X won? " + hasWon('X'));
    }

    /**
     * Checks all possible winning patterns for the given symbol.
     * Input: Player symbol
     * Output: true if win detected.
     */
    static boolean hasWon(char symbol) {
        // 1. Check Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        // 2. Check Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }

        // 3. Check Diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }
}