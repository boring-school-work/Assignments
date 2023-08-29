import java.util.Scanner;

/**
 * A program simulating the hangman game using words.
 * The program prompts the user to guess one letter at a time.
 * For the first time, each letter in the word is displayed as an asterisk.
 * When the user makes a correct guess, the actual letter is exposed.
 * When the user finishes a word by guessing all the letters, the
 * program displays the number of misses and asks the user whether to continue
 * to play with another word.
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

    while (true) {
      System.out.println();

      // reuse getRandomValue from Problem1 to get a random number
      // the random number is used to get a random word from the words array
      word = words[Problem1.getRandomValue()];

      hiddenWord = "*".repeat(word.length()); // hide word with asterisks
      byte misses = 0;

      // continue to prompt user until the word is guessed correctly
      // i.e the hiddenWord does not contain any asterisk
      while (hiddenWord.contains("*")) {
        System.out.printf("Guess and enter a letter in the word %s > ", hiddenWord);
        guess = input.nextLine();

        // check if user's guess has already been revealed
        if (hiddenWord.contains(guess)) {
          System.out.printf("\t%s has already been revealed.\n", guess);
          continue;
        }

        // check if user's guess is in the word
        if (word.contains(guess)) {
          // reveal all instances of the user's guess in the hiddenWord
          for (byte i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
              // hidden word = beginning of hidden word + guess + rest of hidden word
              hiddenWord = hiddenWord.substring(0, i) + guess + hiddenWord.substring(i + 1);
            }
          }
        } else {
          System.out.printf("\t%s is not in the word.\n", guess);
          misses++;
        }
      }

      System.out.println();
      System.out.printf("The word is %s. You missed %d time(s)\n", word, misses);

      System.out.print("Do you want to play again? [Y/n]: ");
      if (input.nextLine().equalsIgnoreCase("n")) {
        break;
      }
    }

    System.out.println();
    System.out.println("Sorry to see you go. Thanks for playing!");
    input.close();

  }
}
