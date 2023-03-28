import java.util.Scanner;

/**
 * This program implements Tic-Tac-Toe game.
 *
 * @author G. Ayorkor Korsah
 * @author David Saah
 * @version 2.0
 * @since 2023-03-29
 *
 */
public class TicTacToeGame {

    public static void play(TicTacToeBoard board, TicTacToePlayer player) {
        Scanner getInput = new Scanner(System.in);
        int row, col; // initialize row and column variables
        boolean playSuccessful; // a boolean to check if the play was successful

        // keep asking for row and column input until the play is successful
        do {
            System.out.printf("%s's turn\n", player.getName());
            System.out.print("Enter row & column to play: ");
            row = getInput.nextInt();
            col = getInput.nextInt();
            playSuccessful = board.play(row, col, player.getSymbol());
        } while (!playSuccessful);

        System.out.println("\n       UPDATED BOARD\n");
        board.printBoard();

        // closing the scanner object closes the input stream for the program
        // this means that no more input can be read from the console
        // it is best to leave the scanner open until the program terminates

    }

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);

        TicTacToeBoard board;
        TicTacToePlayer player1, player2; // the two players of the game
        TicTacToePlayer curPlayer; // a reference to the current player
        int whoseTurn; // a number to keep track of player's turn
        boolean player2InfoIsGood = true; // a boolean to check if player2 doesn't have anything in common with player1

        board = new TicTacToeBoard();
        player1 = new TicTacToePlayer();
        player2 = new TicTacToePlayer();

        System.out.println("Welcome to Tic-Tac-Toe game!\n");
        System.out.println("Player 1, please enter your information");
        player1.getPlayerInfo();

        // keep asking for player 2's information until it is valid
        do {
            System.out.println("\nPlayer 2, please enter your information");
            player2.getPlayerInfo();

            // check if player 2's name is the same as player 1's
            if (player2.getName().equalsIgnoreCase(player1.getName())) {
                System.out.println("\nError: Sorry, that name is being used by Player 1.\nPlease try again.\n");
                player2InfoIsGood = player2InfoIsGood && false;
                // continue;
            }

            // check if player 2's symbol is the same as player 1's
            if (player2.getSymbol().equals(player1.getSymbol())) {
                System.out.println("\nError: Sorry, that symbol is being used by Player 1.\nPlease try again.\n");
                player2InfoIsGood = player2InfoIsGood && false;
                // continue;
            }

            player2InfoIsGood = true;

        } while (!player2InfoIsGood);

        // display players' information
        System.out.printf("Okay, %s is player 1 and will use symbol %s.\n",
                player1.getName(), player1.getSymbol());
        System.out.printf("Okay, %s is player 2 and will use symbol %s.\n",
                player2.getName(), player2.getSymbol());

        // ask who will go first
        System.out.println("\nLet's play!");
        System.out.print("Who will go first? (Enter 1 or 2) : ");
        whoseTurn = getInput.nextInt();
        System.out.printf("\nOkay, %s will go first.\n",
                whoseTurn == 1 ? player1.getName() : player2.getName());

        System.out.println("\n     INITIAL GAME BOARD\n");
        board.printBoard();

        // game loops until board is full or there is a winner
        do {
            curPlayer = whoseTurn == 1 ? player1 : player2;
            play(board, curPlayer);

            // switch player turn
            whoseTurn = (whoseTurn % 2) + 1;
        } while (!board.isBoardFull() && !board.hasWinner());

        // check if there is a winner or the game ended in a draw
        if (board.hasWinner()) {
            System.out.println("Game over!");
            System.out.printf("Congratulations %s! You win.\n",
                    board.getWinningSymbol().equals(player1.getSymbol()) ? player1.getName() : player2.getName());
        } else {
            System.out.println("Board is full");
            System.out.println("Game over! It's a draw!");
        }

        getInput.close();

    }
}