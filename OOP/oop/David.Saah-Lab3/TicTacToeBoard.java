import java.util.Scanner;

/**
 * This class represents the board for Tic-Tac-Toe.
 *
 * @author G. Ayorkor Korsah
 * @author David Saah
 * @version 2.0
 * @since 2023-03-29
 *
 */
public class TicTacToeBoard {
    private String[][] board; // game board
    private int numEmpty; // the number of empty slots
    private boolean detectedWin; // whether or not a winner has been seen
    private String winningSymbol; // the symbol of the winner
    private static final int SIZE = 3; // dimension of board
    public static final String EMPTY = "."; // represents an empty slot on the board

    /**
     * Instantiates the 3x3 board and initialises it to be empty.
     *
     */
    public TicTacToeBoard() {
        detectedWin = false;
        winningSymbol = "";
        board = new String[SIZE][SIZE];
        numEmpty = SIZE * SIZE;

        // initialise the board to be empty
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    /**
     * Prints the board
     *
     */
    public void printBoard() {

        System.out.print("\t");

        // diplay column numbers
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(i + "\t");
        }

        // space out the board to make it more visible
        System.out.println();
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            // display row numbers
            System.out.print(i + "\t");

            // display the board values
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }

            // space out the board to make it more visible
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Checks if the board is full
     *
     * @return whether or not the board is full
     *
     */
    public boolean isBoardFull() {
        return numEmpty == 0;
    }

    /**
     * Checks if a specified location on the board is empty
     *
     * @param row the row of the board
     * @param col the column of the board
     * 
     * @return whether or not the location is empty
     *
     */
    public boolean isEmpty(int row, int col) {
        return board[row][col].equals(EMPTY);
    }

    /**
     * Checks the game for a win
     * Updates the detectedWin variable if there is a win
     * Updates the winningSymbol variable with the symbol of the player who won
     *
     * @param symbol a player's symbol
     *
     */
    public void detectWin(String symbol) {
        /*
         * For there to be a win, there has be an alignment of the same symbols
         * on the board.
         * The size of the alignment is 3 (which is SIZE)
         *
         */

        // create a string to represent a win pattern
        String winPattern = symbol.repeat(SIZE);

        // create a string to store row & column patterns
        String rowPattern = "";
        String colPattern = "";

        // create strings to store diagonal patterns
        String diagPattern1 = "";
        String diagPattern2 = "";

        // check patterns in the board
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                // store current patterns across rows and columns
                rowPattern += board[i][j];
                colPattern += board[j][i];
            }

            // check if the current column or row pattern fits the win pattern
            if (rowPattern.equals(winPattern) ||
                    colPattern.equals(winPattern)) {
                detectedWin = true;
                winningSymbol = symbol;
                return;
            }

            // store the current diagonal patterns on the board
            diagPattern1 += board[i][i];
            diagPattern2 += board[i][2 - i];

            // reset the row and column patterns
            rowPattern = "";
            colPattern = "";
        }

        // check if diagonal patterns fits the win pattern
        if (diagPattern1.equals(winPattern) ||
                diagPattern2.equals(winPattern)) {
            detectedWin = true;
            winningSymbol = symbol;
            return;
        }
    }

    /**
     * Allows a player to play a move on the board
     * 
     * @param row    the row on the board
     * @param col    the column on the board
     * @param symbol the player's symbol
     * 
     * @return whether or not the move was successful
     * 
     */
    public boolean play(int row, int col, String symbol) {
        // check if row and column input are valid
        if ((row >= SIZE) || (col >= SIZE)) {
            System.out.println("\nError: Invalid row or column!\nTry again\n");
            return false;
        }

        // check if the location is empty
        // and place the symbol on the board
        if (isEmpty(row, col)) {
            board[row][col] = symbol;
            numEmpty--;
            detectWin(symbol);
            return true;
        } else {
            System.out.println("\nError: Location is not empty!\nTry again\n");
        }

        return false;
    }

    /**
     * Checks whether there is a winner when the game ends
     * 
     * @return the boolean value of detectedWin
     * 
     */
    public boolean hasWinner() {
        return detectedWin;
    }

    /**
     * Gets the symbol of the player who won the game
     * 
     * @return the winning symbol
     * 
     */
    public String getWinningSymbol() {
        return winningSymbol;
    }

    /**
     * Test the Game Board
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        TicTacToeBoard board = new TicTacToeBoard();
        board.printBoard();

        // initialize row and column variables
        int row, col;

        // create two players
        TicTacToePlayer player1 = new TicTacToePlayer();
        TicTacToePlayer player2 = new TicTacToePlayer();

        player1.getPlayerInfo();
        player2.getPlayerInfo();

        // create a boolean to keep track of whose turn it is
        boolean whosTurn = true;

        // game loops until board is full or there is a winner
        while (!board.isBoardFull() && !board.hasWinner()) {
            System.out.println();
            board.printBoard();

            // check whose turn it is
            System.out.printf("\n%s's turn \n", whosTurn ? player1.getName() : player2.getName());

            // get row and column input from the player
            System.out.print("Enter row & column to play: ");
            row = getInput.nextInt();
            col = getInput.nextInt();

            // check if the move is valid
            // if it is, update the board
            // otherwise, ask the player to try again
            if (!board.play(row, col, whosTurn ? player1.getSymbol() : player2.getSymbol())) {
                continue;
            }

            if (board.hasWinner()) {
                System.out.println("\nGame over!");
                System.out.printf("Congratulations %s! You win.\n",
                        board.getWinningSymbol().equals(player1.getSymbol()) ? player1.getName() : player2.getName());
            } else {
                System.out.println("\nBoard is full");
                System.out.println("Game over! It's a draw!");
            }

            // switch player turn
            whosTurn = !whosTurn;
        }

        getInput.close();
    }
}
