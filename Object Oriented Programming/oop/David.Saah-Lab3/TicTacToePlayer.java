import java.util.Scanner;

/**
 * This class represents a player of Tic-Tac-Toe Game
 *
 * @author G. Ayorkor Korsah
 * @author David Saah
 * @version 2.0
 * @since 2023-03-29
 *
 */
public class TicTacToePlayer {
    private String name;
    private String symbol;

    /**
     * Reads in the player's name and desired symbol
     * It allows only non-digit single characters as symbols
     *
     */
    public void getPlayerInfo() {
        Scanner getInput = new Scanner(System.in);
        String pattern = "[^\\d]";
        String answer;

        System.out.print("What is your name?: ");
        name = getInput.next();

        // check the validity of chosen symbol
        do {
            System.out.print("What symbol would you like to use?: ");
            answer = getInput.next();

            if (!answer.matches(pattern)) {
                System.out.println(
                        "\nError: Your symbol must be exactly one character, and cannot be a digit!\nTry again!\n");
            } else {
                symbol = answer;
            }
        } while (!answer.matches(pattern));

        // closing the scanner object closes the input stream for the program
        // this means that no more input can be read from the console
        // it is best to leave the scanner open until the program terminates

    }

    /**
     * Gets player's name
     *
     * @return the name of the player
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's symbol
     *
     * @return the symbol the player will use in the game
     * 
     */
    public String getSymbol() {
        return symbol;
    }
}
