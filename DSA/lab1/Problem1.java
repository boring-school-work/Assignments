import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * A country/capital quiz simulation.
 *
 * @author David Saah
 * @version 1.0
 * @since 27-08-2023
 */
public class Problem1 {

  /**
   * Gets a random value between 0 and 60 (excluded)
   *
   * @return a random integer
   */
  public static int getRandomValue() {
    Random r = new Random();
    return r.nextInt(60);
  }

  /**
   * Loads data from a file and store it in an array
   *
   * @param location the file path
   *
   * @return an array of strings loaded from the file
   */
  public static String[] loadData(String location) {
    BufferedReader br = null;
    String[] data = new String[60];

    try {
      br = new BufferedReader(new FileReader(location)); // load file into a buffered reader

      // add each line in the file to the array
      for (int i = 0; i < 60; i++) {
        data[i] = br.readLine();
      }

    } catch (Exception e) {
      System.out.println(e.toString());
    } finally {
      try {
        br.close(); // close the buffered reader
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    }

    return data;
  }

  public static void main(String[] args) {
    String[] countries = loadData("./countries.csv"); // file in the format: country,capital
    Scanner input = new Scanner(System.in);
    byte score = 0;

    for (int i = 0; i < 20; i++) {
      String c = countries[getRandomValue()]; // returns "country,capital"
      String country = c.substring(0, c.indexOf(","));
      String capital = c.substring(c.indexOf(",") + 1);

      System.out.printf("What is the capital of %s?: ", country);
      if (input.nextLine().equalsIgnoreCase(capital)) {
        System.out.println("You guessed correctly!");
        score += 1;
      } else {
        System.out.printf("You guessed wrong! The answer is %s.\n", capital);
      }
    }

    System.out.println();
    System.out.printf("You have completed the quiz.");
    System.out.printf("You correctly answered %d questions.\n", score);

    input.close(); // close the Scanner
  }
}
