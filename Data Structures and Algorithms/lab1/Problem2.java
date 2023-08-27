/**
 * What does the program do?
 *
 * @author David Saah
 * @version 1.0
 * @since 27-08-2023
 *
 */
public class Problem2 {
  public static void main(String[] args) {
    String[] words = Problem1.loadData("./words.csv");

    for (String word : words) {
      System.out.println(word);
    }

    System.out.println(Problem1.getRandomValue());
  }
}
