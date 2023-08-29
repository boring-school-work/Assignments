import java.util.Scanner;

/**
 * A program simulating the hangman game using words.
 *
 * @author David Saah
 * @version 1.0
 * @since 27-08-2023
 *
 */
public class Problem2 {
  public static void main(String[] args) {
    String[] words = Problem1.loadData("./words.csv"); // reuse loadData from Problem1 to load words
    Scanner input = new Scanner(System.in);
    String guess, word, hiddenWord;

    // reuse getRandomValue from Problem1 to get a random number
    word = words[Problem1.getRandomValue()];

    System.out.println(word);
    hiddenWord = "*".repeat(word.length());
    System.out.printf("Guess and enter a letter in the word %s > ", hiddenWord);
    guess = input.nextLine();

    if (word.contains(guess)) {
      int pos = word.indexOf(guess);
      System.out.println(pos);
    }

    // System.out.print("Do you want to play again? [Y/n]: ");
    // if (input.nextLine().equalsIgnoreCase("n")) {
    // break;
    // }

    input.close();
  }
}
