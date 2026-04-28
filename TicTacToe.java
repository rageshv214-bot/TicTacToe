/**
 * TicTacToe
 * UC8 controls the continuous game loop and alternates
 * turns until the game ends.
 */
public class TicTacToe {

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    /**
     * Entry point of the program. Demonstrates the structure
     * of a continuous game loop.
     */
    public static void main(String[] args) {
        
        System.out.println("Game Started!");

        // UC8: Continuous loop until game ends
        while (!gameOver) {
            if (isHumanTurn) {
                System.out.println("--- Human's Turn ---");
                // Here we would call getUserSlot(), validate, and placeMove()
                
                // For demonstration, we switch turn manually
                isHumanTurn = false; 
            } else {
                System.out.println("--- Computer's Turn ---");
                // Here we would call computerMove()
                
                isHumanTurn = true;
            }

            // UC8 Logic: In a full game, we would check for win/draw here
            // To prevent an infinite loop during this UC test, we set a condition
            // Example: gameOver = checkWin() || checkDraw();
            
            // Temporary break for testing this specific UC
            gameOver = true; 
        }
        
        System.out.println("Game Over!");
    }
}