import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    // Shared variables (State Management)
    static char[][] board = new char[3][3];
    static char playerSymbol, computerSymbol;
    static String currentPlayer;
    static boolean gameOver = false;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard(); // UC1
        System.out.println("--- Welcome to Tic-Tac-Toe ---");
        
        performToss(); // UC2
        System.out.println(currentPlayer + " starts first.");

        // UC8: The Main Game Loop
        while (!gameOver) {
            displayBoard(); // UC1
            
            if (currentPlayer.equals("Player")) {
                int slot = getUserSlot(); // UC3
                int row = getRowFromSlot(slot); // UC4
                int col = getColFromSlot(slot); // UC4
                
                if (isValidMove(row, col)) { // UC5
                    placeMove(row, col, playerSymbol); // UC6
                    if (hasWon(playerSymbol)) { // UC9
                        displayBoard();
                        System.out.println("Game Over: You Win!");
                        gameOver = true;
                    }
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue; // Skip turn switch if move was invalid
                }
            } else {
                computerMove(); // UC7
                if (hasWon(computerSymbol)) { // UC9
                    displayBoard();
                    System.out.println("Game Over: Computer Wins!");
                    gameOver = true;
                }
            }

            // UC10: Check for Draw
            if (!gameOver && isDraw()) {
                displayBoard();
                System.out.println("Game Over: It's a Draw!");
                gameOver = true;
            }

            currentPlayer = currentPlayer.equals("Player") ? "Computer" : "Player";
        }
    }

    // --- Methods from all Use Cases ---

    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) board[i][j] = '-';
    }

    static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static void performToss() {
        if (Math.random() < 0.5) {
            currentPlayer = "Player"; playerSymbol = 'X'; computerSymbol = 'O';
        } else {
            currentPlayer = "Computer"; computerSymbol = 'X'; playerSymbol = 'O';
        }
    }

    static int getUserSlot() {
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    static int getRowFromSlot(int slot) { return (slot - 1) / 3; }
    static int getColFromSlot(int slot) { return (slot - 1) % 3; }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-';
    }

    static void placeMove(int row, int col, char symbol) { board[row][col] = symbol; }

    static void computerMove() {
        Random rand = new Random();
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int r = (slot - 1) / 3;
            int c = (slot - 1) % 3;
            if (board[r][c] == '-') {
                board[r][c] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    static boolean hasWon(char s) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == s && board[i][1] == s && board[i][2] == s) return true;
            if (board[0][i] == s && board[1][i] == s && board[2][i] == s) return true;
        }
        return (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
               (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }

    static boolean isDraw() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++) if (board[r][c] == '-') return false;
        return true;
    }
}