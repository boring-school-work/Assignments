import java.util.Scanner;

public class ExDemoOne {
  /**
   * sumOddN takes an integer, n and returns the sum of
   * all the odd postive integers less than or equal to n
   *
   * @param int n
   *
   * @return sum of postive odd integers less than or equal to n
   *
   */
  static int sumOddN(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i += 2) {
      sum += i;
    }
    return sum;
  }

  /**
   * sumEvenN takes an integer, n and returns the sum of
   * all the even postive integers less than or equal to n
   *
   * @param int n
   *
   * @return sum of postive even integers less than or equal to n
   *
   */
  static int sumEvenN(int n) {
    int sum = 0;
    for (int i = 2; i <= n; i += 2) {
      sum += i;
    }
    return sum;
  }

  /**
   * sumSqN takes an integer, n and returns the sum of
   * all postive squared integers less than or equal to n
   *
   * @param int n
   *
   * @return sum of all positive squared integers less than or equal to n
   *
   */
  static int sumSqN(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i * i;
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();

    System.out.printf("Sum of positive odd numbers less than or equal to %d: %d\n",
        n, sumOddN(n));
    System.out.printf("Sum of positive even numbers less than or equal to %d: %d\n",
        n, sumEvenN(n));
    System.out.printf("Sum of all squared positive numbers less than or equal to %d: %d\n",
        n, sumSqN(n));
    input.close(); // close the Scanner
  }
}
