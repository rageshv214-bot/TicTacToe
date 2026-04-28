

public class TicTacToe {
    // Global variables to track game state
    static char playerSymbol;
    static char computerSymbol;
    static String currentPlayer;

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);
        
        System.out.println("Welcome to Tic-Tac-Toe!");
        
        // UC2: Perform Toss and Assign Symbols
        performToss();
        
        System.out.println("Toss Result: " + currentPlayer + " starts first.");
        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        
        displayBoard(board);
    }

    public static void performToss() {
        // Randomly choose 0 or 1
        int toss = (int) (Math.random() * 2);
        
        if (toss == 0) {
            currentPlayer = "Player";
            playerSymbol = 'X';
            computerSymbol = 'O';
        } else {
            currentPlayer = "Computer";
            computerSymbol = 'X';
            playerSymbol = 'O';
        }
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