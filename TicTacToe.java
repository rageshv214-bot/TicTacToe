public class TicTacToe {
    public static void main(String[] args) {
        // UC1: Create and initialize 3x3 board
        char[][] board = new char[3][3];
        initializeBoard(board);

        System.out.println("Welcome to Tic-Tac-Toe!");
        displayBoard(board);
    }

    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
} 