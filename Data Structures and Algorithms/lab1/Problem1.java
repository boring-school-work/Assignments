import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 * What does the program do?
 *
 * @author David Saah
 * @version 1.0
 * @since 27-08-2023
 *
 */
public class Problem1 {

  public static int getRandomValue() {
    Random r = new Random();
    return r.nextInt(60);
  }

  public static String[] loadData(String location) {
    BufferedReader br = null;
    String[] data = new String[60];

    try {
      FileReader f = new FileReader(location);
      br = new BufferedReader(f);

      for (int i = 0; i < 60; i++) {
        data[i] = br.readLine();
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    } finally {
      try {
        br.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return data;
  }

  public static void main(String[] args) {
    String[] countries = loadData("./countries.csv");

    for (String country : countries) {
      System.out.println(country);
    }
    System.out.println(getRandomValue());
  }
}
